package com.lt.vedio.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.vod.upload.impl.UploadVideoImpl;
import com.aliyun.vod.upload.req.UploadStreamRequest;
import com.aliyun.vod.upload.resp.UploadStreamResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.vod.model.v20170321.DeleteVideoRequest;
import com.aliyuncs.vod.model.v20170321.DeleteVideoResponse;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthRequest;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthResponse;
import com.lt.config.execptionhandler.LtExecption;
import com.lt.utils.CommonEntity.Video;
import com.lt.utils.JwtUtils;
import com.lt.utils.ReturnResult;
import com.lt.vedio.client.OrderClient;
import com.lt.vedio.client.VideoClient;
import com.lt.vedio.client.hyxtris.OrderCallBack;
import com.lt.vedio.service.EduVideoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lt.vedio.utils.AliyunVodSDKUtils;
import com.lt.vedio.utils.VedioUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;

/**
 * <p>
 * 课程视频 服务实现类
 * </p>
 *
 * @author 小狐
 * @since 2020-06-20
 */
@Service
@Slf4j
public class EduVideoServiceImpl implements EduVideoService {

    @Autowired
    private VideoClient videoClient;

    @Autowired
    private OrderClient orderClient;

    @Override
    public String uploadVideo(MultipartFile file) {

        try {
            InputStream inputStream = file.getInputStream();
            //获取上传视频名
            String originalFilename = file.getOriginalFilename();
            String title = originalFilename.substring(0, originalFilename.lastIndexOf("."));

            UploadStreamRequest request = new UploadStreamRequest(
                    VedioUtils.KEY_ID,
                    VedioUtils.KEY_SECRET,
                    title, originalFilename, inputStream);

            UploadVideoImpl uploader = new UploadVideoImpl();
            UploadStreamResponse response = uploader.uploadStream(request);

            //如果设置回调URL无效，不影响视频上传，可以返回VideoId同时会返回错误码。
            // 其他情况上传失败时，VideoId为空，此时需要根据返回错误码分析具体错误原因
            String videoId = response.getVideoId();
            if (!response.isSuccess()) {
                String errorMessage = "阿里云上传错误：" + "code：" + response.getCode() + ", message：" + response.getMessage();
                log.warn(errorMessage);
                if(StringUtils.isEmpty(videoId)){
                    throw new LtExecption(20001, errorMessage);
                }
            }

            return videoId;
        } catch (IOException e) {
            throw new LtExecption(20001, "guli vod 服务上传失败");
        }
    }

    @Override
    public void deleteVedio(String vedioId) {
        try{
            DefaultAcsClient client = AliyunVodSDKUtils.initVodClient(
                    VedioUtils.KEY_ID,
                    VedioUtils.KEY_SECRET);

            DeleteVideoRequest request = new DeleteVideoRequest();

            request.setVideoIds(vedioId);

            DeleteVideoResponse response = client.getAcsResponse(request);
//            response.getInstance()
            System.out.print("RequestId = " + response.getRequestId() + "\n");
            //删除失败抛异常，前端会回显异常信息
        }catch (ClientException e){
            throw new LtExecption(20001, "视频删除失败");
        }
    }

    /**
     * 视频的凭证获取
     * @param videoId
     * @param requestFormt
     * @return
     */
    @Override
    public ReturnResult getVideoPlayAuth(String videoId, HttpServletRequest requestFormt) {
        //网关层会验证用户是否登录
        //远程调用课程的信息
        //课程是否免费
        ReturnResult chapterFlag = videoClient.getByChapterId(videoId);

//        Video flagData = new Video();
        Video flagData  =JSON.parseObject(JSONObject.toJSONString(chapterFlag.getData()),Video.class);

//        BeanUtils.copyProperties(flagData,chapterFlag.getData());
        //false为付费
        if (!flagData.getIsFree()){
            //用户id
            String memberIdByJwtToken = JwtUtils.getMemberIdByJwtToken(requestFormt);
            //课程id
            flagData.getCourseId();//
            //根据用户id查询是否已经购买了
            ReturnResult orderStatus = orderClient.getOrderStatus(memberIdByJwtToken, flagData.getCourseId());
            Boolean flagOrder = (Boolean)orderStatus.getData();
            //用户购买了
            if (flagOrder) {
                //发放凭证
              return   getPlayAuth(videoId);
            }else{
                return ReturnResult.failed("请先购买此课程");
            }
        }
        //免费播放发放凭证
       return getPlayAuth(videoId);

    }

    public ReturnResult getPlayAuth (String videoId) {
        try {
            DefaultAcsClient client = AliyunVodSDKUtils.initVodClient(
                    VedioUtils.KEY_ID,
                    VedioUtils.KEY_SECRET);
            //请求
            GetVideoPlayAuthRequest request = new GetVideoPlayAuthRequest();
            request.setVideoId(videoId);
            //响应
            GetVideoPlayAuthResponse response = client.getAcsResponse(request);
            //得到播放凭证
            String playAuth = response.getPlayAuth();

            return ReturnResult.success("允许播放此视频",playAuth);
        } catch (ClientException e) {
            throw new RuntimeException("没有权限获取");
        }
    }
}
