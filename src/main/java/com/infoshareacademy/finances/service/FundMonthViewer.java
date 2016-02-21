package com.infoshareacademy.finances.service;

import com.infoshareacademy.finances.model.DailyValue;
import com.infoshareacademy.finances.model.Fund;
import com.infoshareacademy.finances.model.YearMonth;

import java.time.Year;
import java.util.*;

public class FundMonthViewer {
    private static final int numOfMonths = 12;

    public static void showMonths(Fund fund) {
        List<DailyValue> dailyValues = fund.getDailyValues();
        List<YearMonth> yearsMonths;

        yearsMonths = parseYearsAndMonthsToObjectList(getYearMonthsStringsFromDailyValues(dailyValues));
        int size = yearsMonths.size();
        for (int i = 0; i < size; i++) {
            System.out.print(yearsMonths.get(i).getYear() + "  ");
            int sizeJ = yearsMonths.get(i).getMonths().size();
            for (int j = 0; j < sizeJ; j++) {
                String temp = yearsMonths.get(i).getMonths().get(j);
                System.out.print(temp + "  ");
            }
            System.out.println();
        }
    }

    private static ArrayList<YearMonth> parseYearsAndMonthsToObjectList(List<String> yearMonthsStrings) {
        YearMonth yearMonth;
        ArrayList<YearMonth> yearMonths = new ArrayList<YearMonth>();
        int size = yearMonthsStrings.size();
        int i = 0;

        while (i < size) {
            String year = yearMonthsStrings.get(i).substring(0, 4);
            List<String> months = new ArrayList<String>();
            while (year.equals(yearMonthsStrings.get(i).substring(0, 4))) {
                months.add(yearMonthsStrings.get(i).substring(4));
                i++;
                if (i == size) {
                    break;
                }
            }
            yearMonth = new YearMonth(year, months);
            yearMonths.add(yearMonth);
        }
        return yearMonths;
    }

    private static List<String> getYearMonthsStringsFromDailyValues(List<DailyValue> dailyValues) {
        List<String> months = new ArrayList<String>();
        int size = dailyValues.size();
        for (int i = 0; i < size; i++) {
            String yearMonth;
            yearMonth = dailyValues.get(i).getDate().substring(0, 6);
            if (!months.contains(yearMonth)) {
                months.add(yearMonth);
            }
        }
        return months;
    }
}
