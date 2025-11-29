package com.learn.ssm.chapter2.reflect.factory;

public class ComputerFactory {
    public static Computer createComputer(String type) {
        if("Mac".equalsIgnoreCase(type)) {
            return new Macbook();
        } else if("ThinkPad".equalsIgnoreCase(type)) {
            return new ThinkPad();
        }
        return null;
    }
}
