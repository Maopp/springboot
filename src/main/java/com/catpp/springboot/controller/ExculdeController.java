package com.catpp.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * com.catpp.springboot.controller
 *
 * @Author cat_pp
 * @Date 2018/8/30
 * @Description
 */
@RestController
@RequestMapping("/exclude")
public class ExculdeController {

    @RequestMapping("/interceptor")
    public String interceptor() {
        return "被放行啦";
    }
}
