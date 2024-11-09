package com.neegix.exception;

public class BusinessRuntimeException extends RuntimeException{
    public BusinessRuntimeException(String msg){
        super(msg);
    }
}
