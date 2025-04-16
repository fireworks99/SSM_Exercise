package com.learn.ssm.chapter2.reflect;

import java.lang.reflect.Method;

public class ReflectServiceImpl {
    public String sayHello(String name) {
        System.out.println("Hello, " + name);
        return name;
    }

    // 1.通过反射，生成对象（无参构造）
    public static ReflectServiceImpl getInstance() {
        ReflectServiceImpl object = null;
        try {
            object = (ReflectServiceImpl) Class.forName("com.learn.ssm.chapter2.reflect.ReflectServiceImpl").newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            ex.printStackTrace();
        }
        return object;
    }

    // 2.通过反射，调度方法
    public Object reflectMethod() {
        Object returnObj = null;
        ReflectServiceImpl target = new ReflectServiceImpl();
        try {
            Method method = ReflectServiceImpl.class.getMethod("sayHello", String.class);
            returnObj = method.invoke(target, "Mike");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnObj;
    }

    // 3.通过反射，生成对象并调度方法
    public Object reflect() {
        ReflectServiceImpl object = null;
        try {
            object = (ReflectServiceImpl) Class.forName("com.learn.ssm.chapter2.reflect.ReflectServiceImpl").newInstance();
            Method method = object.getClass().getMethod("sayHello", String.class);
            method.invoke(object, "Tom");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }

}
