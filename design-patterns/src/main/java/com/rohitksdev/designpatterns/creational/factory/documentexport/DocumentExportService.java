package com.rohitksdev.designpatterns.creational.factory.documentexport;

public class DocumentExportService {
    DocumentCreator documentCreator;
    public DocumentExportService(DocumentCreator documentCreator) {
        this.documentCreator = documentCreator;
    }

    public void generateReport(String content) {
        this.documentCreator.export(content);
    }
}
