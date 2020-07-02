package com.lt.utils;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * ClassName: ReturnResult
 * Description:
 * date: 2020/5/16 20:53
 *返回给前台的数据
 * @author 刘腾
 * @since JDK 1.8
 */
@Data
public class ReturnResult implements Serializable {
    @ApiModelProperty("是否返回成功")
    private Boolean state;
    @ApiModelProperty("返回的状态码")
    private Integer code;
    @ApiModelProperty("返回消息")
    private String message;
    @ApiModelProperty("返回数据")
    private Object data;
    //防止外部new
    private ReturnResult(){}
    /**
     * 成功返回的数据
     * @param message
     * @param data
     * @return
     */
    public  static ReturnResult success(String message,Object data) {
        ReturnResult returnResult = new ReturnResult();
        returnResult.setState(true);
        returnResult.setCode(Constant.CODE_SUCCESS);
        returnResult.setMessage(message);
        returnResult.setData(data);
        return returnResult;
    }
//    public  static ReturnResult failedAop(String message,Object data) {
//        ReturnResult returnResult = new ReturnResult();
//        returnResult.setState(false);
//        returnResult.setCode(Constant.CODE_SUCCESS);
//        returnResult.setMessage(message);
//        returnResult.setData(data);
//        return returnResult;
//    }
    /**
     * 失败的返回
     * @param message
     * @return
     */
    public static  ReturnResult failed(String message) {
        ReturnResult returnResult = new ReturnResult();
        returnResult.setState(false);
        returnResult.setCode(Constant.CODE_FAILED);
        returnResult.setMessage(message);
        return returnResult;
    }
    public static  ReturnResult failedPay(String message) {
        ReturnResult returnResult = new ReturnResult();
        returnResult.setState(false);
        returnResult.setCode(Constant.CODE_FAILEDPAY);
        returnResult.setMessage(message);
        return returnResult;
    }
    //降级回调
    public static  ReturnResult failedBack(String message) {
        ReturnResult returnResult = new ReturnResult();
        returnResult.setState(false);
        returnResult.setCode(Constant.CODE_HYSTIRX);
        returnResult.setMessage(message);
        return returnResult;
    }

}
