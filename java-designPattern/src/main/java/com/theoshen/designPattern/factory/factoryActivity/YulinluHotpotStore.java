package com.theoshen.designPattern.factory.factoryActivity;

import com.theoshen.designPattern.factory.simpleFactory.DoubleFlavor;
import com.theoshen.designPattern.factory.simpleFactory.Hotpot;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName YulinluHotpotStore.java
 * @email theoshen@foxmail.com
 * @Description TODO
 * @createTime 2021年05月06日 15:02:00
 */
public class YulinluHotpotStore extends HotPotStore {
    public Hotpot createHotpot(String type) {
        Hotpot hotpot = null;
        if (type.equals("hongguo")){
            hotpot = new YulinluSpicyBroth();
        }else if (type.equals("qingtang")){
            hotpot = new YulinluPlainBroth();
        }else if (type.equals("yuanyang")){
            hotpot = new YulinluDoubleFlavor();
        }

        hotpot.perpare();
        hotpot.fire();
        hotpot.eat();
        return hotpot;
    }
}
