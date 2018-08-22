package com.catpp.springboot.controller;

import com.catpp.springboot.pojo.JsonResult;
import com.catpp.springboot.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/getUser")
    @ResponseBody
    public JsonResult getUser() {
        User user = new User();
        user.setUsername("张三");
        user.setPassword("123qwe");
        user.setAge(19);
        user.setBirthday(new Date());
        user.setDesc(null);

        return new JsonResult(user);
    }
}
