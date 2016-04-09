package com.infoshareacademy.finances.service;

import com.infoshareacademy.finances.model.Asset;
import com.infoshareacademy.finances.model.AvailableMonthsAndYear;
import com.infoshareacademy.finances.model.DailyValue;

import java.io.PrintStream;
import java.time.Month;
import java.util.*;

public class MonthViewer {

    private final PrintStream out;

    public MonthViewer(PrintStream out) {
        this.out = out;
    }

    public void showAvailableMonths(Asset asset) {
        List<AvailableMonthsAndYear> availableMonthsAndYears;

        availableMonthsAndYears = getListOfAvailableMonthsAndYears(asset);

        for (AvailableMonthsAndYear availableMonthsAndYear : availableMonthsAndYears) {
            out.print(availableMonthsAndYear.getYear() + "  ");
            int sizeJ = availableMonthsAndYear.getMonths().size();
            for (int j = 0; j < sizeJ; j++) {
                Month month = availableMonthsAndYear.getMonths().get(j);
                int monthInt = month.getValue();
                if (j == 0) {
                    int k = j + 1;
                    while (monthInt != k) {
                        k++;
                        out.print("   ");
                    }
                }
                out.print(month.getValue() + "  ");
            }
            out.println();
        }
    }

    public ArrayList<AvailableMonthsAndYear> getListOfAvailableMonthsAndYears(Asset asset) {
        AvailableMonthsAndYear availableMonthsAndYear;
        List<DailyValue> dailyValues = asset.getDailyValues();
        ArrayList<AvailableMonthsAndYear> availableMonthsAndYears = new ArrayList<AvailableMonthsAndYear>();
        int size = dailyValues.size();
        int i = 0;
        while (i < size) {
            Integer year = dailyValues.get(i).getDate().getYear();
            List<Month> months = new ArrayList<Month>();
            while (year.equals(dailyValues.get(i).getDate().getYear())) {
                Month nextMonth = dailyValues.get(i).getDate().getMonth();
                if (!months.contains(nextMonth)){
                    months.add(nextMonth);
                }
                i++;
                if (i == size) {
                    break;
                }
            }
            availableMonthsAndYear = new AvailableMonthsAndYear(year, months);
            availableMonthsAndYears.add(availableMonthsAndYear);
        }
        return availableMonthsAndYears;
    }
}
