package com.catpp.springboot.exception;

import com.catpp.springboot.pojo.JsonResult;

import javax.servlet.http.HttpServletRequest;

//@RestControllerAdvice
public class AjaxExceptionHandler {

    //@ExceptionHandler(value = Exception.class)
    public JsonResult exceptionHandler(HttpServletRequest request, Exception e) {
        e.printStackTrace();
        return JsonResult.errorException(e.getMessage());
    }
}
