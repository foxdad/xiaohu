package com.lt.config.execptionhandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName: LtExecption
 * Description:
 * date: 2020/5/25 17:25
 *
 * @author 刘腾
 * @since JDK 1.8
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LtExecption extends RuntimeException {
    private Integer code;

    private String messageInfo;

}
