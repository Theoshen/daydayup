package com.shen.adapter;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName OrderService.java
 * @email theoshen@foxmail.com
 * @Description TODO
 * @createTime 2021年12月24日 15:40:00
 */
public class OrderService {
    private static Logger logger= LogManager.getLogger(OrderService.class);

    public long queryUserOrderCount(String userId) {
        logger.info("⾃自营商家，查询⽤用户的订单是否为⾸首单：{}", userId);
        return 10L;
    }
}
