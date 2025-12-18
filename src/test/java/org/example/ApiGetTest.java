package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApiGetTest {

    @Test
    void getCity() {
        ApiGet apiGet = new ApiGet();
        assertEquals("", apiGet.getCity(0));
        assertEquals("", apiGet.getCity(999));
        String result = apiGet.getCity(1);
        if (result != null) {
            assertFalse(result.isEmpty(), "ПУСТАЯ СТРОКА");
        }
    }
}