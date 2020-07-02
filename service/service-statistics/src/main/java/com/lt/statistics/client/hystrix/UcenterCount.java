package com.lt.statistics.client.hystrix;

import com.lt.statistics.client.UcenterCountClient;
import com.lt.utils.ReturnResult;

/**
 * ClassName: UcenterCount
 * Description:
 * date: 2020/6/18 21:31
 *
 * @author 小狐
 * @since JDK 1.8
 */
public class UcenterCount implements UcenterCountClient {
    @Override
    public ReturnResult countRegisterUser() {
        return ReturnResult.failed("小狐已经掉线了");
    }
}
