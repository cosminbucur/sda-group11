package com.bucur.grasp.pure_fabrication;

public class DemoPureFabrication {

    // the service does not map to a real life object but it is used
    // to get data from a source for example
    public static void main(String[] args) {
        WeatherService weatherService = new YahooWeatherService();
        weatherService.getWeatherForToday();

    }
}
