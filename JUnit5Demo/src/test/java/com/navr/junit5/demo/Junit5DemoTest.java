package com.navr.junit5.demo;


import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class Junit5DemoTest {

    private Calculator calc;

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
//        System.out.println("Junit5DemoTest: Inside setUp()");
        calc = new Calculator();
    }

    @AfterEach
    public void tearDown() {
//        System.out.println("Junit5DemoTest: Inside tearDown()");
    }


    @DisplayName("Verify assertTrue")
    @Test
    public void test_01_assertTrue() {
        System.out.println("Junit5DemoTest: Inside test_01_assertTrue() ..");
        Assertions.assertTrue(1 > 0);
    }

    @Test
    public void test_02_assertFalse() {
        System.out.println("Junit5DemoTest: Inside test_02_assertFalse() ..");
        Assertions.assertFalse(1 < 0);
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
        String s1 = new String("hello");
        String s2 = new String("hello");
        assertEquals(s1, s2); // s1.equals(s2) => TRUE
    }

    @Test
    public void test_06_assertNotEquals() {
        System.out.println("Junit5DemoTest: Inside test_06_assertNotEquals() ..");
        String s1 = new String("hello");
        String s2 = new String("World");
        Assertions.assertNotEquals(s1, s2); // s1.equals(s2) => FALSE
    }

    @Test
    public void test_07_assertSame() {
        System.out.println("Junit5DemoTest: Inside test_07_assertSame() ..");
        String s1 = new String("hello");
        String s2 = s1;
        Assertions.assertSame(s1, s2); // s1==s2 => TRUE
    }

    @Test
    public void test_08_assertNotSame() {
        System.out.println("Junit5DemoTest: Inside test_08_assertNotSame() ..");
        String s1 = new String("hello");
        String s2 = new String("Hello");
        Assertions.assertNotSame(s1, s2); // s1==s2 => FALSE
    }

    @Test
    @EnabledOnOs(value = OS.WINDOWS, disabledReason = "Test Enabled Only on Windows OS.")
    public void test_09_enabledOnOs() {
        System.out.println("Junit5DemoTest: Inside test_09_enabledOnOs() ..");
        String s1 = new String("hello");
        String s2 = new String("Hello");
        Assertions.assertNotSame(s1, s2);
    }

    @Test
    @DisabledOnOs(value = {OS.MAC, OS.WINDOWS}, disabledReason = "Test Disabled on Windows and MAC OS.")
    public void test_10_disabledOnOs() {
        System.out.println("Junit5DemoTest: Inside test_10_disabledOnOs() ..");
        String s1 = new String("hello");
        String s2 = new String("Hello");
        Assertions.assertNotSame(s1, s2);
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
            System.out.println("Inside timeout executable");
            //java.util.concurrent.TimeUnit.SECONDS.sleep(2); // Uncomment this to trigger timeout
        };
        Assertions.assertTimeout(Duration.ofMillis(100), executable, "Executable timed out!");
    }

    @Disabled
    @Test
    public void test_13_methodNotReadyYet() {
        System.out.println("Junit5DemoTest: Inside test_13_methodNotReadyYet() ..");
        // This method won't get executed and will be ignored
    }

    /**
     * Test will be aborted/ignored if the assumption is not true. It will NOT be marked as Failed.
     * The test will be executed ONLY if the assumption is true.
     */
    @Test
    public void test_13_assumptions() {
        System.out.println("Junit5DemoTest: Inside test_13_assumptions() ..");
        Assumptions.assumeTrue("DEV".equals(System.getProperty("ENV")));
        String s1 = new String("hello");
        String s2 = new String("Hello");
        Assertions.assertNotSame(s1, s2);
    }

    /**
     * RepeatedTest annotation is used when some randomness is involved in the
     * functionality. The test is repeated multiple times to ensure
     * that the randomness is covered as much as possible.
     */
    @RepeatedTest(value = 5,
            name = "repetition #{currentRepetition} of {totalRepetitions}"
    )
    public void test_14_repeatedTest() {
        int a = (int) (Math.random() * 1000);
        int b = (int) (Math.random() * 1000);
        int result = calc.add(a, b);
        System.out.printf("test_14_repeatedTest: a=%d, b=%d, result=%d%n", a, b, result);
    }

    @ParameterizedTest
    @ValueSource(ints={10,20})
    public void test_15_parameterizedTestValueSource(int a) {
        int b = (int) (Math.random() * 1000);
        int result = calc.add(a, b);
        System.out.printf("test_15_parameterizedTestValueSource: a=%d, b=%d, result=%d%n", a, b, result);
    }

    @ParameterizedTest
    @CsvSource({"test,TEST", "tEst,TEST", "Java,JAVA"})
    void test_16_parameterizedTestCsvSource(String input, String expected) {
        System.out.printf("test_16_parameterizedTestCsvSource: input=%s, expected=%s%n", input, expected);
        String actualValue = input.toUpperCase();
        assertEquals(expected, actualValue);
    }

    @ParameterizedTest
    @MethodSource ("getParamTestData")
    void test_17_parameterizedTestMethodSource(String input, String expected) {
        String actualValue = input.toUpperCase();
        System.out.printf("test_17_parameterizedTestMethodSource: input=%s, expected=%s%n", input, expected);
        assertEquals(expected, actualValue);
    }

    private static Stream<Arguments> getParamTestData() {
        return Stream.of(
                Arguments.of("test", "TEST"),
                Arguments.of("tEst", "TEST"),
                Arguments.of("Java", "JAVA")
        );
    }

}
