package com.learn.ssm.chapter2.reflect;

public class Main {
    public static void main(String[] args) {

        // 1.通过反射生成对象（无参构造）
        ReflectServiceImpl service = ReflectServiceImpl.getInstance();
        if(service != null) {
            service.sayHello("Joey");//Hello, Joey
        }

        // 2.通过反射调度方法
        Object o = service.reflectMethod();//Hello, Mike
        System.out.println(o);//Mike

        // 3.通过反射生成对象并调度方法
        Object oo = service.reflect();//Hello, Tom
        System.out.println(oo);//com.learn.ssm.chapter2.reflect.ReflectServiceImpl@34a245ab

        // 4.通过反射生成对象（含参构造）
        ReflectServiceImpl2 serviceImpl2 = ReflectServiceImpl2.getInstance("Alice");
        if(serviceImpl2 != null) {
            serviceImpl2.sayHello();//Hello, Alice
        }
    }
}
