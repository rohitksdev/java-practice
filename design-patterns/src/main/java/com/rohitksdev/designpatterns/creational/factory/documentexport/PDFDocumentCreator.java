package com.rohitksdev.designpatterns.creational.factory.documentexport;

public class PDFDocumentCreator extends DocumentCreator{
    @Override
    public Document createDocument() {
        return new PDFDocument();
    }
}
