package com.infoshareacademy.finances.service;

import com.infoshareacademy.finances.model.DailyValue;
import com.infoshareacademy.finances.model.Fund;
import com.infoshareacademy.finances.model.YearMonth;

import java.io.PrintStream;
import java.util.*;

public class FundMonthViewer {

    private final PrintStream out;

    public FundMonthViewer(PrintStream out) {
        this.out = out;
    }

    public void showMonths(Fund fund) {
        List<DailyValue> dailyValues = fund.getDailyValues();
        List<YearMonth> yearsMonths;

        yearsMonths = parseYearsAndMonthsToObjectList(getYearMonthsStringsFromDailyValues(dailyValues));
        int size = yearsMonths.size();
        for (int i = 0; i < size; i++) {
            out.print(yearsMonths.get(i).getYear() + "  ");
            int sizeJ = yearsMonths.get(i).getMonths().size();
            for (int j = 0; j < sizeJ; j++) {
                String month = yearsMonths.get(i).getMonths().get(j);
                int monthInt = Integer.parseInt(month);
                if (j == 0){
                    int k = j + 1;
                    while (monthInt != k){
                        k++;
                        out.print("    ");
                    }
                }
                out.print(month + "  ");
            }
            out.println();
        }
    }

    private ArrayList<YearMonth> parseYearsAndMonthsToObjectList(List<String> yearMonthsStrings) {
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

    private List<String> getYearMonthsStringsFromDailyValues(List<DailyValue> dailyValues) {
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
