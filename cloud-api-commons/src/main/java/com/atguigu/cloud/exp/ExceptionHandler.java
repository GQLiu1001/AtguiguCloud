package com.atguigu.cloud.exp;

import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.resp.RetrunCodeEnum;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(value = RuntimeException.class)
    public ResultData<?> exceptionHandler(Exception ex){
        System.out.println(ex.getMessage());
        ResultData<?> resultData = new ResultData<>();
        resultData.setCode(RetrunCodeEnum.RC500.getCode());
        resultData.setMessage(ex.getMessage());
        return resultData  ;
    }
}
