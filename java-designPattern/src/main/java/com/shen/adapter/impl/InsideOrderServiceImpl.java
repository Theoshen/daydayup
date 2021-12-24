package com.shen.adapter.impl;

import com.shen.adapter.OrderAdapterService;
import com.shen.adapter.OrderService;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName InsideOrderServiceImpl.java
 * @email theoshen@foxmail.com
 * @Description TODO
 * @createTime 2021年12月17日 16:20:00
 */
public class InsideOrderServiceImpl implements OrderAdapterService {
    private OrderService orderService = new OrderService();

    public boolean isFirst(String uId) {
        return orderService.queryUserOrderCount(uId) <= 1;
    }
}
