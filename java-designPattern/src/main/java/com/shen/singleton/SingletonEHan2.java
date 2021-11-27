package com.shen.singleton;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName SingletonEHan2.java
 * @email theoshen@foxmail.com
 * @Description 单例模式的饿汉式变换写法 -- 可用
 * @createTime 2021年05月06日 11:42:00
 */
public class SingletonEHan2 {
    private static SingletonEHan2 instance = null;

    static {
        instance = new SingletonEHan2();
    }

    private SingletonEHan2() {};

    public static SingletonEHan2 getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        long start = System.nanoTime(); //获取开始时间
        SingletonEHan2 instance = SingletonEHan2.getInstance();
        long end = System.nanoTime(); //获取结束时间
        System.out.println(instance.hashCode());
        System.out.println(instance);

        System.out.println("程序运行时间： " + (end - start) + "ns");
    	}
}
