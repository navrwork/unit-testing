package com.navr.junit5.demo.pkg1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.Random;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestA {

    private Random random;

    @BeforeEach
    public void beforeEach() {
        random = new Random();
    }

    @Order(1)
    @Tag("simple")
    @Test
    public void testAdd_simple() {
        int a = 1000;
        int b = 2000;
        long result = a + b;
        System.out.printf("TestA: testAdd_simple: a=%d, b=%d, result=%d%n", a, b, result);
        Assertions.assertEquals(Math.addExact((long) a, (long) b), result, "Assertion failed.");
    }

    @Order(2)
    @Tag("random")
    @Test
    public void testAdd_random() {
        int a = random.nextInt(1000);
        int b = random.nextInt(2000);
        long result = a + b;
        System.out.printf("TestA: testAdd_random: a=%d, b=%d, result=%d%n", a, b, result);
        Assertions.assertEquals(Math.addExact((long) a, (long) b), result, "Assertion failed.");
    }

}
