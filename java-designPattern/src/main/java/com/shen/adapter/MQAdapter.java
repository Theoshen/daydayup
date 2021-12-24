package com.shen.adapter;

import com.alibaba.fastjson.JSON;
import com.shen.adapter.entity.Account;
import com.shen.adapter.entity.RebateInfo;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Map;

/**
 * @author chensihua
 * @version 1.0.0
 * @ClassName MQAdapter.java
 * @email theoshen@foxmail.com
 * @Description TODO
 * @createTime 2021年12月17日 16:18:00
 */
public class MQAdapter {

    public static RebateInfo filter(String jsonStr, Map<String,String> link)
            throws NoSuchMethodException, InvocationTargetException,
            IllegalAccessException{
        return filter(JSON.parseObject(jsonStr,Map.class),link);
    }

    public static RebateInfo filter(Map obj, Map<String, String> link)
            throws NoSuchMethodException, InvocationTargetException,
            IllegalAccessException {
        RebateInfo rebateInfo = new RebateInfo();
        for(String key : link.keySet()){
            Object val = obj.get(link.get(key));
            RebateInfo.class.getMethod("set" + key.substring(0,1).toUpperCase() + key.substring(1),String.class).invoke(rebateInfo,
                    val.toString());
        }
        return rebateInfo;
    }


    public static void main(String[] args) {
        Account account = new Account();
        account.setAccountDate(new Date());
        account.setAddress("3333");
        account.setDesc("222222");
        account.setNumber("1");
        String jsonStr = JSON.toJSONString(account);
        Map map = JSON.parseObject(jsonStr, Map.class);
        System.out.println(map);
    }
}
