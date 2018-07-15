package com.catpp.springboot.controller;

import com.catpp.springboot.pojo.JSONResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/error")
public class ErrorController {

    @RequestMapping("webError")
    public String webError() {
        int a = 1 / 0;
        return "/error";
    }

    @RequestMapping("/ajaxError")
    public String ajaxError() {
        return "/ajaxError";
    }

    @RequestMapping("/accessAjax")
    @ResponseBody
    public JSONResult accessAjax() {
        int a = 1 / 0;
        return new JSONResult();
    }
}
