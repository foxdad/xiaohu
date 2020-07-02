package com.lt.vedio.client;

import com.lt.utils.ReturnResult;
import com.lt.vedio.client.hyxtris.VideoCallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * ClassName: VideoClient
 * Description:
 * date: 2020/6/24 9:51
 *
 * @author 小狐
 * @since JDK 1.8
 */
@Component
@FeignClient(value = "service-edu",fallback = VideoCallBack.class)
public interface VideoClient {
    @GetMapping("/edu/video/getByChapterId/{vedioId}")
    public ReturnResult getByChapterId (@PathVariable("vedioId") String vedioId);


}
