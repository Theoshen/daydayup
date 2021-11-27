package com.shen.factory.abstractFactory;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName HotPotRawFactory.java
 * @email theoshen@foxmail.com
 * @Description TODO
 * @createTime 2021年05月06日 15:19:00
 */
public interface HotPotRawFactory {
    public Meat createMeat();

    public Condiments createCondiments();
}
