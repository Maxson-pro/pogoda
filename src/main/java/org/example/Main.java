package org.example;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите город без цифр и пробелов ИСПОЛЬЗУЯ ДЕФИЗ");
        String city = scanner.nextLine().trim();

        boolean Ofibka = false;
        for (char c : city.toCharArray()) {
            if (Character.isDigit(c) || c == ' ') {
                Ofibka = true;
                break;
            }
        }
        if (Ofibka) {
            System.out.println("Офибка: вводите город без цифр и пробелов.");
            return;
        }

        String api = "f311ceff80e6770c2c0557f027bca259";
        String urlString = "https://api.openweathermap.org/data/2.5/forecast?q=" + city + "&appid=f311ceff80e6770c2c0557f027bca259&units=metric&lang=ru";

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

            System.out.println("Прогноз погоды в " + city );
            for (int i = 0; i < list.length(); i += 8) {
                JSONObject fore = list.getJSONObject(i);
                double temp = fore.getJSONObject("main").getDouble("temp");
                String description = fore.getJSONArray("weather").getJSONObject(0).getString("description");
                System.out.println(description + " температура " + String.format("%.2f", temp) + "°C");
            }
        } catch (Exception e) {
            System.out.println("Офибка ГОРЛОВОЙ ");
        }
    }
}