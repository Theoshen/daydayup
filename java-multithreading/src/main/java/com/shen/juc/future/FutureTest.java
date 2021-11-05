package com.shen.juc.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName Test.java
 * @email theoshen@foxmail.com
 * @Description 异步调用
 * @createTime 2021年11月04日 13:26:00
 */
public class FutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 没有返回值的runAsync 异步回调
//        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(2);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName() + "runAsync => Void");
//        });
//
//        System.out.println("111111");
//        // 获取阻塞执行结果
//        completableFuture.get();

        // 有返回值 supplyAsync
        CompletableFuture<Integer> supplyAsync = CompletableFuture.supplyAsync(() ->{
            System.out.println(Thread.currentThread().getName() + "supplyAsync => Integer");
            int i = 10/0;
            return 1024;
        });

        supplyAsync.whenComplete((success,error) -> {
            // 正常的返回结果
            System.out.println("success = " + success);
            // 错误信息
            System.out.println("error = " + error);
        }).exceptionally((e) ->{
            System.out.println(e.getMessage());
            // 获取到错误的返回结果
            return 23333;
        }).get();
    }
}
