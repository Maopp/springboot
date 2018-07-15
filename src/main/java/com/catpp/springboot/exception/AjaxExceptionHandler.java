package com.catpp.springboot.exception;

import com.catpp.springboot.pojo.JSONResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

//@RestControllerAdvice
public class AjaxExceptionHandler {

    //@ExceptionHandler(value = Exception.class)
    public JSONResult exceptionHandler(HttpServletRequest request, Exception e) {
        e.printStackTrace();
        return JSONResult.errorException(e.getMessage());
    }
}
