package com.lt.statistics.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lt.statistics.entity.Daily;
import com.lt.statistics.entity.vo.DailyVo;
import com.lt.statistics.mapper.DailyMapper;
import com.lt.statistics.service.DailyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lt.utils.ReturnResult;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 网站统计日数据 服务实现类
 * </p>
 *
 * @author 小狐
 * @since 2020-06-18
 */
@Service
public class DailyServiceImpl extends ServiceImpl<DailyMapper, Daily> implements DailyService {
    /**
     * 统计图表需要的数据
     * TODO 可以采用枚举来降低耦合，或者采用策略模式来降低耦合度
//     * @param dailyVo
     * @return
     */
    @Override
    public ReturnResult getReportFrom(DailyVo dailyVo) {
        QueryWrapper<Daily> queryWrapper = new QueryWrapper<>();
        queryWrapper.select(dailyVo.getType(), "date_calculated");
        queryWrapper.between("date_calculated",dailyVo.getStartDate(),dailyVo.getEndDate());
        //queryWrapper.select(dailyVo.getType());

        List<Daily> dayList = baseMapper.selectList(queryWrapper);
        if (CollectionUtils.isEmpty(dayList)) {
            return ReturnResult.failed("暂无数据");
        }
        Map<String, Object> map = new HashMap<>();
        List<Integer> dataList = new ArrayList<Integer>();
        List<String> dateList = new ArrayList<String>();
        map.put("dataList", dataList);
        map.put("dateList", dateList);
        for (int i = 0; i < dayList.size(); i++) {
            Daily daily = dayList.get(i);
            dateList.add(daily.getDateCalculated());
            switch (dailyVo.getType()) {
                case "register_num":
                    dataList.add(daily.getRegisterNum());
                    break;
                case "login_num":
                    dataList.add(daily.getLoginNum());
                    break;
                case "video_view_num":
                    dataList.add(daily.getVideoViewNum());
                    break;
                case "course_num":
                    dataList.add(daily.getCourseNum());
                    break;
                default:
                    break;
            }
        }
        return ReturnResult.success("图表数据成功",map);
    }
}
