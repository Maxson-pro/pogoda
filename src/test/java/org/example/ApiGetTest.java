package org.example;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ApiGetTest {

    @Test
    void testGerCity() {
        ApiGet api = new ApiGet();
        String res = api.getCity(2);
        assertEquals("", res);
    }
@Test
    void testGerCity1() {
        ApiGet api = new ApiGet();
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStream));

    try {
        String result = api.getCity(1);
        assertTrue(result == null || !result.isEmpty());
        String output = outputStream.toString();
        if (result == null) {
            assertTrue(output.contains("Ошибка") || output.contains("Непонятный город"));
        } else {
            assertTrue(output.contains("Город:"));
        }
    } finally {
        System.setOut(System.out);
    }
}
@Test
    void testCon() {
        ApiGet apiGet = new ApiGet();
        assertNotNull(apiGet);
}
}
