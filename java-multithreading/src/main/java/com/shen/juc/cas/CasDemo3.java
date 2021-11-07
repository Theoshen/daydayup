package com.shen.juc.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName CasDemo3.java
 * @email theoshen@foxmail.com
 * @Description 原子引用 demo
 * @createTime 2021年11月07日 21:28:00
 */
public class CasDemo3 {

    /**
     * AtomicStampedReference 注意，
     * 如果泛型是一个包装类，注意对象的引用问题
     * 正常在业务操作，这里面比较的都是一个个对象
     */
    /**
     * 可以有一个初始对应的版本号 1
     */
    static AtomicStampedReference<Integer>
            atomicStampedReference =
            new AtomicStampedReference<>(2020,1);
    // CAS compareAndSet : 比较并交换！
    public static void main(String[] args) {
        new Thread(()->{
            // 获得版本号
            int stamp = atomicStampedReference.getStamp();
            System.out.println("a1=>"+stamp);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicStampedReference.compareAndSet(
                    2020,
                    2022,
                    atomicStampedReference.getStamp(), // 最新版本号
                    // 更新版本号
                    atomicStampedReference.getStamp() + 1);
            System.out.println("a2=>"
                    +atomicStampedReference.getStamp());
            System.out.println(
                    atomicStampedReference.compareAndSet(
                            2022,
                            2020,
                            atomicStampedReference.getStamp(),
                            atomicStampedReference.getStamp() + 1));
            System.out.println("a3=>"
                    +atomicStampedReference.getStamp());
        },"a").start();
        // 乐观锁的原理相同！
        new Thread(()->{
            // 获得版本号
            int stamp = atomicStampedReference.getStamp();
            System.out.println("b1=>"+stamp);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(
                    atomicStampedReference.compareAndSet(
                            2020, 6666, stamp, stamp + 1));
            System.out.println("b2=>"
                    +atomicStampedReference.getStamp());
        },"b").start();
    }
}
