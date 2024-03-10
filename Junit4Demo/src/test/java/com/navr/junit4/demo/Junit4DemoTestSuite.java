package com.navr.junit4.demo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CalculatorTest.class,
        Junit4DemoTest.class
})
public class Junit4DemoTestSuite {
    // the class remains empty,
    // used only as a holder for the above annotations
}
