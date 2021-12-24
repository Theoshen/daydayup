package com.shen.adapter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName POPOrderService.java
 * @email theoshen@foxmail.com
 * @Description TODO
 * @createTime 2021年12月24日 15:52:00
 */
public class POPOrderService {
    private static Logger logger= LogManager.getLogger(POPOrderService.class);

    public boolean isFirstOrder(String userId) {
        logger.info("POP商家，查询⽤用户的订单是否为⾸首单：{}", userId);
        return true;
    }
}
