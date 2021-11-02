package com.shen.juc.functionInterface;

import java.util.function.Consumer;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName ConsumerDemo.java
 * @email theoshen@foxmail.com
 * @Description 消费型接口  只有输入，没有返回值
 * @createTime 2021年11月02日 20:14:00
 */
public class ConsumerDemo {
    public static void main(String[] args) {
        Consumer<String> stringConsumer = new Consumer<String>(){
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        stringConsumer.accept("qqqqq");

        Consumer<String> consumer = (str) -> {
            System.out.println(str);
        };

        consumer.accept("bbbbbbb");

    }
}
