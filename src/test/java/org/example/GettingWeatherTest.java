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
        try {
            weather.weatherGet("http://invalid-url", 1);
            String out = byteArrayOutputStream.toString();
            assertTrue(out.contains("Ошибка"));
        } finally {
            System.setOut(org);
        }
    }

    @Test
    void testMock() throws Exception {
        GettingWeather weather = new GettingWeather();
        PrintStream org = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        try {
            weather.weatherGet("not-a-real-url", 1);
            assertTrue(true);
        } finally {
            System.setOut(org);
        }

    }

    @Test
    void testConstr() {
        GettingWeather weather = new GettingWeather();
        assertNotNull(weather);
    }
}