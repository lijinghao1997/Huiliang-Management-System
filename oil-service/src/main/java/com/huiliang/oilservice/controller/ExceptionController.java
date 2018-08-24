package com.huiliang.oilservice.controller;


import common.ServerResponse;
import common.ServerResponseFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.ServletException;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(ServletException.class)
    public ServerResponse defaultErrorHandler(){
        return ServerResponseFactory.createError("服务器内部错误");
    }
}
