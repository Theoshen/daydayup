package com.shen.juc.pool;

import java.util.concurrent.*;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName ExecutorDemo.java
 * @email theoshen@foxmail.com
 * @Description 线程池 demo    Executors 不要用
 *                      ExecutorService threadPool = Executors.newSingleThreadExecutor();
 *                      ExecutorService threadPool = Executors.newFixedThreadPool(5);
 *              拒绝策略 1、new ThreadPoolExecutor.AbortPolicy()  超出容量，抛出异常
 *                      2、new ThreadPoolExecutor.CallerRunsPolicy()  哪里来的去哪里
 *                      3、new ThreadPoolExecutor.DiscardPolicy() 队列满了，丢掉任务，不会抛出异常
 *                      4、new ThreadPoolExecutor.DiscardOldestPolicy() 队列满了，尝试和最早的竞争，不会抛出异常
 * @createTime 2021年11月02日 18:52:00
 */
public class PoolDemo {
    public static void main(String[] args) {

        System.out.println(Runtime.getRuntime().availableProcessors());

        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy()
        );

        try {
            // 超过最大承载 Deque + max
            // RejectedExecutionException
            for (int i = 0; i < 20; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + " ok");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }


    }
}
