package com.infoshareacademy.finances.service;

import com.infoshareacademy.finances.entity.DailyValue;
import com.infoshareacademy.finances.service.calculation.YearCalculation;

import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class YearCalculationTest {

    @Test
    public void testMaxValues() {

        List<DailyValue> dailyValues = Arrays.asList(
                new DailyValue(LocalDate.of(2009, 12, 12), new BigDecimal("12.1")),
                new DailyValue(LocalDate.of(2009, 12, 13), new BigDecimal("12.3")));

        YearCalculation viewer = new YearCalculation();

        List<DailyValue> out = viewer.yearMaxValues(dailyValues, 2009);

        assertThat(out.get(0), equalTo(new DailyValue(LocalDate.of(2009, 12, 13), new BigDecimal("12.3"))));
    }

    @Test
    public void testMinValues() {

        List<DailyValue> dailyValues = Arrays.asList(
                new DailyValue(LocalDate.of(2009, 12, 12), new BigDecimal("12.1")),
                new DailyValue(LocalDate.of(2009, 12, 13), new BigDecimal("12.3")));

        YearCalculation viewer = new YearCalculation();

        List<DailyValue> out = viewer.yearMinValues(dailyValues, 2009);

        assertThat(out.get(0), equalTo(new DailyValue(LocalDate.of(2009, 12, 12), new BigDecimal("12.1"))));
    }


    @Test
    public void testShowYears() throws Exception {

        List<DailyValue> dailyValues = Arrays.asList(
                new DailyValue(LocalDate.of(2009, 12, 12), new BigDecimal("12.3")),
                new DailyValue(LocalDate.of(2009, 12, 13), new BigDecimal("12.3")),
                new DailyValue(LocalDate.of(2010, 12, 12), new BigDecimal("12.3")));

        YearCalculation viewer = new YearCalculation();
        Set<Integer> integers = viewer.returnAllYears(dailyValues);

        System.out.println("Dates as integers = " + integers);

        assertThat(integers.size(), is(equalTo(2)));
        assertThat(integers, hasItems(2009, 2010));
    }

}