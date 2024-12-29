package com.atguigu.cloud.utils;

import com.atguigu.cloud.entities.Pay;

import java.util.Date;

public class SetPay {
    public static Pay setPay(Pay pay){
        pay.setDeleted(0);
        pay.setCreateTime(new Date());
        pay.setUpdateTime(new Date());
        return pay;
    }
}
