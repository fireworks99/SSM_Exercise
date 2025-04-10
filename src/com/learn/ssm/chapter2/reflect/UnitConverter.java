package com.learn.ssm.chapter2.reflect;

public class UnitConverter {
    public static void main(String[] args) {
        if(args.length == 0) {
            System.out.println("No args");
        }
        try {
            double meters = Double.parseDouble(args[0]);
            double cm = meters * 10;
            System.out.println(meters + " meters = " + cm + " cm");
        }catch (NumberFormatException e) {
            System.out.println("Invalid Number");
        }
    }
}
