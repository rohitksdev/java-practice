package com.rohitksdev.designpatterns.creational.factory.documentexport;

public class DocumentExportDemo {
    public static void main(String[] args) {
        DocumentExportService pdfDocumentExportService = new DocumentExportService(new PDFDocumentCreator());
        DocumentExportService htmlDocumentExportService = new DocumentExportService(new HTMLDocumentCreator());

        pdfDocumentExportService.generateReport("Sales report for our company");
        htmlDocumentExportService.generateReport("Sales report for our company");

    }
}
