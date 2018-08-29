package com.catpp.springboot.controller;

import com.catpp.springboot.service.CacheClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private CacheClient cacheClient;

    @RequestMapping("/setNoExp")
    public void setValueNoExp() {
        cacheClient.set("name", "zhangsan");
    }

    @RequestMapping("/getNoExp")
    @ResponseBody
    public String getValueNoExp() {
        return cacheClient.get("name").toString();
    }

    @RequestMapping("/setWithExp")
    public void setValueWithExp() {
        cacheClient.set("password", "张三的密码", 10, TimeUnit.SECONDS);
    }

    @RequestMapping("/getWithExp")
    @ResponseBody
    public String getValueWithExp() {
        Object password = cacheClient.get("password");
        return password.toString();
    }
}
