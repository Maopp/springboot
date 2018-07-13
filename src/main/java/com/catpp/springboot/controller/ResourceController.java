package com.catpp.springboot.controller;

import com.catpp.springboot.pojo.JSONResult;
import com.catpp.springboot.pojo.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    private Resource resource;

    @RequestMapping("getResource")
    @ResponseBody
    public JSONResult getResource() {
        Resource res = new Resource();
        BeanUtils.copyProperties(resource, res);
        return new JSONResult(res);
    }
}
