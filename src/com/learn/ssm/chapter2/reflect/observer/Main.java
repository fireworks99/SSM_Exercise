package com.learn.ssm.chapter2.reflect.observer;

public class Main {
    public static void main(String[] args) {
        ProductList observable = ProductList.getInstance();

        TaoBaoObserver taoBaoObserver = new TaoBaoObserver();
        observable.addObserver(taoBaoObserver);

        JingDongObserver jingDongObserver = new JingDongObserver();
        observable.addObserver(jingDongObserver);

        observable.addProduct("RedMi Note9 Pro");
        /**
         * 产品列表新增了产品：RedMi Note9 Pro
         * 发送新产品【RedMi Note9 Pro】同步到京东商城
         * 发送新产品【RedMi Note9 Pro】同步到淘宝商城
         */
    }
}
