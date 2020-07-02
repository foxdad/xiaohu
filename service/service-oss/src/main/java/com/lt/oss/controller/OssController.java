package com.lt.oss.controller;

import com.lt.oss.service.OssService;
import com.lt.utils.ReturnResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * ClassName: OssController
 * Description:
 * date: 2020/5/24 12:50
 *
 * @author 刘腾
 * @since JDK 1.8
 */
@Api(produces = "oss对象存储")
@RestController
@RequestMapping("/oss")
//@CrossOrigin
public class OssController {
    @Autowired
    private OssService ossService;

    @ApiOperation("文件上传")
    @PostMapping("/upload")
    public ReturnResult ossFileUpload (@RequestParam("file") MultipartFile multipartFile) {

         String url = ossService.upload(multipartFile);
         if (StringUtils.isEmpty(url)) {
             return ReturnResult.failed("上传文件失败");
         }
        return ReturnResult.success("文件上传成功",url);
    }
    @PostMapping("/delete/{name}")
    public ReturnResult ossDeleteFile(@PathVariable("name") String name) {
        String s = ossService.deleteFile(name);
//        if (){
//
//        }
        return null;
    }
}
