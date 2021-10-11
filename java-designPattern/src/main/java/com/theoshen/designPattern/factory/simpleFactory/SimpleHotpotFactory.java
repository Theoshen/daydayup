package com.theoshen.designPattern.factory.simpleFactory;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName SimpleHotpotFactory.java
 * @email theoshen@foxmail.com
 * @Description TODO
 * @createTime 2021年05月06日 14:50:00
 */
public class SimpleHotpotFactory {
    public Hotpot createHotpot(String type){
        Hotpot hotpot = null;
        if (type.equals("hongguo")){
            hotpot = new SpicyBroth();
        }else if (type.equals("qingtang")){
            hotpot = new PlainBroth();
        }else if (type.equals("yuanyang")){
            hotpot = new DoubleFlavor();
        }

        hotpot.perpare();
        hotpot.fire();
        hotpot.eat();
        return hotpot;
    }
}
