package com.rohitksdev.designpatterns.structural.adapter.printer;

import com.rohitksdev.designpatterns.structural.adapter.printer.LegacyPrinter;

public class PrinterAdapter implements Printer{
    @Override
    public void print() {
        LegacyPrinter legacyPrinter = new LegacyPrinter();
        legacyPrinter.printDocument();
    }
}
