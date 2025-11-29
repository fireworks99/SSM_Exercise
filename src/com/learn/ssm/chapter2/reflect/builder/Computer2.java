package com.learn.ssm.chapter2.reflect.builder;

public class Computer2 {
    private String cpu;
    private String ram;
    private String storage;
    private String gpu;

    // 构造方法私有，只能通过 Builder 创建
    private Computer2(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.gpu = builder.gpu;
    }

    // 静态内部类 Builder
    public static class Builder {
        private String cpu;
        private String ram;
        private String storage;
        private String gpu;

        public Builder setCPU(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Builder setRAM(String ram) {
            this.ram = ram;
            return this;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGPU(String gpu) {
            this.gpu = gpu;
            return this;
        }

        public Computer2 build() {
            return new Computer2(this);
        }
    }


    public void showConfig() {
        System.out.println("CPU: " + cpu);
        System.out.println("RAM: " + ram);
        System.out.println("Storage: " + storage);
        System.out.println("GPU: " + gpu);
    }
}
