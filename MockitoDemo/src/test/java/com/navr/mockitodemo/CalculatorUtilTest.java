package com.navr.mockitodemo;

import com.navr.mockitodemo.calculator.CalculatorUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.times;

/**
 * Mockito example for static methods.
 */
@TestMethodOrder(MethodOrderer.MethodName.class)
public class CalculatorUtilTest {

    /**
     * Mock a static no-arg method with void return
     */
    @Test
    public void test_01_PrintHello() {
        // Mock static class in try block
        try (MockedStatic<CalculatorUtil> mockedStatic = Mockito.mockStatic(CalculatorUtil.class)) {
            //
            // #1: Mock the static method call
            //
            mockedStatic
                    .when(CalculatorUtil::printHello)
                    .then(invocationOnMock -> {
                        System.out.println("Mock Hello!");
                        return null;
                    });
            //
            // OR the below can be used as well to mock static method
            //
            mockedStatic
                    .when(CalculatorUtil::printHello)
                    .then(invocationOnMock -> null);

            //
            // #2: Invoke the actual static method
            //
            CalculatorUtil.printHello(); // Prints "Mock Hello"

            //
            // #3: Validate if the method call indeed happened
            //
            mockedStatic.verify(CalculatorUtil::printHello);
            mockedStatic.verify(CalculatorUtil::printHello, Mockito.times(1));
        }
    }

    /**
     * Mock a static one-arg method with void return
     */
    @Test
    public void test_02_PrintMessage() {
        //
        // Static method with
        //
        try (MockedStatic<CalculatorUtil> mockedStatic = Mockito.mockStatic(CalculatorUtil.class)) {
            // #1: Mock method call
            //
            // Use the below
            //
            // mockedStatic.when(() -> CalculatorUtil.printMessage(anyString())).then(invocationOnMock -> null);
            //
            // OR use the below
            //
            mockedStatic
                    .when(() -> CalculatorUtil.printMessage(anyString()))
                    .then(invocationOnMock -> {
                        System.out.println("Mock message!");
                        return null;
                    });

            // #2: Invoke actual method
            CalculatorUtil.printMessage("hi");

            // #3: Verify
            mockedStatic.verify(
                    () -> CalculatorUtil.printMessage(anyString()), Mockito.times(1)
            );
        }
    }

    /**
     * Mock a static two-arg method with String return type
     */
    @Test
    public void test_03_Concat() {
        final String MOCKED_RESULT = "mock_abcd";
        try (MockedStatic<CalculatorUtil> mockedStatic = mockStatic(CalculatorUtil.class)) {
            // #1: Mock method call
            mockedStatic
                    .when(() -> CalculatorUtil.concat(anyString(), anyString()))
                    .then(invocationOnMock -> MOCKED_RESULT);

            //
            // #2: Invoke actual method
            //
            String mockedResult = CalculatorUtil.concat("aaa", "bbb");
            System.out.printf("testConcat: mockedResult=%s%n", mockedResult);

            // #3: Verify
            Assertions.assertEquals(MOCKED_RESULT, mockedResult);
            mockedStatic.verify(
                    () -> CalculatorUtil.concat(anyString(), anyString()), times(1)
            );
        }
    }
}
