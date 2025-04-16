package com.learn.ssm.chapter2.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyExample implements InvocationHandler {

    // 真实对象
    private Object target = null;

    // 1.建立代理对象与真实对象的代理关系，并返回代理对象
    // Proxy.newProxyInstance第二个参数限制了JDK动态代理只适应接口类型，不能直接代理类
    public Object bind(Object target) {
        this.target = target;//本该放到构造函数中，这里顺便做了
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
    }

    // 2.实现代理逻辑
    // 当调用代理对象的某个方法时，这个 invoke() 方法就会被触发。
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("在调度真实对象之前的服务");

        // 这行代码相当于调度真实对象的方法，只是通过反射实现而已。
        Object obj = method.invoke(target, args);//访问 当前类的成员变量 时，可省略this

        System.out.println("在调度真实对象之后的服务");
        return obj;
    }
}
