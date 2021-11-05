package com.shen.juc.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName Test.java
 * @email theoshen@foxmail.com
 * @Description TODO
 * @createTime 2021年11月02日 21:14:00
 */
public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        test1(); // 7084
//        test2();  //7420
        test3();
    }

    public static void test1() {
        Long sum = 0L;
        long start = System.currentTimeMillis();

        for (Long i = 1L; i <= 10_0000_0000; i++) {
            sum += 1;
        }

        long end = System.currentTimeMillis();
        System.out.println("sum =" + sum + "用时" + (end - start));
    }


    public static void test2() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinDemo forkJoinDemo = new ForkJoinDemo(0L, 10_0000_0000L);
        ForkJoinTask<Long> submit = forkJoinPool.submit(forkJoinDemo);
        Long sum = submit.get();

        long end = System.currentTimeMillis();
        System.out.println("sum =" + sum + "用时" + (end - start));
    }


    public static void test3() {
        long start = System.currentTimeMillis();
        long sum = LongStream.rangeClosed(0L, 10_0000_0000L).parallel().reduce(0, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println("sum =" + sum + "用时" + (end - start));
    }
}
