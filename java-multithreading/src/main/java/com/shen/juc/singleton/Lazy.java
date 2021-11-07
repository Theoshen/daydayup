package com.shen.juc.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName Lazy.java
 * @email theoshen@foxmail.com
 * @Description TODO
 * @createTime 2021年11月07日 21:21:00
 */
// 懒汉式单例
// 道高一尺，魔高一丈！
public class Lazy {
    private static boolean csp = false;// 标志位


    // 单例不安全，因为反射可以破坏单例，如下解决这个问题：
    private Lazy(){
        synchronized (Lazy.class){
            if (csp == false){
                csp = true;
            }else {
                throw new RuntimeException("不要试图使用反射破坏异常");
            }
        }
    }
    /**
     * 计算机指令执行顺序：
     * 1. 分配内存空间
     * 2、执行构造方法，初始化对象
     * 3、把这个对象指向这个空间
     *
     * 期望顺序是：123
     * 特殊情况下实际执行：132  ===>  此时 A 线程没有问题
     *                               若额外加一个 B 线程 
     *                               此时Lazy还没有完成构造
     */
    // 原子性操作：避免指令重排
    private volatile static Lazy Lazy;
    // 双重检测锁模式的 懒汉式单例  DCL懒汉式
    public static Lazy getInstance(){
        if (Lazy==null){
            synchronized (Lazy.class){
                if (Lazy==null){
                    Lazy = new Lazy(); // 不是一个原子性操作
                }
            }
        }
        return Lazy;
    }
    // 反射！
    public static void main(String[] args) throws Exception {
        //Lazy instance = Lazy.getInstance();
        Field qinjiang = Lazy.class.getDeclaredField("csp");
        qinjiang.setAccessible(true);
        Constructor<Lazy> declaredConstructor =
                Lazy.class.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        Lazy instance = declaredConstructor.newInstance();
        qinjiang.set(instance,false);
        Lazy instance2 = declaredConstructor.newInstance();
        System.out.println(instance);
        System.out.println(instance2);
    }
}
