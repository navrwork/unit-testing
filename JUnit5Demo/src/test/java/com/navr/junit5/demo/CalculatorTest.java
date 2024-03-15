package com.navr.junit5.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.Random;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CalculatorTest {

    private Calculator calculator;

    private Random random;

    @BeforeEach
    public void beforeEach() {
        if (calculator==null) {
            calculator = new Calculator();
        }
        if (random==null) {
            random = new Random();
        }
    }


    @Order(1)
    @Test
    public void testAdd() {
        int a = 10, b = 20;
        long result = calculator.add(10,20);
        System.out.printf("testAdd: a=%d, b=%d, result=%d%n", a, b, result);
        Assertions.assertEquals(Math.addExact((long)a, (long)b), result, "Assertion failed.");
    }

    @Order(2)
    @Test
    public void testAdd_random() {
        int a = random.nextInt(100000);
        int b = random.nextInt(200000);
        long result = calculator.add(a, b);
        System.out.printf("testAdd: a=%d, b=%d, result=%d%n", a, b, result);
        Assertions.assertEquals(Math.addExact((long)a, (long)b), result, "Assertion failed.");
    }

    @Order(3)
    @Test
    public void testMultiply() {
        int a = 10, b = 20;
        long result = calculator.multiply(a, b);
        System.out.printf("testMultiply: a=%d, b=%d, result=%d%n", a, b, result);
        Assertions.assertEquals(Math.multiplyExact((long)a, (long)b), result, "Assertion failed.");
    }

    @Order(4)
    @Test
    public void testMultiplyRandom() {
        int a = random.nextInt(100000);
        int b = random.nextInt(200000);
        long result = calculator.multiply(a, b);
        System.out.printf("testMultiplyRandom: a=%d, b=%d, result=%d%n", a, b, result);
        Assertions.assertEquals(Math.multiplyExact((long)a, (long)b), result, "Assertion failed.");
    }
}
