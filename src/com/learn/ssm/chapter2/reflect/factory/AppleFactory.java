package com.learn.ssm.chapter2.reflect.factory;

public class AppleFactory implements ProductFactory{
    @Override
    public Phone createPhone() {
        return new ApplePhone();
    }

    @Override
    public Computer createComputer() {
        return new AppleComputer();
    }
}
