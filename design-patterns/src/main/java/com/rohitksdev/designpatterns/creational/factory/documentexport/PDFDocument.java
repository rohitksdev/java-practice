package com.rohitksdev.designpatterns.creational.factory.documentexport;

public class PDFDocument implements Document{
    @Override
    public String getHeader() {
        return "Sales PDF document";
    }

    @Override
    public String getBody(String data) {
        return "Sales data for the month May";
    }

    @Override
    public String getFooter() {
        return "Copyright Acme Corporation";
    }

    @Override
    public String getFileExtension() {
        return ".pdf";
    }
}
