package com.lt.oss.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.lt.oss.service.OssService;
import com.lt.oss.utils.OssUtils;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.InputStream;
import java.util.UUID;

/**
 * ClassName: OssServerImpl
 * Description:
 * date: 2020/5/24 12:51
 *
 * @author 刘腾
 * @since JDK 1.8
 */
@Slf4j
@Service
public class OssServerImpl implements OssService {

    @Override
    public String upload(MultipartFile multipartFile) {
        String endpoint = OssUtils.END_POINT;
        String accessKeyId = OssUtils.KEY_ID;
        String accessKeySecret =OssUtils.KEY_SECRET;
        String bucketName = OssUtils.BUCKET_NAME;
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        try {
            //文件名
            String originalFilename = multipartFile.getOriginalFilename();
            //拼接文件名
            String splitName = UUID.randomUUID().toString().replace("-","").substring(0, 8);
            //新的文件名
            String newFileName = splitName + "_" + originalFilename;
            // 上传文件流。
            InputStream inputStream = multipartFile.getInputStream();
            //按日期分类文件夹
            String fileDir = new DateTime().toString("yyyy/MM/dd");
            newFileName = fileDir + "/"+newFileName;

            ossClient.putObject(bucketName, newFileName, inputStream);
            //https://jiuge-guli.oss-cn-shanghai.aliyuncs.com/20181221143109383.jpg
            //返回的url拼接
            String url  = "https://"+bucketName + "."+endpoint +"/"+newFileName;
            log.info("文件上传成功"+url);
            return url;
        }catch (Exception e){
            log.error("文件上传出错");
            e.printStackTrace();
        }finally {
            // 关闭OSSClient。
            ossClient.shutdown();
        }
        return null;
    }

    @Override
    public String deleteFile(String filename) {
        String endpoint = OssUtils.END_POINT;
        String accessKeyId = OssUtils.KEY_ID;
        String accessKeySecret =OssUtils.KEY_SECRET;
        String bucketName = OssUtils.BUCKET_NAME;
        endpoint = "https://"+endpoint;
        String objectName = filename;
        System.out.println(endpoint+""+accessKeyId+""+accessKeySecret);
        System.out.println(objectName);

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 删除文件。如需删除文件夹，请将ObjectName设置为对应的文件夹名称。如果文件夹非空，则需要将文件夹下的所有object删除后才能删除该文件夹。
        //获取到文件名

        ossClient.deleteObject(bucketName, objectName);

        // 关闭OSSClient。
        ossClient.shutdown();

        return null;
    }
}
