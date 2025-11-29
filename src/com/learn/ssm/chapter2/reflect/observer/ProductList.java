package com.learn.ssm.chapter2.reflect.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class ProductList extends Observable {

    private List<String> products = null;//产品列表

    private static ProductList instance;//此类的唯一实例(这里体现了单例模式)

    private ProductList() {}//构建方法私有化(不能在外部任意new实例，保证了单例)

    // get唯一实例
    public static ProductList getInstance() {
        if(instance == null) {
            instance = new ProductList();
            instance.products = new ArrayList<String>();
        }
        return instance;
    }

    // 增加一个观察者
    // Observable.addObserver(Observer observer)

    // 被观察者发生更新
    public void addProduct(String newProduct) {
        products.add(newProduct);
        System.out.println("产品列表新增了产品：" + newProduct);

        /**
         * 告知观察者当前被观察者发生了变化
         * Java的Observable类的notifyObservers方法会检查一个布尔值changed，
         * setChanged()就是把这个值设为true的。
         */
        this.setChanged();

        /**
         * 检查changed变量，如果为true，
         * 则遍历所有通过 addObserver(...) 注册进来的观察者，
         * 然后调用它们的 update(...) 方法，并把 newProduct 作为参数传给它们。
         * 调用clearChanged将changed置为false
         */
        this.notifyObservers(newProduct);
    }
}
