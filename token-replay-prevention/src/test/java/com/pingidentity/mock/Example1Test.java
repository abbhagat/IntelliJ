package com.pingidentity.mock;

import org.junit.Test;
import org.mockito.Spy;

public class Example1Test {

    @Spy
    private Example1 example1Test;

    @Test
    public void printTest() {
        example1Test.print();
    }
}