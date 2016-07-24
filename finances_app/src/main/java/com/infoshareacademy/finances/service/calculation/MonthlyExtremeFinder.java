package com.infoshareacademy.finances.service.calculation;

import com.infoshareacademy.finances.entity.DailyValue;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

public class MonthlyExtremeFinder {
    private Integer year;
    private Month month;
    private List<DailyValue> dailyValues;
	private static final  Comparator<DailyValue> DAILY_VALUE_COMPARATOR = (a,b) -> a.getCloseValue().compareTo(b
			.getCloseValue());

    public MonthlyExtremeFinder(LocalDate localDate, List<DailyValue> dailyValues){
        year = localDate.getYear();
        month = localDate.getMonth();
        this.dailyValues= dailyValues;
    }

    public enum Order {
        MIN,
        MAX
    }

    public DailyValue findExtreme(Order order) {
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

    public List<DailyValue> findMaxDailyValues(){
        return findDuplicates(findExtreme(Order.MAX));
    }

    public List<DailyValue> findMinDailyValues(){
        return findDuplicates(findExtreme(Order.MIN));
    }

    public List<DailyValue> findDuplicates(DailyValue dailyValue){
        Predicate<DailyValue> yearPredicate = dv -> year.equals(dv.getDate().getYear());
        Predicate<DailyValue> monthPredicate = dv -> month.equals(dv.getDate().getMonth());

        return dailyValues.stream()
                .filter(yearPredicate.and(monthPredicate))
                .filter(dv -> dv.getCloseValue().equals(dailyValue.getCloseValue()))
                .collect(toList());
    }

}
