package com.infoshareacademy.finances.service;

import com.infoshareacademy.finances.model.DailyValue;
import com.infoshareacademy.finances.model.Fund;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

public class FundDataLoader {

    public Fund loadDataFromFile(String filePath, Optional<Fund> fund) {
        Path path = Paths.get(filePath);
        Fund realFund = null;
        Collection<DailyValue> dailyValues = new ArrayList<DailyValue>();

        DateFormat format = new SimpleDateFormat("yyyyMMdd" , Locale.ENGLISH);

        try {
            List<String> lines = Files.readAllLines(path);
            int size = lines.size();
            for (int i = 1; i < size; i++) {
                String[] fields = lines.get(i).split(",");
                Date date = null;
                try {
                    date = format.parse(fields[1]);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                BigDecimal closeValue = new BigDecimal(fields[4]);
                DailyValue dailyValue = new DailyValue(date, closeValue);
                dailyValues.add(dailyValue);
            }

            if (fund.isPresent()) {
                fund.setValues(dailyValues);
                realFund = fund;
            } else {
                realFund = new Fund(dailyValues,"none","none");
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


        return realFund;
    }



}
