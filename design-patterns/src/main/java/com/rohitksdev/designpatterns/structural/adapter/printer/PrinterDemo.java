package com.rohitksdev.designpatterns.structural.adapter.printer;

import static com.rohitksdev.designpatterns.structural.adapter.printer.Client.clientCode;

public class PrinterDemo {
    public static void main(String[] args) {
        // Using the Adapter
        PrinterAdapter adapter = new PrinterAdapter();
        clientCode(adapter);
    }
}
