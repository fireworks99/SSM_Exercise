package com.learn.ssm.chapter2.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class InterceptorJdkProxy implements InvocationHandler {

    private Object target;//真实对象
    private String interceptorClass = null;//拦截器全限定名

    //类的构造函数
    public InterceptorJdkProxy(Object target, String interceptorClass) {
        this.target = target;
        this.interceptorClass = interceptorClass;
    }

    // 1.建立代理对象与真实对象的代理关系，并返回代理对象
    public static Object bind(Object target, String interceptorClass) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InterceptorJdkProxy(target, interceptorClass));
    }

    // 2.实现代理逻辑
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(interceptorClass == null) {
            //没有拦截器则直接反射原有方法
            return method.invoke(target, args);
        }
        Object result = null;

        //通过反射生成拦截器对象
        Interceptor interceptor = (Interceptor) Class.forName(interceptorClass).newInstance();

        if(interceptor.before(proxy, target, method, args)) {//校验通过
            result = method.invoke(target, args);//调度真实对象的方法
        } else {//校验不通过
            interceptor.around(proxy, target, method, args);
        }
        interceptor.after(proxy, target, method, args);//finally
        return result;
    }
}
