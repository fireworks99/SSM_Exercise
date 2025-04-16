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

        System.out.println("-------------------------------------");

        // 5.JDK动态代理
        JdkProxyExample jdk = new JdkProxyExample();
        HelloWorld proxy = (HelloWorld) jdk.bind(new HelloWorldImpl());
        proxy.sayHelloWorld();//这行代码会去执行代理对象的invoke方法
        /**
         * 在调度真实对象之前的服务
         * Hello World
         * 在调度真实对象之后的服务
         */

        System.out.println("-------------------------------------");

        // 6.Cglib动态代理
        CglibProxyExample cpe = new CglibProxyExample();
        ReflectServiceImpl obj = (ReflectServiceImpl) cpe.getProxy(ReflectServiceImpl.class);
        obj.sayHello("Wendy");//这行代码会去执行代理对象的intercept方法
        /**
         * 调用真实对象前
         * Hello, Wendy
         * 调用真实对象后
         */

        System.out.println("-------------------------------------");

        // 7.拦截器
        HelloWorld proxy2 = (HelloWorld) InterceptorJdkProxy.bind(new HelloWorldImpl(),
                "com.learn.ssm.chapter2.reflect.MyInterceptor");
        proxy2.sayHelloWorld();
        /**
         * 反射方法前逻辑
         * 取代了被代理对象的方法
         * 反射方法后逻辑
         */
    }
}
