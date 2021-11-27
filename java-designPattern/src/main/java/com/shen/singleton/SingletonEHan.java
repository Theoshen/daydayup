package com.shen.singleton;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName Singleton.java
 * @email theoshen@foxmail.com
 * @Description 单例模式的饿汉式
 * @createTime 2021年05月06日 11:38:00
 */
public class SingletonEHan {
    private static SingletonEHan instance=new SingletonEHan();
    private SingletonEHan(){};
    public static SingletonEHan getInstance(){
        return instance;
    }
    public static void main(String[] args) {
        long start = System.nanoTime(); //获取开始时间
        SingletonEHan instance = SingletonEHan.getInstance();
        long end = System.nanoTime(); //获取结束时间
        System.out.println(instance.hashCode());
        System.out.println(instance);

        System.out.println("程序运行时间： " + (end - start) + "ns");
    }
}
