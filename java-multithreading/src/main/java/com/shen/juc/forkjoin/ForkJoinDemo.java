package com.shen.juc.forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName ForkJoinDemo.java
 * @email theoshen@foxmail.com
 * @Description 求和计算的任务 1、弱智做法  2、forkjoin  3、stream
 * forkjoin 如何使用
 * 1 forkjoinPool 执行
 * 2 计算任务 forkjoinPool.execute(ForkJoinTask task)
 *   ForkJoinTask
 * @createTime 2021年11月02日 20:57:00
 */
public class ForkJoinDemo extends RecursiveTask<Long> {
    private Long start ;

    private Long end;

    private Long temp = 10000L;
    public ForkJoinDemo(Long start, Long end) {
        this.start = start;
        this.end = end;
    }


    public static void main(String[] args) {
        /**
         * 弱智做法
         * int sum = 0;
         * for (int i = 0; i < 100000000; i++) {
         *   sum += i;
         * }
         * System.out.println(sum);
         */

    }

    /**
     * @Description 计算方法
     * @author chensihua
     * @createTime 21:13 2021/11/2
     * @return java.lang.Long
     * @version 1.0.0
     */
    @Override
    protected Long compute() {
        if ((end - start) <temp){
            Long sum = 0L;
            for (Long i = start; i <= end; i++) {
                sum += 1;
            }
            return sum;
        }else {
            // 中间值
            long middle = (start + end) / 2;
            ForkJoinDemo task1 = new ForkJoinDemo(start, middle);
            // 拆分任务
            task1.fork();
            ForkJoinDemo task2 = new ForkJoinDemo(middle, end);
            task2.fork();
            return task1.join() + task2.join();
        }

    }
}
