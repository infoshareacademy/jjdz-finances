package com.infoshareacademy.finances.service;

import com.infoshareacademy.finances.model.DailyValue;
import com.infoshareacademy.finances.model.Fund;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class FundDataLoader {

    public List<DailyValue> loadDataFromFile(String filePath) {
        Path path = Paths.get(filePath);
        List<DailyValue> dailyValues = new ArrayList<DailyValue>();
        try {
            List<String> lines = Files.readAllLines(path);
            int size = lines.size();
            for (int i = 1; i < size; i++) {
                String[] fields = lines.get(i).split(",");

                ZonedDateTime date = ZonedDateTime.parse(fields[1], DateTimeFormatter.BASIC_ISO_DATE.withZone(ZoneId.of("Poland")));
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
