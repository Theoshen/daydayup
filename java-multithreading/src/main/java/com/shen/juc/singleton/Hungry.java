package com.shen.juc.singleton;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName Hungry.java
 * @email theoshen@foxmail.com
 * @Description TODO
 * @createTime 2021年11月07日 21:21:00
 */
public class Hungry {
    // 可能会浪费空间
    private byte[] data1 = new byte[1024*1024];
    private byte[] data2 = new byte[1024*1024];
    private byte[] data3 = new byte[1024*1024];
    private byte[] data4 = new byte[1024*1024];
    private Hungry(){
    }
    private final static Hungry HUNGRY = new Hungry();
    public static Hungry getInstance(){
        return HUNGRY;
    }
}
