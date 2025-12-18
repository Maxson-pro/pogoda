package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class SelectionTest {

    @Test
    void getNum1() {
        System.setIn(new ByteArrayInputStream("1\n".getBytes()));
        Selection selection = new Selection();
        assertEquals(1, selection.getNum1());
    }
}