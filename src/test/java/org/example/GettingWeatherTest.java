package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class GettingWeatherTest {

    @Test
    void weatherGet() {
        GettingWeather weather = new GettingWeather();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream ();
        PrintStream orig = System.out;
        System.setOut(new PrintStream(outputStream));
        try {
            weather.weatherGet("http://test.invalid", 1);
            String output = outputStream.toString();
            assert (output.contains("Ошибка"));

        } finally {
            System.setOut(orig);
        }

    }
}