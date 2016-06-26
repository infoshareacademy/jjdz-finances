package com.infoshareacademy.finances.service;

import com.infoshareacademy.finances.entity.DailyValue;
import com.infoshareacademy.finances.service.calculation.MonthlyExtremeFinder;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.infoshareacademy.finances.service.calculation.MonthlyExtremeFinder.Order;
import static org.hamcrest.Matchers.isIn;
import static org.junit.Assert.assertThat;

public class MonthlyExtremeFinderTest {

    private List<DailyValue> dailyValues;

    @Before
    public void initialize(){
        LocalDate date;
        BigDecimal closeValue;
        dailyValues = new ArrayList<>();

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

        date = LocalDate.now().withMonth(2).withDayOfMonth(10);
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
        DailyValue dailyValue = monthlyExtremeFinder.findExtreme(Order.MIN);

        //then
        assertThat(dailyValue.getCloseValue(), Matchers.equalTo(minValue));
    }

    @Test
    public void testFindExtremeMax() {
        // given
        LocalDate date = LocalDate.now().withMonth(2);
        MonthlyExtremeFinder monthlyExtremeFinder = new MonthlyExtremeFinder(date,dailyValues);
        BigDecimal maxValue = new BigDecimal(50.25);

        //when
        DailyValue dailyValue = monthlyExtremeFinder.findExtreme(Order.MAX);

        //then
        assertThat(dailyValue.getCloseValue(), Matchers.equalTo(maxValue));
    }

    @Test
    public void testFindMaxDailyValues(){
        //given
        List<DailyValue> expectedMaxDailyValues  = new ArrayList<>();
        LocalDate searchDate = LocalDate.now().withMonth(2);

        LocalDate date = LocalDate.now().withMonth(2).withDayOfMonth(7);
        BigDecimal closeValue = new BigDecimal(50.25);
        expectedMaxDailyValues.add(new DailyValue(date , closeValue));
        date = LocalDate.now().withMonth(2).withDayOfMonth(4);
        closeValue = new BigDecimal(50.25);
        expectedMaxDailyValues.add(new DailyValue(date , closeValue));
        MonthlyExtremeFinder monthlyExtremeFinder = new MonthlyExtremeFinder(searchDate,dailyValues);

        //when
        List<DailyValue> actualMaxDailyValues = monthlyExtremeFinder.findMaxDailyValues();
        //then
        assertThat(expectedMaxDailyValues.get(0), isIn(actualMaxDailyValues));
        assertThat(expectedMaxDailyValues.get(1), isIn(actualMaxDailyValues));
    }

    @Test
    public void testFindMinDailyValues(){
        //given
        List<DailyValue> expectedMinDailyValues  = new ArrayList<>();
        LocalDate searchDate = LocalDate.now().withMonth(2);

        LocalDate date = LocalDate.now().withMonth(2).withDayOfMonth(5);
        BigDecimal closeValue = new BigDecimal(3.16);
        expectedMinDailyValues.add(new DailyValue(date , closeValue));
        date = LocalDate.now().withMonth(2).withDayOfMonth(10);
        closeValue = new BigDecimal(3.16);
        expectedMinDailyValues.add(new DailyValue(date , closeValue));
        MonthlyExtremeFinder monthlyExtremeFinder = new MonthlyExtremeFinder(searchDate,dailyValues);

        //when
        List<DailyValue> actualMinDailyValues = monthlyExtremeFinder.findMinDailyValues();
        //then
        assertThat(expectedMinDailyValues.get(0), isIn(actualMinDailyValues));
        assertThat(expectedMinDailyValues.get(1), isIn(actualMinDailyValues));
    }
}