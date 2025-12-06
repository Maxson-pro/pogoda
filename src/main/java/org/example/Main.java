package org.example;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Selection selection = new Selection();
        int num1 = selection.getNum1();
        ApiGet apiGet = new ApiGet();
        String city = apiGet.getCity(num1);
        if (city == null || city.isEmpty()) {
            System.out.println("Город не определен");
            return;
        }
        StrUrl strUrl = new StrUrl(city);
        String urlString = strUrl.getUrlString();
        GettingWeather gettingWeather = new GettingWeather();
        gettingWeather.weatherGet(urlString, num1);


    }
}