package com.theoshen.designPattern.singleton;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName Singleton.java
 * @email theoshen@foxmail.com
 * @Description 单例模式懒汉式双重校验锁
 * @createTime 2021年05月06日 11:56:00
 */
public class Singleton {
    private static Singleton instance=null;

    private Singleton() {};

    public static Singleton getInstance(){
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        long start = System.nanoTime(); //获取开始时间
        Singleton instance = Singleton.getInstance();
        long end = System.nanoTime(); //获取结束时间
        System.out.println(instance.hashCode());
        System.out.println(instance);

        System.out.println("程序运行时间： " + (end - start) + "ns");
    	}
}
