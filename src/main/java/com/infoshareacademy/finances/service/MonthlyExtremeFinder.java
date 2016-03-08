package com.infoshareacademy.finances.service;

import com.infoshareacademy.finances.model.DailyValue;
import com.infoshareacademy.finances.model.Fund;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class MonthlyExtremeFinder {
    LocalDate localDate;
    Fund fund;

    MonthlyExtremeFinder(LocalDate localDate, Fund fund){
        this.localDate = localDate;
        this.fund = fund;
    }

    public DailyValue findMin(){
        List<DailyValue>  dailyValues = fund.getDailyValues();
        Integer year = localDate.getYear();
        Month month = localDate.getMonth();
        DailyValue minDailyValue = null;
        DailyValue currentDailyValue;
        BigDecimal minCloseValue = null;
        BigDecimal currentCloseValue;
        boolean firstAssign = true;

        for (DailyValue dailyValue : dailyValues) {
            currentDailyValue = dailyValue;
            if (year.equals(currentDailyValue.getDate().getYear()) && month.equals(currentDailyValue.getDate().getMonth())) {
                currentCloseValue = currentDailyValue.getCloseValue();
                if (firstAssign) {
                    minCloseValue = currentCloseValue;
                    firstAssign = false;
                    continue;
                }
                if (currentCloseValue.compareTo(minCloseValue) < 0) {
                    minCloseValue = currentCloseValue;
                    minDailyValue = currentDailyValue;
                }
            }
        }
        return minDailyValue;
    }

    public DailyValue findMax(){
        List<DailyValue>  dailyValues = fund.getDailyValues();
        Integer year = localDate.getYear();
        Month month = localDate.getMonth();
        DailyValue maxDailyValue = null;
        DailyValue currentDailyValue;
        BigDecimal maxCloseValue = null;
        BigDecimal currentCloseValue;
        boolean firstAssign = true;

        for (DailyValue dailyValue : dailyValues) {
            currentDailyValue = dailyValue;
            if (year.equals(currentDailyValue.getDate().getYear()) && month.equals(currentDailyValue.getDate().getMonth())) {
                currentCloseValue = currentDailyValue.getCloseValue();
                if (firstAssign) {
                    maxCloseValue = currentCloseValue;
                    firstAssign = false;
                    continue;
                }
                if (currentCloseValue.compareTo(maxCloseValue) > 0) {
                    maxCloseValue = currentCloseValue;
                    maxDailyValue = currentDailyValue;
                }
            }
        }
        return maxDailyValue;
    }
}
