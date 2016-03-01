package com.infoshareacademy.finances.service;

import com.infoshareacademy.finances.model.AvailableMonthsAndYear;
import com.infoshareacademy.finances.model.DailyValue;
import com.infoshareacademy.finances.model.Fund;

import java.io.PrintStream;
import java.time.Month;
import java.util.*;

public class FundMonthViewer {

    private final PrintStream out;

    public FundMonthViewer(PrintStream out) {
        this.out = out;
    }

    public void showAvailableMonths(Fund fund) {
        List<DailyValue> dailyValues = fund.getDailyValues();
        //List<AvailableMonthsAndYear> yearsMonths;

//        int size = dailyValues.size();
//        for (int i = 0; i < size; i++) {
//             dailyValues.get(i).getDate().getYear();
//        }
//    }

//        yearsMonths = parseYearsAndMonthsToObjectList(getYearMonthsStringsFromDailyValues(dailyValues));
//
//        int size = yearsMonths.size();
//        for (int i = 0; i < size; i++) {
//            out.print(yearsMonths.get(i).getYear() + "  ");
//            int sizeJ = yearsMonths.get(i).getMonths().size();
//            for (int j = 0; j < sizeJ; j++) {
//                String month = yearsMonths.get(i).getMonths().get(j);
//                int monthInt = Integer.parseInt(month);
//                if (j == 0){
//                    int k = j + 1;
//                    while (monthInt != k){
//                        k++;
//                        out.print("    ");
//                    }
//                }
//                out.print(month + "  ");
//            }
//            out.println();
//        }
    }

    public ArrayList<AvailableMonthsAndYear> getListOfAvailableMonthsAndYears(Fund fund) {
        AvailableMonthsAndYear availableMonthsAndYear;
        List<DailyValue> dailyValues = fund.getDailyValues();
        ArrayList<AvailableMonthsAndYear> availableMonthsAndYears = new ArrayList<AvailableMonthsAndYear>();
        int size = dailyValues.size();
        int i = 0;
        while (i < size) {
            Integer year = dailyValues.get(i).getDate().getYear();
            List<Month> months = new ArrayList<Month>();
            while (year.equals(dailyValues.get(i).getDate().getYear())) {
                months.add(dailyValues.get(i).getDate().getMonth());
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

//    private List<String> getYearMonthsStringsFromDailyValues(List<DailyValue> dailyValues) {
//        List<String> months = new ArrayList<String>();
//        int size = dailyValues.size();
//        for (int i = 0; i < size; i++) {
//            String yearMonth;
//            yearMonth = dailyValues.get(i).getDate();
//            if (!months.contains(yearMonth)) {
//                months.add(yearMonth);
//            }
//        }
//        return months;
//    }
}
