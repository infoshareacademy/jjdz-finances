package com.infoshareacademy.finances.service;

import com.infoshareacademy.finances.model.DailyValue;
import com.infoshareacademy.finances.model.Fund;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThat;

public class MonthlyExtremeFinderTest {

    private Fund fund;

    @Before
    public void initialize(){
        LocalDate date;
        BigDecimal closeValue;
        List<DailyValue> dailyValues = new ArrayList<DailyValue>();
        String fundCode = "AGI001";

        date = LocalDate.now().withMonth(3).withDayOfMonth(1);
        closeValue = new BigDecimal(43.25);
        dailyValues.add(new DailyValue(date , closeValue));

        date = LocalDate.now().withMonth(3).withDayOfMonth(2);
        closeValue = new BigDecimal(22.25);
        dailyValues.add(new DailyValue(date , closeValue));

        date = LocalDate.now().withMonth(3).withDayOfMonth(3);
        closeValue = new BigDecimal(1.25);
        dailyValues.add(new DailyValue(date , closeValue));

        date = LocalDate.now().withMonth(2).withDayOfMonth(3);
        closeValue = new BigDecimal(12.45);
        dailyValues.add(new DailyValue(date , closeValue));

        date = LocalDate.now().withMonth(2).withDayOfMonth(2);
        closeValue = new BigDecimal(48.35);
        dailyValues.add(new DailyValue(date , closeValue));

        date = LocalDate.now().withMonth(2).withDayOfMonth(5);
        closeValue = new BigDecimal(3.16);
        dailyValues.add(new DailyValue(date , closeValue));

        date = LocalDate.now().withMonth(2).withDayOfMonth(4);
        closeValue = new BigDecimal(50.25);
        dailyValues.add(new DailyValue(date , closeValue));

        fund = new Fund(dailyValues, fundCode, fundCode);
    }

    @Test
    public void testFindMin() {
        // given
        LocalDate date = LocalDate.now().withMonth(2);
        MonthlyExtremeFinder monthlyExtremeFinder = new MonthlyExtremeFinder(date,fund);
        BigDecimal minValue = new BigDecimal(3.16);

        //when
        DailyValue dailyValue = monthlyExtremeFinder.findMin();

        //then
        assertThat(dailyValue.getCloseValue(), Matchers.equalTo(minValue));
    }

    @Test
    public void testFindMax() {
        // given
        LocalDate date = LocalDate.now().withMonth(2);
        MonthlyExtremeFinder monthlyExtremeFinder = new MonthlyExtremeFinder(date,fund);
        BigDecimal maxValue = new BigDecimal(50.25);

        //when
        DailyValue dailyValue = monthlyExtremeFinder.findMax();

        //then
        assertThat(dailyValue.getCloseValue(), Matchers.equalTo(maxValue));
    }
}