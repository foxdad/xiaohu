package com.lt.config.execptionhandler;

import com.lt.utils.ReturnResult;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebResult;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.List;
import java.util.Set;


/**
 * ClassName: GlobalExceptionHandler
 * Description:全局异常处理类
 * date: 2020/5/17 15:29
 *
 * @author 刘腾
 * @since JDK 1.8
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ReturnResult error(Exception e) {
        return ReturnResult.failed("服务器错误");
    }

//    @ExceptionHandler({BindException.class})
//    public ReturnResult BindingResult(BindingResult result){
//        return ReturnResult.failed(result.toString());
//    }

    @ExceptionHandler(LtExecption.class)
    public ReturnResult BindingResult(LtExecption result){
        return ReturnResult.failed(result.getMessageInfo());
    }

    /**
     * post请求参数校验抛出的异常
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ReturnResult methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e){
        //获取异常中随机一个异常信息
        String defaultMessage = e.getBindingResult().getFieldError().getDefaultMessage();
        return ReturnResult.failed(defaultMessage);
    }

    /**
     * get请求参数校验抛出的异常
     * @param e
     * @return
     */
    @ExceptionHandler(BindException.class)
    public ReturnResult bindExceptionHandler(BindException e){
        //获取异常中随机一个异常信息
        String defaultMessage = e.getBindingResult().getFieldError().getDefaultMessage();
        return ReturnResult.failed(defaultMessage);
    }
    /**
     * 请求方法中校验抛出的异常
     * @param e
     * @return
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ReturnResult constraintViolationExceptionHandler(ConstraintViolationException e){
        //获取异常中第一个错误信息
        String message = e.getConstraintViolations().iterator().next().getMessage();
        return ReturnResult.failed(message);
    }

//    /**
//     * 用来处理bean validation异常
//     * @param ex
//     * @return
//     */
//    @ExceptionHandler(ConstraintViolationException.class)
//    @ResponseBody
//    public WebResult resolveConstraintViolationException(ConstraintViolationException ex){
//        WebResult errorWebResult = new WebResult(WebResult.FAILED);
//        Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
//        if(!CollectionUtils.isEmpty(constraintViolations)){
//            StringBuilder msgBuilder = new StringBuilder();
//            for(ConstraintViolation constraintViolation :constraintViolations){
//                msgBuilder.append(constraintViolation.getMessage()).append(",");
//            }
//            String errorMessage = msgBuilder.toString();
//            if(errorMessage.length()>1){
//                errorMessage = errorMessage.substring(0,errorMessage.length()-1);
//            }
//            errorWebResult.setInfo(errorMessage);
//            return errorWebResult;
//        }
//        errorWebResult.setInfo(ex.getMessage());
//        return errorWebResult;
//    }
//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    @ResponseBody
//    public WebResult resolveMethodArgumentNotValidException(MethodArgumentNotValidException ex){
//        WebResult errorWebResult = new WebResult(WebResult.FAILED);
//        List<ObjectError> objectErrors = ex.getBindingResult().getAllErrors();
//        if(!CollectionUtils.isEmpty(objectErrors)) {
//            StringBuilder msgBuilder = new StringBuilder();
//            for (ObjectError objectError : objectErrors) {
//                msgBuilder.append(objectError.getDefaultMessage()).append(",");
//            }
//            String errorMessage = msgBuilder.toString();
//            if (errorMessage.length() > 1) {
//                errorMessage = errorMessage.substring(0, errorMessage.length() - 1);
//            }
//            errorWebResult.setInfo(errorMessage);
//            return errorWebResult;
//        }
//        errorWebResult.setInfo(ex.getMessage());
//        return errorWebResult;
//    }


}
