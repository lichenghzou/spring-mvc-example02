package com.smart.web.common.handler;

import com.smart.web.common.ex.ServiceException;
import com.smart.web.common.result.ResponseResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 *  如何全局异常
 */
//1.定义全局异常类
@RestControllerAdvice
public class GlobleExceptionHandler {

    //2.定义异常处理方法
    @ExceptionHandler(Exception.class)
    public ResponseResult<Object> handlerException(Exception ex){
//        ex.printStackTrace();//控制台输出异常
        System.out.println(ex.getMessage());
        return ResponseResult.error();
    }

    @ExceptionHandler(ServiceException.class)
    public ResponseResult<Object> handlerException(ServiceException ex){
//        ex.printStackTrace();//控制台输出异常
        System.out.println(ex.getMessage());
        return ResponseResult.error(ex.getResponseCode());
    }
}
