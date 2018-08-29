package com.catpp.springboot.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * com.catpp.springboot.task
 *
 * @Author cat_pp
 * @Date 2018/8/29
 * @Description 定时任务demo
 */
@Component
public class TaskDemo {
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * @Scheduled(fixedRate = 1000) 每一秒钟获取一次当前时间
     *
     * @Scheduled(cron = "0-59 * * * * ?") 定时任务表达式：* * * * * * 秒 分 时 日 月 周
     *
     */
    // @Scheduled(cron = "0-59 * * * * ?")
    public void getCurrentTime() {
        System.out.println("当前时间：" + SIMPLE_DATE_FORMAT.format(new Date()));
    }
}
