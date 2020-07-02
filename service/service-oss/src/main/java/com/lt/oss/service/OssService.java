package com.lt.oss.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * ClassName: OssService
 * Description:
 * date: 2020/5/24 12:51
 *
 * @author 刘腾
 * @since JDK 1.8
 */
public interface OssService {
    /**
     * 阿里的文件上传
     * @param multipartFile
     * @return
     */
    String upload(MultipartFile multipartFile);

    String deleteFile(String filename);
}
