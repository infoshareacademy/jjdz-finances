package com.infoshareacademy.finances.service;

import com.infoshareacademy.finances.model.DailyValue;
import com.infoshareacademy.finances.model.Fund;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;

public class MonthlyExtremeFinderTest {

    private List<DailyValue> dailyValues;

    @Before
    public void initialize(){
        LocalDate date;
        BigDecimal closeValue;

        String fundCode = "AGI001";
        dailyValues = new ArrayList<DailyValue>();

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

        date = LocalDate.now().withMonth(2).withDayOfMonth(7);
        closeValue = new BigDecimal(50.25);
        dailyValues.add(new DailyValue(date , closeValue));
    }

    @Test
    public void testFindMin() {
        // given
        LocalDate date = LocalDate.now().withMonth(2);
        MonthlyExtremeFinder monthlyExtremeFinder = new MonthlyExtremeFinder(date,dailyValues);
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
        MonthlyExtremeFinder monthlyExtremeFinder = new MonthlyExtremeFinder(date,dailyValues);
        BigDecimal maxValue = new BigDecimal(50.25);

        //when
        DailyValue dailyValue = monthlyExtremeFinder.findMax();

        //then
        assertThat(dailyValue.getCloseValue(), Matchers.equalTo(maxValue));
    }

    @Test
    @Ignore
    public void testFindDuplicates(){
        //given
        List<DailyValue> expectedMinDailyValues  = new ArrayList<DailyValue>();
        LocalDate searchDate = LocalDate.now().withMonth(2);

        LocalDate date = LocalDate.now().withMonth(2).withDayOfMonth(7);
        BigDecimal closeValue = new BigDecimal(50.25);
        expectedMinDailyValues.add(new DailyValue(date , closeValue));
        date = LocalDate.now().withMonth(2).withDayOfMonth(4);
        closeValue = new BigDecimal(50.25);
        expectedMinDailyValues.add(new DailyValue(date , closeValue));

        MonthlyExtremeFinder monthlyExtremeFinder = new MonthlyExtremeFinder(searchDate,dailyValues);

        //when


    }
}