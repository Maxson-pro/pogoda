package org.example;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ApiGetTest {

    @Test
    void testOne() {
        ApiGet apiGet = new ApiGet();
        assertEquals("", apiGet.getCity(0));
    }
    @Test
    void testOneAgiin() {
        ApiGet apiGet = new ApiGet();
        assertEquals("", apiGet.getCity(100));
    }
    @Test
    void testisOne() {
        ApiGet apiGet = new ApiGet();
       apiGet.getCity(1);
       assertTrue(true);
    }

}
