package com.lt.vedio.client.hyxtris;

import com.lt.utils.ReturnResult;
import com.lt.vedio.client.VideoClient;

/**
 * ClassName: VideoCallBack
 * Description:
 * date: 2020/6/24 9:53
 *
 * @author 小狐
 * @since JDK 1.8
 */
public class VideoCallBack implements VideoClient {
    @Override
    public ReturnResult getByChapterId(String vedioId) {
        return ReturnResult.failed("服务连接超时");
    }
}
