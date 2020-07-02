package com.lt.edu.entity.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * ClassName: SubjectVo
 * Description:
 * date: 2020/5/25 16:19
 *
 * @author 刘腾
 * @since JDK 1.8
 */
@Data
public class SubjectVo implements Serializable {
    @ExcelProperty(value = "",index = 0)
    private String oneSubject;
    @ExcelProperty(value = "",index = 1)
    private String twoSubject;
}
