package com.catpp.springboot.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.FutureResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

/**
 * com.catpp.springboot.task
 *
 * @Author cat_pp
 * @Date 2018/8/29
 * @Description
 */
@RestController
@RequestMapping("/task")
public class DoTask {

    @Autowired
    private AsyncTaskDemo asyncTaskDemo;

    @RequestMapping("/test")
    public String test() throws Exception {
        long start = System.currentTimeMillis();

        Future<Boolean> future1 = asyncTaskDemo.doTask1();
        Future<Boolean> future2 = asyncTaskDemo.doTask2();
        Future<Boolean> future3 = asyncTaskDemo.doTask3();

        while (!future1.isDone() || !future2.isDone() || !future3.isDone()) {

        }

        long end = System.currentTimeMillis();

        String result = "任务总耗时：" + (end - start) + "毫秒";
        System.out.println(result);

        return result;
    }
}
