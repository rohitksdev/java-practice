package com.rohitksdev.designpatterns.creational.factory.documentexport;

public class HTMLDocument implements Document {

    @Override
    public String getHeader() {
        return "<h1> Sales HTML document </h1>";
    }

    @Override
    public String getBody(String data) {
        return "<p>Sales data for the month May</p>";
    }

    @Override
    public String getFooter() {
        return "<footer> Copyright Acme Corporation </footer>";
    }

    @Override
    public String getFileExtension() {
        return ".html";
    }
}
