package com.shen.singleton;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName SingletonIn.java
 * @email theoshen@foxmail.com
 * @Description 单例模式 -- 内部类
 * @createTime 2021年05月06日 11:58:00
 */
public class SingletonIn {
    private SingletonIn() {};

    private static class SingletonHolder{
        private static SingletonIn instance=new SingletonIn();
    }

    public static SingletonIn getInstance(){
        return SingletonHolder.instance;
    }

    public static void main(String[] args) {
        long start = System.nanoTime(); //获取开始时间
        SingletonIn instance = SingletonIn.getInstance();
        long end = System.nanoTime(); //获取结束时间
        System.out.println(instance.hashCode());
        System.out.println(instance);

        System.out.println("程序运行时间： " + (end - start) + "ns");
    	}
}
