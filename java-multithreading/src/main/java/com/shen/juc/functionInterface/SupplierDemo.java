package com.shen.juc.functionInterface;

import java.util.function.Supplier;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName SupplierDemo.java
 * @email theoshen@foxmail.com
 * @Description 供给型接口 没有参数，只有返回值
 * @createTime 2021年11月02日 20:17:00
 */
public class SupplierDemo {
    public static void main(String[] args) {
        Supplier<Integer> supplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                System.out.println("get()");
                return 1024;
            }
        };

        System.out.println(supplier.get());

        Supplier<Integer> s  = () -> {
            return 1024;
        };
        System.out.println(s.get());
    }
}
