package com.navr.junit4.demo;

import org.junit.*;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SampleJunit4Test {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("SampleJunitTest: Inside beforeClass()");
    }

    @Before
    public void setUp() {
        System.out.println("SampleJunitTest: Inside setUp()");
    }

    @After
    public void tearDown() {
        System.out.println("SampleJunitTest: Inside tearDown()");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("SampleJunitTest: Inside afterClass()");
    }

    @Test
    public void test_01_assertTrue() {
        System.out.println("SampleJunitTest: Inside test_01_assertTrue() ..");
        Assert.assertTrue(1>0);
    }

    @Test
    public void test_02_assertFalse() {
        System.out.println("SampleJunitTest: Inside test_02_assertFalse() ..");
        Assert.assertFalse(1<0);
    }

    @Test
    public void test_03_assertNull() {
        System.out.println("SampleJunitTest: Inside test_03_assertNull() ..");
        Object obj = null;
        Assert.assertNull(obj);
    }

    @Test
    public void test_04_assertNotNull() {
        System.out.println("SampleJunitTest: Inside test_04_assertNotNull() ..");
        Object obj = new Object();
        Assert.assertNotNull(obj);
    }

    @Test
    public void test_05_assertEquals() {
        System.out.println("SampleJunitTest: Inside test_05_assertEquals() ..");
        String s1 =  new String("hello");
        String s2 =  new String("hello");
        Assert.assertEquals(s1, s2); // s1.equals(s2) => TRUE
    }

    @Test
    public void test_06_assertNotEquals() {
        System.out.println("SampleJunitTest: Inside test_06_assertNotEquals() ..");
        String s1 =  new String("hello");
        String s2 =  new String("World");
        Assert.assertNotEquals(s1, s2); // s1.equals(s2) => FALSE
    }

    @Test
    public void test_07_assertSame() {
        System.out.println("SampleJunitTest: Inside test_07_assertSame() ..");
        String s1 =  new String("hello");
        String s2 =  s1;
        Assert.assertSame(s1, s2); // s1==s2 => TRUE
    }

    @Test
    public void test_08_assertNotSame() {
        System.out.println("SampleJunitTest: Inside test_08_assertNotSame() ..");
        String s1 =  new String("hello");
        String s2 =  new String("Hello");
        Assert.assertNotSame(s1, s2); // s1==s2 => FALSE
    }

    @Test (expected = NullPointerException.class)
    public void test_11_expectedNullPointerException() {
        System.out.println("SampleJunitTest: Inside test_11_expectedNullPointerException() ..");
        Object obj = null;
        String s = obj.toString();
    }

    @Test (timeout = 2000)
    public void test_12_executeBeforeTimeout() {
        System.out.println("SampleJunitTest: Inside test_12_executeBeforeTimeout() ..");
        // do something before timeout
    }

    @Ignore("This method not ready yet")
    @Test
    public void test_13_methodNotReadyYet() {
        System.out.println("SampleJunitTest: Inside test_13_methodNotReadyYet() ..");
        // This method won't get executed and will be ignored
    }

}
