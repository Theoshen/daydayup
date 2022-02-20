package com.shen.others;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.RecursiveTask;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName MahjongProbability.java
 * @email theoshen@foxmail.com
 * @Description 108张麻将牌 万条筒 （1-9） 起手摸9张  求至少有一碰的概率
 * @createTime 2021年10月13日 09:31:00
 */
public class MahjongProbability extends RecursiveTask<Integer> {

    /**
     * 定义麻将数组
     */
    private static int[] mahjong = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17,
            18, 19, 20, 21, 22, 23, 24, 25, 26, 27};

    private static int million = 1000000;

    private static int hundred = 100;

    private static int start = 0;

    // 临界值
    private int temp = 500000;

    private int MILLION;
    private int START;

    public MahjongProbability(int begin,int end){
        this.START = begin;
        this.MILLION = end;
    }
    /**
     * @param aa
     * @return int[]
     * @Description 组合麻将牌
     * @author chensihua
     * @createTime 10:11 2021/10/13
     * @version 1.0.0
     */
    private static int[] getListString(int[] aa) {
        // TODO Auto-generated method stub
        List collect = new ArrayList();
        collect.add(aa);
        collect.add(aa);
        collect.add(aa);
        collect.add(aa);
        int[] aa0 = null;
        // tyy 每次都是两个数组合并 所以合并的次数为 collect.size() ，第一个是虚拟的数组
        for (int i = 0; i < collect.size(); i++) {
            int[] aa1 = (int[]) collect.get(i);
            int[] newInt = onArrayTogater(aa0, aa1);
            aa0 = newInt;
        }
        return aa0;
    }

    private static int[] onArrayTogater(int[] aa, int[] bb) {
        // TODO Auto-generated method stub
        if (aa == null) {
            return bb;
        }
        int[] collectionInt = new int[aa.length + bb.length];
        for (int i = 0; i < aa.length; i++) {
            collectionInt[i] = aa[i];
        }
        for (int i = aa.length; i < aa.length + bb.length; i++) {
            collectionInt[i] = aa[i - aa.length];
        }
        return collectionInt;

    }


    /**
     * @param nums @param n
     * @return void
     * @Description 随机选牌
     * @author chensihua
     * @createTime 10:13 2021/10/13
     * @version 1.0.0
     */
    public static void randSelect(int[] nums, int n) {
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            swap(nums, i, rand.nextInt(nums.length - i) + i);
        }
    }

    /**
     * @param nums @param m @param n
     * @return void
     * @Description 乱序
     * @author chensihua
     * @createTime 10:14 2021/10/13
     * @version 1.0.0
     */
    public static void swap(int[] nums, int m, int n) {
        int temp = nums[n];
        nums[n] = nums[m];
        nums[m] = temp;
    }

    /**
     * @param hand
     * @return boolean
     * @Description 查找有碰的数组，有碰返回true 无碰返回false
     * @author chensihua
     * @createTime 12:53 2021/10/13
     * @version 1.0.0
     */
    public static boolean find(int[] hand) {
        Arrays.sort(hand);
        for (int i = 0; i < hand.length - 2; ++i) {
            if (hand[i] == hand[i + 1]) {
                if (hand[i] == hand[i + 2]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param niu @param i
     * @return int
     * @Description 计数
     * @author chensihua
     * @createTime 12:53 2021/10/13
     * @version 1.0.0
     */
    public static int containsDuplicate(boolean niu, int i) {
        if (niu) {
            i++;
        }
        return i;
    }

    public static boolean loop(){
            int[] nums = getListString(mahjong);
            randSelect(nums, 9);
            for (int i = 0; i < 9; i++) {
                System.out.print(nums[i] + ",");
            }
            int[] hand = Arrays.copyOfRange(nums, 0, 8);
            boolean niu = find(hand);
        System.out.println(niu);
        return niu;
    }

    public static void main(String[] args) {
        //获取开始时间
        long startTime = System.currentTimeMillis();

        int a = 0;
        // 循环100万次
        for (int test = 0; test < million; test++) {
            int[] nums = getListString(mahjong);
            randSelect(nums, 9);
            for (int i = 0; i < 9; i++) {
                System.out.print(nums[i] + ",");
            }
            int[] hand = Arrays.copyOfRange(nums, 0, 8);
            ;
            boolean niu = find(hand);
            System.out.println(niu);
            a = containsDuplicate(niu, a);
        }
        System.out.println("最终次数" + a);

        double d1 = a * 1.0;
        double d2 = million * 1.0;
        // 计算概率 设置保留几位小数， “.”后面几个零就保留几位小数，这里设置保留四位小数
        DecimalFormat decimalFormat = new DecimalFormat("##.0000%");
        String format = decimalFormat.format(d1 / d2);
        System.out.println("概率为：" + format);

        //获取结束时间
        long endTime = System.currentTimeMillis();
        //输出程序运行时间
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");


    }

    @Override
    protected Integer compute() {
        if ( (MILLION - START) < temp){
            int a = 0;
            for (int begin = START; begin < MILLION; begin ++){
                boolean yes = loop();
                a = containsDuplicate(yes, a);
            }
            return a;
        }else {
            int middle = (MILLION + START) / 2; // 中间值
            MahjongProbability task1 = new MahjongProbability(START, middle);
            task1.fork(); // 拆分任务，把任务压入线程队列
            MahjongProbability task2 = new MahjongProbability(middle+1, MILLION);
            task2.fork(); // 拆分任务，把任务压入线程队列
            return task1.join() + task2.join();
        }
    }
}
