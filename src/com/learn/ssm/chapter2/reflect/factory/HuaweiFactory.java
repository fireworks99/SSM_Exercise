package com.learn.ssm.chapter2.reflect.factory;

public class HuaweiFactory implements ProductFactory{
    @Override
    public Phone createPhone() {
        return new HuaweiPhone();
    }

    @Override
    public Computer createComputer() {
        return new HuaweiComputer();
    }
}
