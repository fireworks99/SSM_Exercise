package com.learn.ssm.chapter2.reflect.factory;

public class HuaweiPhone implements Phone{
    @Override
    public void call() {
        System.out.println("Huawei calling...");
    }
}
