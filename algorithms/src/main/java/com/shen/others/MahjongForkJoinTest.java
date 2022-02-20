package com.shen.others;

import java.text.DecimalFormat;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class MahjongForkJoinTest {

    private static int million = 1000000;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        test2();
    	}

    public static void test2() throws ExecutionException, InterruptedException {
        //获取开始时间
        long startTime = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Integer> task = new MahjongProbability(
                0, 1000000);
        // 提交任务
        ForkJoinTask<Integer> submit = forkJoinPool.submit(task);
        Integer sum = submit.get();// 获得结果
        System.out.println("最终次数" + sum);
        double d1 = sum * 1.0;
        double d2 = million * 1.0;
        // 计算概率 设置保留几位小数， “.”后面几个零就保留几位小数，这里设置保留四位小数
        DecimalFormat decimalFormat = new DecimalFormat("##.0000%");
        String format = decimalFormat.format(d1 / d2);
        System.out.println("概率为：" + format);
        //获取结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }
}
