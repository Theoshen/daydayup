package com.shen.factory.abstractFactory;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName YulinluHotpotStore.java
 * @email theoshen@foxmail.com
 * @Description TODO
 * @createTime 2021年05月06日 15:02:00
 */
public class YulinluHotpotStore extends HotPotStore {
    private YulinluHotpotFactory factory;

    public YulinluHotpotStore(YulinluHotpotFactory factory){
        this.factory = factory;
    }

    public Hotpot sellHotpot(String type) {
        Hotpot hotpot = factory.createHotpot(type);
        hotpot.perpare(new YulinluRawFactory());
        hotpot.fire();
        hotpot.eat();
        return hotpot;
    }
}
