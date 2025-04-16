package com.learn.ssm.chapter2.reflect;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import java.lang.reflect.Method;

public class CglibProxyExample implements MethodInterceptor {

    // 1.建立代理对象与真实对象的代理关系，并返回代理对象
    public Object getProxy(Class cls) {
        Enhancer enhancer = new Enhancer();

        //设置增强类型
        enhancer.setSuperclass(cls);

        //定义代理对象为当前对象，要求当前对象实现 MethodInterceptor 方法
        enhancer.setCallback(this);

        //生成并返回代理对象
        return enhancer.create();
    }

    // 2.实现代理逻辑
    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("调用真实对象前");

        //CGLIB 反射调用真实对象方法
        Object result = methodProxy.invokeSuper(proxy, args);

        System.out.println("调用真实对象后");
        return result;
    }
}
