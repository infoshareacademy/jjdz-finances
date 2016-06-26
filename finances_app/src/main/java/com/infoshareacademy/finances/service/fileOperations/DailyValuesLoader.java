package com.infoshareacademy.finances.service.fileOperations;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.infoshareacademy.finances.entity.DailyValue;

public class DailyValuesLoader {

    public static final int COLUMN_POSITION_OF_DATE = 1;
    public static final int COLUMN_POSITION_OF_CLOSE_VALUE = 4;

    public List<DailyValue> loadDataFromFile(String filePath) {


        List<DailyValue> dailyValues = new ArrayList<>();
        try {
			InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(filePath);
			List<String> lines = IOUtils.readLines(resourceAsStream, StandardCharsets.UTF_8);

			int size = lines.size();
            for (int i = 1; i < size; i++) {
                String[] fields = lines.get(i).split(",");

                LocalDate date = getLocalDate(fields[COLUMN_POSITION_OF_DATE]);
                BigDecimal closeValue = new BigDecimal(fields[COLUMN_POSITION_OF_CLOSE_VALUE]);
                DailyValue dailyValue = new DailyValue(date, closeValue);
                dailyValues.add(dailyValue);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dailyValues;
    }

    private LocalDate getLocalDate(String field) {
        return LocalDate.parse(field, DateTimeFormatter.BASIC_ISO_DATE);
    }
}
