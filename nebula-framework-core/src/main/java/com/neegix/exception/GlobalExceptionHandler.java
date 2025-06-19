package com.neegix.exception;

import com.neegix.inferfaces.result.Result;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.security.auth.login.CredentialException;

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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<Void> handleValidationExceptions(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        FieldError fieldError = result.getFieldError();
        if (fieldError != null) {
            return Result.failure(fieldError.getDefaultMessage());
        }
        return Result.failure("参数校验失败");
    }


    @ExceptionHandler(CredentialException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public  <T> Result<T> handlerCommonException(CredentialException ex){
        return Result.failure(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage(), ex);
    }
}
