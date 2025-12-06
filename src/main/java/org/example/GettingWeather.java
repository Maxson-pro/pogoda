package org.example;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class GettingWeather {
    public void weatherGet(String urlString, int num1) {
        try {
            URL url = new URL(urlString);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            br.close();
            JSONObject json = new JSONObject(sb.toString());
            JSONArray list = json.getJSONArray("list");
            String city = json.optJSONObject("city").optString("name", "неизвестно");
            System.out.println("Прогноз погоды в " + city);
            for (int i = 0; i < list.length() && i / 8 < 7; i += 8) {
                JSONObject fore = list.getJSONObject(i);
                double temp = fore.getJSONObject("main").getDouble("temp");
                String description = fore.getJSONArray("weather").getJSONObject(0).getString("description");
                System.out.println(description + ", температура " + String.format("%.2f", temp) + "°C");
            }
        } catch (Exception e) {
            System.out.println("Ошибка при получении данных о погоде");
        }
    }
}