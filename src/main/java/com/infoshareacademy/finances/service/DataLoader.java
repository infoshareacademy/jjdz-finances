package com.infoshareacademy.finances.service;

import com.infoshareacademy.finances.model.DailyValue;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DataLoader {

    public List<DailyValue> loadDataFromFile(String filePath) {
        Path path = Paths.get(filePath);
        List<DailyValue> dailyValues = new ArrayList<DailyValue>();
        try {
            List<String> lines = Files.readAllLines(path);
            int size = lines.size();
            for (int i = 1; i < size; i++) {
                String[] fields = lines.get(i).split(",");

                LocalDate date = LocalDate.parse(fields[1], DateTimeFormatter.BASIC_ISO_DATE);
                BigDecimal closeValue = new BigDecimal(fields[4]);
                DailyValue dailyValue = new DailyValue(date, closeValue);
                dailyValues.add(dailyValue);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return dailyValues;
    }



}
