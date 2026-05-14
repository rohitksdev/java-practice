package com.rohitksdev.weatherapi;

import com.rohitksdev.weatherapi.cli.WeatherCommand;
import picocli.CommandLine;

public class Main {
    public static void main(String[] args) {
        int exitCode = new CommandLine(new WeatherCommand())
                .execute(args);

        System.exit(exitCode);
    }
}
