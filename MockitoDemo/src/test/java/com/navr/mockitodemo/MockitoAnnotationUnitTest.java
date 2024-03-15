package com.navr.mockitodemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.MethodName.class)
public class MockitoAnnotationUnitTest {

    @Mock
    List<String> mockedList;

    @Spy
    List<String> spiedList = new ArrayList<>();

    @Test
    public void test_01_MockedList() {
        mockedList.add("one");
        Mockito.verify(mockedList).add("one");
        assertEquals(0, mockedList.size());

        when(mockedList.size()).thenReturn(100);
        assertEquals(100, mockedList.size());
    }

    @Test
    public void test_02_SpiedListWithThenReturn() {
        spiedList.add("one");
        spiedList.add("two");

        Mockito.verify(spiedList).add("one");
        Mockito.verify(spiedList).add("two");
        assertEquals(2, spiedList.size());

        when(spiedList.size()).thenReturn(200);
        assertEquals(200, spiedList.size());
    }

    @Test
    public void test_02_SpiedListWithDoReturn() {
        spiedList.add("one");
        spiedList.add("two");

        Mockito.verify(spiedList).add("one");
        Mockito.verify(spiedList).add("two");
        assertEquals(2, spiedList.size());

        Mockito.doReturn(200).when(spiedList).size();
        assertEquals(200, spiedList.size());
    }

    @Test
    public void test_03_WhenThenReturnSideEffect() {
        List<String> list = new LinkedList<>();
        List<String> spy = Mockito.spy(list);

        Executable executable = () -> {
            // Real method is called. So spy.get(0)
            // throws IndexOutOfBoundsException (the list is yet empty)
            when(spy.get(0)).thenReturn("foo"); // side effect while using when-thenReturn
        };
        Assertions.assertThrows(IndexOutOfBoundsException.class, executable);
    }

    @Test
    @MockitoSettings(strictness = Strictness.LENIENT) // required to handle UnnecessaryStubbingException
    public void test_03_DoReturnNoSideEffect() {
        List<String> list = new LinkedList<>();
        List<String> spy = Mockito.spy(list);

        // No side effect (IndexOutOfBoundsException) while using doReturn
        Mockito.doReturn("foo").when(spy).get(0);
    }

}