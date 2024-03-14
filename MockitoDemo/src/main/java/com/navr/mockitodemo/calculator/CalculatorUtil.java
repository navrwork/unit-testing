package com.navr.mockitodemo.calculator;

public class CalculatorUtil {

    public static void printHello() {
        System.out.println("CalculatorUtil.printHello(): Hello World!");
    }

    public static void printMessage(String message) {
        System.out.printf("CalculatorUtil.printMessage(%s)%n", message);
    }

    public static String concat(String x, String y) {
        System.out.printf("CalculatorUtil.concat(%s, %s)%n", x, y);
        return x+y;
    }

    public static int add(int a, int b) {
        return a+b;
    }




}
