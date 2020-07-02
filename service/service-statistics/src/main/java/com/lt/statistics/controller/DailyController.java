package com.lt.statistics.controller;


import com.lt.statistics.client.UcenterCountClient;
import com.lt.statistics.entity.Daily;
import com.lt.statistics.entity.vo.DailyVo;
import com.lt.statistics.service.DailyService;
import com.lt.utils.DayUtils;
import com.lt.utils.ReturnResult;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

/**
 * <p>
 * 网站统计日数据 前端控制器
 * </p>
 *
 * @author 小狐
 * @since 2020-06-18
 */
//@CrossOrigin
@RestController
@RequestMapping("/daily")
public class DailyController {

    @Autowired
    private UcenterCountClient countClient;

    @Autowired
    private DailyService dailyService;

    /**
     * 统计添加方法
     */
    @PostMapping("/insert/Dayily")
    public void insetDayily () {
        //随机生成三个数字
        Random random = new Random();
        Daily daily = new Daily();
        //注册人数
        ReturnResult result = countClient.countRegisterUser();
        daily.setRegisterNum(Integer.valueOf(result.getData().toString()));
        daily.setDateCalculated(DayUtils.getNowDayHMS());
        //TODO 播放视频数量
        daily.setVideoViewNum(random.nextInt(100));
        //TODO 登录人数
        daily.setLoginNum( random.nextInt(100));
        //TODO 每天新增课程数
        daily.setCourseNum(random.nextInt(100));

        dailyService.save(daily);
    }

    /**
     * 查询统计需要的数据
//     * @param dailyVo
     * @return
     */
    @PostMapping("/getReportFrom")
    public ReturnResult getReportFrom (@RequestBody DailyVo dailyVo) {
        ReturnResult result = dailyService.getReportFrom(dailyVo);
        return result;


    }


}

