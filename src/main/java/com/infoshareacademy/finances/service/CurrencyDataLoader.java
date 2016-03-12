package com.infoshareacademy.finances.service;

import com.infoshareacademy.finances.model.DailyValue;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CurrencyDataLoader {
    public List<DailyValue> loadDataFromFile(String filePath) {
        Path path = FileSystems.getDefault().getPath(filePath);
        List<DailyValue> listDailyCurrencyValue = new ArrayList<>();
        try {
            List<String> listaLines = Files.readAllLines(path);
            int size = listaLines.size();

            for (int i=1; i<size; i++) {
                //System.out.println("Linia " +i + " " + listaLines.get(i));
                String[] tabItems = listaLines.get(i).split(",");

                //get i parse date
                String text = tabItems[1];
                DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;
                LocalDate parsedDate = LocalDate.parse(text, formatter);

                //get value
                BigDecimal currencyValue = new BigDecimal(tabItems[4]);

                DailyValue dailyValue = new DailyValue(parsedDate, currencyValue);
                listDailyCurrencyValue.add(dailyValue);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listDailyCurrencyValue;
    }
}