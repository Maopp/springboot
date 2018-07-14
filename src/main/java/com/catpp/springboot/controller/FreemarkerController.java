package com.catpp.springboot.controller;

import com.catpp.springboot.pojo.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * freemarker模板引擎
 * 注意类上的注解不能用RestController，不然不能返回页面
 */
@Controller
@RequestMapping("/freemarker")
public class FreemarkerController {

    @Autowired
    private Resource resource;

    @RequestMapping("/center")
    public String center(ModelMap map) {
        map.addAttribute("resource", resource);
        return "/freemarker/center";
    }

    @RequestMapping("/index")
    public String index() {
        return "/index";
    }
}
