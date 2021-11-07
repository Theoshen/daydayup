package com.shen.juc.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName CasDemo.java
 * @email theoshen@foxmail.com
 * @Description CAS demo
 * @createTime 2021年11月07日 21:26:00
 */
public class CasDemo {
    // CAS compareAndSet : 比较并交换！
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(2020);
        // 期望、更新
        // public final boolean compareAndSet
        //                                    (int expect, int update)
        // 如果我期望的值达到了，那么就更新，否则，
        // 就不更新, CAS 是CPU的并发原语！
        System.out.println(atomicInteger.compareAndSet(2020, 2021));
        System.out.println(atomicInteger.get());
        atomicInteger.getAndIncrement(); // 看底层如何实现 ++
        System.out.println(atomicInteger.compareAndSet(2020, 2021));
        System.out.println(atomicInteger.get());
    }
}
