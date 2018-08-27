package com.huiliang.boundaryservice.controller;

import common.ServerResponse;
import common.ServerResponseFactory;
import exception.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(Exception.class)
    public ServerResponse exceptionHandler(){
        return ServerResponseFactory.createError("内部错误");
    }

    @ExceptionHandler(AuthenticationException.class)
    public ServerResponse authenticationHandler(){
        return ServerResponseFactory.createError("认证错误");
    }
}
