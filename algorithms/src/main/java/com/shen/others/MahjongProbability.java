package com.shen.others;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName MahjongProbability.java
 * @email theoshen@foxmail.com
 * @Description 108张麻将牌 万条筒 （1-9） 起手摸9张  求至少有一碰的概率
 * @createTime 2021年10月13日 09:31:00
 */
public class MahjongProbability {

    /**
     * 定义麻将数组
     */
    private static int[] mahjong = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17,
            18, 19, 20, 21, 22, 23, 24, 25, 26, 27};

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
     * @param nums  @param n
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
     * @Description 查找有碰的数组，有碰返回true 无碰返回false
     * @author chensihua
     * @param hand
     * @createTime 12:53 2021/10/13
     * @return boolean
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
     * @Description 计数
     * @author chensihua
     * @param niu @param i
     * @createTime 12:53 2021/10/13
     * @return int
     * @version 1.0.0
     */
    public static int containsDuplicate(boolean niu,int i){
        if (niu){
            i++;
        }
        return i;
    }


    public static void main(String[] args) {
        int a = 0;
        for (int test = 0; test < 1000000; test++) {
            int[] nums = getListString(mahjong);
            randSelect(nums, 9);
            for (int i = 0; i < 9; i++) {
                System.out.print(nums[i] + ",");
            }
            int[] hand = Arrays.copyOfRange(nums, 0, 8);;
            boolean niu = find(hand);
            System.out.println(niu);
            a= containsDuplicate(niu,a);
        }
        System.out.println("最终次数" +a);

        double d1 = a * 1.0;
        double d2 = 1000000 * 1.0;
        // 设置保留几位小数， “.”后面几个零就保留几位小数，这里设置保留四位小数
        DecimalFormat decimalFormat = new DecimalFormat("##.0000%");
        String format = decimalFormat.format(d1 / d2);
        System.out.println("概率为：" + format );





    }

}
