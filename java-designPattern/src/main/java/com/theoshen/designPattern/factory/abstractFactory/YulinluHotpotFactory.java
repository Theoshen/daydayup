package com.theoshen.designPattern.factory.abstractFactory;



/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName SimpleHotpotFactory.java
 * @email theoshen@foxmail.com
 * @Description TODO
 * @createTime 2021年05月06日 14:50:00
 */
public class YulinluHotpotFactory {

    public Hotpot createHotpot(String type){
        Hotpot hotpot = null;
        if ("hongguo".equals(type)) {
            hotpot = new YulinluSpicyBroth();
        } else if ("qingtang".equals(type)) {
            hotpot = new YulinluPlainBroth();
        } else if ("yuanyang".equals(type)) {
            hotpot = new YulinluDoubleFlavor();
        } else {
            hotpot = new YulinluSpicyBroth();
        }
        return hotpot;
    }
}
