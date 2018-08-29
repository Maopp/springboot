package com.catpp.springboot.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * com.catpp.springboot.task
 *
 * @Author cat_pp
 * @Date 2018/8/29
 * @Description
 */
@Component
public class AsyncTaskDemo {

    @Async
    public Future<Boolean> doTask1() throws Exception {
        long start = System.currentTimeMillis();
        Thread.sleep(1000);
        long end = System.currentTimeMillis();
        System.out.println("任务1耗时：" + (end - start) + "毫秒");
        return new AsyncResult<>(true);
    }

    @Async
    public Future<Boolean> doTask2() throws Exception {
        long start = System.currentTimeMillis();
        Thread.sleep(500);
        long end = System.currentTimeMillis();
        System.out.println("任务2耗时：" + (end - start) + "毫秒");
        return new AsyncResult<>(true);
    }

    @Async
    public Future<Boolean> doTask3() throws Exception {
        long start = System.currentTimeMillis();
        Thread.sleep(200);
        long end = System.currentTimeMillis();
        System.out.println("任务3耗时：" + (end - start) + "毫秒");
        return new AsyncResult<>(true);
    }
}
