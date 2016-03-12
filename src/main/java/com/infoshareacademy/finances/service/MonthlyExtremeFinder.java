package com.infoshareacademy.finances.service;

import com.infoshareacademy.finances.model.DailyValue;
import com.infoshareacademy.finances.model.Fund;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class MonthlyExtremeFinder {
    LocalDate localDate;
    List<DailyValue> dailyValues;
    final static Comparator<DailyValue> DAILY_VALUE_COMPARATOR = (a,b) -> a.getCloseValue().compareTo(b.getCloseValue());

    MonthlyExtremeFinder(LocalDate localDate, List<DailyValue> dailyValues){
        this.localDate = localDate;
        this.dailyValues= dailyValues;
    }

    public enum Order {
        MIN,
        MAX;
    }

    public DailyValue findMin(){
        return findExtreme(Order.MIN);
    }

    public DailyValue findMax(){
        return findExtreme(Order.MAX);
    }

    public DailyValue findExtreme(Order order) {


        Integer year = localDate.getYear();
        Month month = localDate.getMonth();
        DailyValue maxDailyValue = null;
        DailyValue currentDailyValue;
        BigDecimal maxCloseValue = null;
        BigDecimal currentCloseValue;
        boolean firstAssign = true;
        int sign = order == Order.MAX ? 1 : -1;

        Predicate<DailyValue> yearPredicate = dv -> year.equals(dv.getDate().getYear());
        Predicate<DailyValue> monthPredicate = dv -> month.equals(dv.getDate().getMonth());


        for (DailyValue dailyValue : dailyValues) {
            currentDailyValue = dailyValue;
            if (yearPredicate.test(currentDailyValue) && monthPredicate.test(currentDailyValue)) {
                currentCloseValue = currentDailyValue.getCloseValue();
                if (firstAssign) {
                    maxCloseValue = currentCloseValue;
                    firstAssign = false;
                    continue;
                }
                if (maxDailyValue == null || sign * DAILY_VALUE_COMPARATOR.compare(currentDailyValue, maxDailyValue) > 0)  {
                    maxCloseValue = currentCloseValue;
                    maxDailyValue = currentDailyValue;
                }
            }
        }
        return maxDailyValue;
    }

//    public List<DailyValue> findMinDailyValues(){
//
//    };


}
