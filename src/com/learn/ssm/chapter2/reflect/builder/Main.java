package com.learn.ssm.chapter2.reflect.builder;

public class Main {
    public static void main(String[] args) {
        Computer computer = new Computer("Intel i9", "32GB", "1TB SSD", "NVIDIA RTX 4090");
        computer.showConfig();
        /**
         * CPU: Intel i9
         * RAM: 32GB
         * Storage: 1TB SSD
         * GPU: NVIDIA RTX 4090
         */

        Computer2 builder = new Computer2.Builder()
                .setCPU("Intel i9")
                .setRAM("32GB")
                .setStorage("1TB SSD")
                .setGPU("NVIDIA RTX 4090")
                .build();
        builder.showConfig();
        /**
         * CPU: Intel i9
         * RAM: 32GB
         * Storage: 1TB SSD
         * GPU: NVIDIA RTX 4090
         */
    }
}
