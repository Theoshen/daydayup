package com.theoshen.designPattern.singleton;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName SingletonLanHan.java
 * @email theoshen@foxmail.com
 * @Description 单例模式的懒汉式  --  线程不安全 不可用
 * @createTime 2021年05月06日 11:41:00
 */
public class SingletonLanHan {
    private static SingletonLanHan instance=null;

    private SingletonLanHan() {};

    public static SingletonLanHan getInstance(){

        if(instance==null){
            instance=new SingletonLanHan();
        }
        return instance;
    }


    public static SingletonLanHan getInstance2() {
        if (instance == null) {
            synchronized (SingletonLanHan.class) {
                instance = new SingletonLanHan();
            }
        }
        return instance;
    }


    public static void main(String[] args) {
        long start = System.nanoTime(); //获取开始时间
//        SingletonLanHan instance = SingletonLanHan.getInstance();
        SingletonLanHan instance = SingletonLanHan.getInstance2();

        long end = System.nanoTime(); //获取结束时间
        System.out.println(instance.hashCode());
        System.out.println(instance);

        System.out.println("程序运行时间： " + (end - start) + "ns");
    	}
}
