package com.rohitksdev.weatherapi.service;

import com.rohitksdev.weatherapi.client.WeatherApiClient;
import com.rohitksdev.weatherapi.model.WeatherResponse;

public class WeatherService {
    private final WeatherApiClient apiClient;

    public WeatherService() {
        this.apiClient = new WeatherApiClient();
    }

    public WeatherResponse getCurrentWeather(double lat, double lon) {

        validateCoordinates(lat, lon);

        return apiClient.fetchCurrentWeather(lat, lon);
    }

    private void validateCoordinates(double lat, double lon) {

        if (lat < -90 || lat > 90) {
            throw new IllegalArgumentException("Invalid latitude");
        }

        if (lon < -180 || lon > 180) {
            throw new IllegalArgumentException("Invalid longitude");
        }
    }
}
