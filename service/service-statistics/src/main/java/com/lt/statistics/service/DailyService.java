package com.lt.statistics.service;

import com.lt.statistics.entity.Daily;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lt.statistics.entity.vo.DailyVo;
import com.lt.utils.ReturnResult;

/**
 * <p>
 * 网站统计日数据 服务类
 * </p>
 *
 * @author 小狐
 * @since 2020-06-18
 */
public interface DailyService extends IService<Daily> {

    ReturnResult getReportFrom(DailyVo dailyVo);
}
