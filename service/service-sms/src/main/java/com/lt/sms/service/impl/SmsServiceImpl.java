package com.lt.sms.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.lt.sms.service.SmsService;
import com.lt.sms.utils.OssUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * ClassName: SmsServiceImpl
 * Description:
 * date: 2020/6/10 14:32
 *
 * @author 刘腾
 * @since JDK 1.8
 */
@Service
public class SmsServiceImpl implements SmsService {
    @Override
    public Boolean send(String phone, Map<String, Integer> code) {
        DefaultProfile profile =
                DefaultProfile.getProfile("default", OssUtils.KEY_ID, OssUtils.KEY_SECRET);

        try {
            DefaultProfile.addEndpoint("default", "default", "Dysmsapi", "dysmsapi.aliyuncs.com" );
        } catch (ClientException e) {
            e.printStackTrace();
        }
        IAcsClient acsClient = new DefaultAcsClient(profile);
        //组装请求对象
//        CommonRequest request = new CommonRequest();
        SendSmsRequest request = new SendSmsRequest();
        //request.setProtocol(ProtocolType.HTTPS);
        request.setMethod(MethodType.POST);

        //手机号
        //可以抽取出来到全局配置里面去

        request.setPhoneNumbers(phone);
        request.setSignName("学生在线管理平台");
        request.setTemplateCode("SMS_192820239");
        request.setTemplateParam(JSONObject.toJSONString(code));
        try {
            SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
            if(sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
                return true;
            }
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return false;
    }
}
