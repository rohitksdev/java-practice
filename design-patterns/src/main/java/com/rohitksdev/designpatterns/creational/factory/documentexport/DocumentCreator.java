package com.rohitksdev.designpatterns.creational.factory.documentexport;

public abstract class DocumentCreator {
    public abstract Document createDocument();

    public void export(String content) {
        Document doc = createDocument();

        System.out.println("Exporting to " + doc.getFileExtension() + " format...");

        String header = doc.getHeader();
        if (!header.isEmpty()) {
            System.out.println(header);
        }

        System.out.println(doc.getBody(content));

        String footer = doc.getFooter();
        if (!footer.isEmpty()) {
            System.out.println(footer);
        }

        System.out.println("\nExport complete.\n");
    }
}
