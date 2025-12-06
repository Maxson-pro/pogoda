package org.example;

import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class ApiGet {
    public String getCity(int num1) {
        String city = "";
        if (num1 == 1) {
            try {
                String IpUrl = "https://api.ipify.org?format=text";
                BufferedReader brIp = new BufferedReader(new InputStreamReader(new URL(IpUrl).openStream()));
                String ipMoy = brIp.readLine();
                brIp.close();

                String geoIp = "https://ipinfo.io/" + ipMoy + "/json";
                BufferedReader brgeo = new BufferedReader(new InputStreamReader(new URL(geoIp).openStream()));
                StringBuilder strBu = new StringBuilder();
                String lineGeo;
                while ((lineGeo = brgeo.readLine()) != null) {
                    strBu.append(lineGeo);
                }
                brgeo.close();

                JSONObject geojson = new JSONObject(strBu.toString());
                String cityIp = geojson.optString("city");
                if (cityIp == null || cityIp.isEmpty()) {
                    System.out.println("Непонятный город");
                    return null;
                }
                city = cityIp;
                System.out.println("Город: " + city);

            } catch (Exception e) {
                System.out.println("Ошибка");
                return null;
            }
        }
        return city;
    }
}