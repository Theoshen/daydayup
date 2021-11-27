package com.shen.factory.abstractFactory;


/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName HotPotStore.java
 * @email theoshen@foxmail.com
 * @Description TODO
 * @createTime 2021年05月06日 14:58:00
 */
public abstract class HotPotStore {
    public abstract Hotpot sellHotpot(String type);
    
//    /**
//     * @Description 根据传入类型卖不同的火锅
//     * @author chensihua
//     * @param type
//     * @createTime 15:02 2021/5/6
//     * @return com.theoshen.designPattern.factory.simpleFactory.Hotpot
//     * @version 1.0.0
//     */
//    public Hotpot sellHotpot(String type){
//        Hotpot hotpot = createHotpot(type);
//        hotpot.perpare();
//        hotpot.fire();
//        hotpot.eat();
//        return hotpot;
//    }
}
