package com.navr.junit5.demo;


import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;

import java.time.Duration;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class Junit5DemoTest {

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Junit5DemoTest: Inside beforeAll()");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Junit5DemoTest: Inside afterAll()");
    }

    @BeforeEach
    public void setUp() {
        System.out.println("Junit5DemoTest: Inside setUp()");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Junit5DemoTest: Inside tearDown()");
    }


    @Test
    public void test_01_assertTrue() {
        System.out.println("Junit5DemoTest: Inside test_01_assertTrue() ..");
        Assertions.assertTrue(1>0);
    }

    @Test
    public void test_02_assertFalse() {
        System.out.println("Junit5DemoTest: Inside test_02_assertFalse() ..");
        Assertions.assertFalse(1<0);
    }

    @Test
    public void test_03_assertNull() {
        System.out.println("Junit5DemoTest: Inside test_03_assertNull() ..");
        Object obj = null;
        Assertions.assertNull(obj);
    }

    @Test
    public void test_04_assertNotNull() {
        System.out.println("Junit5DemoTest: Inside test_04_assertNotNull() ..");
        Object obj = new Object();
        Assertions.assertNotNull(obj);
    }

    @Test
    public void test_05_assertEquals() {
        System.out.println("Junit5DemoTest: Inside test_05_assertEquals() ..");
        String s1 =  new String("hello");
        String s2 =  new String("hello");
        Assertions.assertEquals(s1, s2); // s1.equals(s2) => TRUE
    }

    @Test
    public void test_06_assertNotEquals() {
        System.out.println("Junit5DemoTest: Inside test_06_assertNotEquals() ..");
        String s1 =  new String("hello");
        String s2 =  new String("World");
        Assertions.assertNotEquals(s1, s2); // s1.equals(s2) => FALSE
    }

    @Test
    public void test_07_assertSame() {
        System.out.println("Junit5DemoTest: Inside test_07_assertSame() ..");
        String s1 =  new String("hello");
        String s2 =  s1;
        Assertions.assertSame(s1, s2); // s1==s2 => TRUE
    }

    @Test
    public void test_08_assertNotSame() {
        System.out.println("Junit5DemoTest: Inside test_08_assertNotSame() ..");
        String s1 =  new String("hello");
        String s2 =  new String("Hello");
        Assertions.assertNotSame(s1, s2); // s1==s2 => FALSE
    }

    @Test
    public void test_11_expectedNullPointerException() {
        System.out.println("Junit5DemoTest: Inside test_11_expectedNullPointerException() ..");
        Object obj = null;
        Executable executable = () -> {
            String string = obj.toString();
        };
        Assertions.assertThrows(NullPointerException.class, executable);
    }

    @Test
    public void test_12_executeBeforeTimeout() {
        System.out.println("Junit5DemoTest: Inside test_12_executeBeforeTimeout() ..");
        // do something before timeout
        Executable executable = () -> {
            // call some service here
            System.out.println("Inside executable");
        };
        Assertions.assertTimeout(Duration.ofMillis(100), executable);
    }

    @Disabled
    @Test
    public void test_13_methodNotReadyYet() {
        System.out.println("Junit5DemoTest: Inside test_13_methodNotReadyYet() ..");
        // This method won't get executed and will be ignored
    }

}
