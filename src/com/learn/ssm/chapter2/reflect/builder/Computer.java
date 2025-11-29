package com.learn.ssm.chapter2.reflect.builder;

public class Computer {
    private String cpu;
    private String ram;
    private String storage;
    private String gpu;

    public Computer(String cpu, String ram, String storage, String gpu) {
        this.cpu = cpu;
        this.ram = ram;
        this.storage = storage;
        this.gpu = gpu;
    }

    public void showConfig() {
        System.out.println("CPU: " + cpu);
        System.out.println("RAM: " + ram);
        System.out.println("Storage: " + storage);
        System.out.println("GPU: " + gpu);
    }
}
