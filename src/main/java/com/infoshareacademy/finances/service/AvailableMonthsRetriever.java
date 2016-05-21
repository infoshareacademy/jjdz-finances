package com.infoshareacademy.finances.service;

import com.infoshareacademy.finances.model.AvailableMonths;
import com.infoshareacademy.finances.model.DailyValue;

import java.time.Month;
import java.util.*;

public class AvailableMonthsRetriever {

    public ArrayList<AvailableMonths> retrieveAvailableMonths(List<DailyValue> dailyValues) {
        AvailableMonths availableMonths;
        ArrayList<AvailableMonths> availableMonthses = new ArrayList<AvailableMonths>();
        int size = dailyValues.size();
        int i = 0;
        while (i < size) {
            Integer year = dailyValues.get(i).getDate().getYear();
            List<Month> months = new ArrayList<Month>();
            while (year.equals(dailyValues.get(i).getDate().getYear())) {
                Month nextMonth = dailyValues.get(i).getDate().getMonth();
                if (!months.contains(nextMonth)) {
                    months.add(nextMonth);
                }
                i++;
                if (i == size) {
                    break;
                }
            }
            availableMonths = new AvailableMonths(year, months);
            availableMonthses.add(availableMonths);
        }
        return availableMonthses;
    }
}
