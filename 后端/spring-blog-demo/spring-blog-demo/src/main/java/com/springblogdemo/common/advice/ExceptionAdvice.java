package com.springblogdemo.common.advice;

import com.springblogdemo.common.exception.BlogException;
import com.springblogdemo.pojo.response.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

@Slf4j
@ResponseBody
@ControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler
    public Result exceptionHandler (Exception exception) {
        log.error("发生异常，e：{}", exception);
        return Result.fail(exception.getMessage());
    }

    @ExceptionHandler
    public Result exceptionHandler (BlogException exception) {
        log.error("发生异常，e：{}", exception);
        return Result.fail(exception.getMessage());
    }

    @ExceptionHandler
    public Result exceptionHandler (HandlerMethodValidationException exception) {
        log.error("发生异常，e：{}", exception);
        return Result.fail("参数校验失败");
    }
}
