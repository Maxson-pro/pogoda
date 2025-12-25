package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class GettingWeatherTest {

    @Test
    void testNormCase() {
        GettingWeather weather = new GettingWeather();
        PrintStream org = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));

    }

    @Test
    void testMock() throws Exception {
        GettingWeather weather = new GettingWeather();
        PrintStream org = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));

    }

    @Test
    void testConstr() {
        GettingWeather weather = new GettingWeather();
        assertNotNull(weather);
    }
}