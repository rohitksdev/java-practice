package com.rohitksdev.designpatterns.creational.factory.documentexport;


public class HTMLDocumentCreator extends DocumentCreator{

    @Override
    public Document createDocument() {
        return new HTMLDocument();
    }
}
