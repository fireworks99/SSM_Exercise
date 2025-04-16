package com.learn.ssm.chapter2.reflect;

public class ReflectServiceImpl2 {
    private String name;

    public ReflectServiceImpl2(String name) {
        this.name = name;
    }

    public void sayHello() {
        System.out.println("Hello, " + name);
    }

    // 通过反射，生成对象（含参构造）
    public static ReflectServiceImpl2 getInstance(String name) {
        ReflectServiceImpl2 object = null;
        try {
            object = (ReflectServiceImpl2) Class.forName("com.learn.ssm.chapter2.reflect.ReflectServiceImpl2").getConstructor(String.class).newInstance(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }
}
