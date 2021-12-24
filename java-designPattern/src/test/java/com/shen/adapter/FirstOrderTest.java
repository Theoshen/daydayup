package com.shen.adapter;

import com.shen.adapter.impl.InsideOrderServiceImpl;
import com.shen.adapter.impl.POPOderAdapterServiceImpl;
import org.junit.Test;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName Test_itfAdaoter.java
 * @email theoshen@foxmail.com
 * @Description TODO
 * @createTime 2021年12月24日 15:55:00
 */
public class FirstOrderTest {
    @Test
    public void test_itfAdapter(){
        OrderAdapterService popOrder = new POPOderAdapterServiceImpl();
        System.out.println("判断首单，接口适配 pop : " + popOrder.isFirst("10001"));

        OrderAdapterService insideOrder = new InsideOrderServiceImpl();
        System.out.println("判断首单，接口适配（自营）: " + insideOrder.isFirst("10001"));
    }
}
