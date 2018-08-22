package com.catpp.springboot.exception;

import com.catpp.springboot.pojo.JsonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class SysExceptionHandler {

    public static final String ERROR_VIEW = "/error";

    @ExceptionHandler(value = Exception.class)
    public Object errorHandler(HttpServletRequest request, HttpServletResponse response,
                               Exception e) throws Exception {
        /*e.printStackTrace();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", e);
        modelAndView.addObject("url", request.getRequestURL());
        modelAndView.setViewName(ERROR_VIEW);
        return modelAndView;*/

        e.printStackTrace();
        if (isAjax(request)) {
            // return response;// 返回response跟进源码瞅瞅
            return JsonResult.errorException(e.getMessage());
        } else {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("exception", e);
            modelAndView.addObject("url", request.getRequestURL());
            modelAndView.setViewName(ERROR_VIEW);
            return  modelAndView;
        }
    }

    /**
     * 判断是否是Ajax请求
     * @param request
     * @return
     */
    private boolean isAjax(HttpServletRequest request) {
        return (null != request.getHeader("X-Requested-With")
            && StringUtils.equals("XMLHttpRequest", request.getHeader("X-Requested-With").toString()));
    }

}
