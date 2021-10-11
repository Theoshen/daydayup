package com.theoshen.designPattern.singleton;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName SingletonLanHan2.java
 * @email theoshen@foxmail.com
 * @Description 懒汉式线程安全 -- 效率低不推荐使用
 * @createTime 2021年05月06日 11:45:00
 */
public class SingletonLanHan2 {
    private static SingletonLanHan2 instance = null;

    private SingletonLanHan2() {
    }


    public static synchronized SingletonLanHan2 getInstance() {

        if (instance == null) {
            instance = new SingletonLanHan2();
        }
        return instance;
    }

    public static void main(String[] args) {
        long start = System.nanoTime(); //获取开始时间
        SingletonLanHan2 instance = SingletonLanHan2.getInstance();

        long end = System.nanoTime(); //获取结束时间
        System.out.println(instance.hashCode());
        System.out.println(instance);

        System.out.println("程序运行时间： " + (end - start) + "ns");

    }
}
