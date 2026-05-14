package com.rohitksdev.weatherapi.cli;

import com.rohitksdev.weatherapi.model.WeatherResponse;
import com.rohitksdev.weatherapi.service.WeatherService;
import com.rohitksdev.weatherapi.utils.WeatherPrinter;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(
        name = "weather-cli",
        mixinStandardHelpOptions = true,
        version = "1.0",
        description = "Fetch weather details using coordinates"
)
public class WeatherCommand implements Runnable {
    @Option(
            names = "--lat",
            required = true,
            description = "Latitude"
    )
    private double latitude;

    @Option(
            names = "--long",
            required = true,
            description = "Longitude"
    )
    private double longitude;

    @Override
    public void run() {

        System.out.println("Latitude: " + latitude);
        System.out.println("Longitude: " + longitude);

        // Call weather service here
        WeatherService service = new WeatherService();

        WeatherResponse weather = service.getCurrentWeather(latitude, longitude);
        WeatherPrinter.print(weather);
    }
}
