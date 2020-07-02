package com.lt.statistics.client;

import com.lt.utils.ReturnResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * ClassName: UcenterCount
 * Description:
 * date: 2020/6/18 17:50
 *
 * @author 小狐
 * @since JDK 1.8
 */
@Component
@FeignClient(value = "service-ucenter")
public interface UcenterCountClient {

    @GetMapping("/ucenter/member/countRegister")
    public ReturnResult countRegisterUser();
}
