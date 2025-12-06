package org.example;

public class StrUrl {
    private String city;

    public StrUrl(String city) {
        this.city = city;
    }
    public String getUrlString(){
        return "https://api.openweathermap.org/data/2.5/forecast?q=" + city +
                "&appid=f311ceff80e6770c2c0557f027bca259&units=metric&lang=ru";
    }
}
