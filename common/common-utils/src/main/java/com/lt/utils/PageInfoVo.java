package com.lt.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * ClassName: PageInfo
 * Description:
 * date: 2020/5/22 9:12
 *
 * @author 刘腾
 * @since JDK 1.8
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel
public class PageInfoVo implements Serializable {
    @ApiModelProperty("总记录数")
    private Long total;

    @ApiModelProperty("总页码")
    private Long totalPage;
    @ApiModelProperty("每页显示记录数")
    private Long pageSize;
    @ApiModelProperty("分页查出的数据")
    private List<? extends Object> list;

    @ApiModelProperty("当前分页码")
    private Long pageNum;

    public static PageInfoVo getPageInfoVo(IPage iPage, Long pageSize){
        return new PageInfoVo(iPage.getTotal(),iPage.getPages(),pageSize,iPage.getRecords(),iPage.getCurrent());
    }
}
