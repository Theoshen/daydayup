package com.shen.adapter.impl;

import com.shen.adapter.OrderAdapterService;
import com.shen.adapter.OrderService;
import com.shen.adapter.POPOrderService;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName POPOderAdapterServiceImpl.java
 * @email theoshen@foxmail.com
 * @Description TODO
 * @createTime 2021年12月17日 16:21:00
 */
public class POPOderAdapterServiceImpl implements OrderAdapterService {

    private POPOrderService orderService = new POPOrderService();


    public boolean isFirst(String uId) {
        return orderService.isFirstOrder(uId);
    }
}
