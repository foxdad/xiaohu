package com.lt.vedio.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lt.utils.ReturnResult;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 课程视频 服务类
 * </p>
 *
 * @author 小狐
 * @since 2020-06-20
 */
public interface EduVideoService  {

    String uploadVideo(MultipartFile file);

    void deleteVedio(String vedioId);

    ReturnResult getVideoPlayAuth(String videoId, HttpServletRequest request);
}
