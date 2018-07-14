package com.catpp.springboot.controller;

import com.catpp.springboot.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {

    @RequestMapping("/center")
    public String center(ModelMap map) {
        map.addAttribute("name", "catpp");
        return "/thymeleaf/center";
    }

    @RequestMapping("/commonLabel")
    public String commonLabel(ModelMap map) {
        List<User> list = new ArrayList<>();
        for (int i = 0;i < 10;i++) {
            User user = new User();
            user.setDesc("test data");
            user.setUsername("testname" + i);
            user.setPassword("testpassword" + i);
            user.setBirthday(new Date());
            user.setAge(20 + i);
            list.add(user);
        }

        User user = new User();
        user.setDesc("<font size='20px' color='red'><b>test data</b></font>");
        user.setUsername("testonename");
        user.setPassword("testonepassword");
        user.setBirthday(new Date());
        user.setAge(19);

        map.addAttribute("list", list);
        map.addAttribute("user", user);
        return "/thymeleaf/center";
    }

    @RequestMapping("/form")
    public String form(User user) {
        System.out.println(user.getUsername());
        return "redirect:/thymeleaf/commonLabel";
    }
}
