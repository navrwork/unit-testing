package com.navr.junitdemo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class) // default JUnit 4 runner
public class CalculatorTest {

    Calculator calc;

    @Before
    public void setUp() {
        calc = new Calculator();
    }
    @Test
    public void test_01_addPositiveNumbers() {
        int out = calc.add(10,20);
        Assert.assertTrue(out > 0);
    }

    @Test
    public void test_02_addNegativeNumbers() {
        int out = calc.add(-10,-20);
        Assert.assertTrue(out < 0);
    }
}
