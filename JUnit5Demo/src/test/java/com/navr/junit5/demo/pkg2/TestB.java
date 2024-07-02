package com.navr.junit5.demo.pkg2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.Random;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestB {

    private Random random;

    @BeforeEach
    public void beforeEach() {
        random = new Random();
    }

    @Order(1)
    @Tag("simple")
    @Test
    public void testMultiply_simple() {
        int a = 100;
        int b = 200;
        long result = a * b;
        System.out.printf("TestB: testMultiply_simple: a=%d, b=%d, result=%d%n", a, b, result);
        Assertions.assertEquals(Math.multiplyExact((long) a, (long) b), result, "Assertion failed.");
    }

    @Order(2)
    @Tag("random")
    @Test
    public void testMultiply_random() {
        int a = random.nextInt(100);
        int b = random.nextInt(200);
        long result = a * b;
        System.out.printf("TestB: testMultiply_random: a=%d, b=%d, result=%d%n", a, b, result);
        Assertions.assertEquals(Math.multiplyExact((long) a, (long) b), result, "Assertion failed.");
    }

}
