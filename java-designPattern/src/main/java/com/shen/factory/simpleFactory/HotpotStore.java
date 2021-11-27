package com.shen.factory.simpleFactory;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName HotpotStore.java
 * @email theoshen@foxmail.com
 * @Description TODO
 * @createTime 2021年05月06日 14:38:00
 */
public class HotpotStore {

    private SimpleHotpotFactory factory;

    public HotpotStore (SimpleHotpotFactory factory){
        this.factory = factory;
    }

    public Hotpot sellHotpot(String type){
        Hotpot hotpot = factory.createHotpot(type);
        hotpot.perpare();
        hotpot.fire();
        hotpot.eat();
        return hotpot;
    }
}
