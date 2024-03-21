package com.dev.rafael.chapter_02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class BankTransactionAnalyzerSimple {
    private static final String RESOURCES = "src/main/resources/";

    public static void main(String[] args) throws IOException {
        final Path path = Paths.get(RESOURCES + "bank-data-simple.csv");
        final List<String> lines = Files.readAllLines(path);
        double total = 0;

        for (int i = 0; i < lines.size(); i++) {
            final String[] columns = lines.get(i).split(",");
            final double amount = Double.parseDouble(columns[1]);
            total += amount;

            System.out.println("read line[" + i + "]: " + lines.get(i));
        }
        System.out.println("The total for all transactions is " + total);
    }

}
