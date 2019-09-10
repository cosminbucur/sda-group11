package com.bucur.grasp.pure_fabrication;

public class YahooWeatherService implements WeatherService {

    @Override
    public String getWeatherForToday() {
        return "the temperature for today is 25 degrees Celsius";
    }
}
