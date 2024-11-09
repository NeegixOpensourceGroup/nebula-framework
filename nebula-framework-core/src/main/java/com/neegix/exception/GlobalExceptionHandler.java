package com.neegix.exception;

import com.neegix.result.Result;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/09/18/09:47
 * @Description:
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessRuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public  <T> Result<T> handlerException(BusinessRuntimeException ex){
        return Result.failure(HttpStatus.INTERNAL_SERVER_ERROR.value(),ex.getMessage(), ex);
    }


    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public  <T> Result<T> handlerCommonException(Exception ex){
        return Result.failure(HttpStatus.INTERNAL_SERVER_ERROR.value(), Arrays.toString(ex.getStackTrace()), ex);
    }
}
