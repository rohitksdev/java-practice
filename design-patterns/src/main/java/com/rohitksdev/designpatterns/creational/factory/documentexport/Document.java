package com.rohitksdev.designpatterns.creational.factory.documentexport;

public interface Document {
    String getHeader();
    String getBody(String data);
    String getFooter();
    String getFileExtension();
}
