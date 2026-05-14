package com.rohitksdev.weatherapi.client;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rohitksdev.weatherapi.model.WeatherResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WeatherApiClient {
    private final HttpClient client;
    private final ObjectMapper mapper = new ObjectMapper().configure(
            DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
            false
    );

    public WeatherApiClient() {
        this.client = HttpClient.newHttpClient();
    }

    public WeatherResponse fetchCurrentWeather(double lat, double lon) {
        String apiKey = System.getenv("WEATHER_API_KEY");
        String url =
                "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/"
                        + lat
                        + "," + lon
                        + "?key="
                        + apiKey;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        try {

            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() < 200 || response.statusCode() >= 300) {
                throw new RuntimeException(
                        "Weather API request failed with status "
                                + response.statusCode()
                                + ": "
                                + response.body()
                );
            }

            WeatherResponse weather =
                    mapper.readValue(response.body(), WeatherResponse.class);

            return weather;

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Weather request was interrupted", e);
        } catch (IOException e) {
            throw new RuntimeException("Failed to fetch weather data", e);
        }
    }
}
