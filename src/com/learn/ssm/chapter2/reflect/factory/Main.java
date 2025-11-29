package com.learn.ssm.chapter2.reflect.factory;

public class Main {
    public static void main(String[] args) {

//        工厂模式
        Computer computer = ComputerFactory.createComputer("Mac");
        computer.start();//Macbook starting...

//        抽象工厂模式
        ProductFactory factory = new HuaweiFactory();
        Phone phone = factory.createPhone();
        phone.call();//Huawei calling...

        Computer computer1 = factory.createComputer();
        computer1.start();//Huawei starting...
    }
}
