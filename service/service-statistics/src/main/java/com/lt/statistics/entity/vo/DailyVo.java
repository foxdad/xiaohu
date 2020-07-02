package com.lt.statistics.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * ClassName: DailyVo
 * Description:
 * date: 2020/6/19 9:12
 *
 * @author 小狐
 * @since JDK 1.8
 */
@Data
public class DailyVo implements Serializable {
    @ApiModelProperty(value = "统计类型")
    private String type;

    @ApiModelProperty(value = "开始时间")
    private String startDate;

    @ApiModelProperty(value = "结束时间")
    private String endDate;
}
