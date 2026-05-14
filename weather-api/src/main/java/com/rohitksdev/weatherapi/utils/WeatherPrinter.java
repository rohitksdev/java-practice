package com.rohitksdev.weatherapi.utils;

import com.rohitksdev.weatherapi.model.Day;
import com.rohitksdev.weatherapi.model.WeatherResponse;

public class WeatherPrinter {

    public static void print(WeatherResponse weather) {
        if (weather == null || weather.getDays() == null || weather.getDays().isEmpty()) {
            throw new IllegalStateException("Weather data is unavailable for the requested location");
        }

        Day today = weather.getDays().getFirst();
        if (today == null) {
            throw new IllegalStateException("Weather data is incomplete for the requested location");
        }

        System.out.println("--------------------------------");
        System.out.println("Weather Report");
        System.out.println("--------------------------------");

        System.out.printf("Location    : %s%n",
                weather.getResolvedAddress());

        System.out.printf("Date        : %s%n",
                today.getDatetime());

        System.out.printf("Temperature : %.1f°F%n",
                today.getTemp());

        System.out.printf("Humidity    : %.1f%%%n",
                today.getHumidity());

        System.out.printf("Wind Speed  : %.1f mph%n",
                today.getWindspeed());

        System.out.printf("Conditions  : %s%n",
                today.getConditions());

        System.out.printf("Sunrise     : %s%n",
                today.getSunrise());

        System.out.printf("Sunset      : %s%n",
                today.getSunset());
    }
}
