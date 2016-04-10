package com.infoshareacademy.finances.service;

import com.infoshareacademy.finances.model.Asset;
import com.infoshareacademy.finances.model.AvailableMonthsAndYear;
import com.infoshareacademy.finances.model.DailyValue;

import static org.junit.Assert.*;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MonthViewerTest {

    @Test
    public void testShowMonths() throws Exception {
        // given
        LocalDate date;
        BigDecimal closeValue;
        List<DailyValue> dailyValues = new ArrayList<DailyValue>();
        String fundCode = "AGI001";
        date = LocalDate.now().withMonth(2);
        closeValue = new BigDecimal(3.16);
        dailyValues.add(new DailyValue(date , closeValue));
        date = LocalDate.now().withMonth(3);
        closeValue = new BigDecimal(43.25);
        dailyValues.add(new DailyValue(date , closeValue));
        Asset asset = new Asset(dailyValues, fundCode, fundCode);
        PrintStream printStream = mock(PrintStream.class);
        MonthViewer monthViewer = new MonthViewer(printStream) ;

        // when
        monthViewer.showAvailableMonths(asset);

        // then
        verify(printStream).print("3  ");
        verify(printStream).print("2  ");
    }

    @Test
    public void testGetListOfAvailableMonthsAndYears() throws Exception {
        // given
        LocalDate date;
        BigDecimal closeValue;
        List<DailyValue> dailyValues = new ArrayList<DailyValue>();
        String fundCode = "AGI001";
        date = LocalDate.now().withMonth(2);
        closeValue = new BigDecimal(3.15);
        dailyValues.add(new DailyValue(date , closeValue));
        date = LocalDate.now().withMonth(3);
        closeValue = new BigDecimal(43.25);
        dailyValues.add(new DailyValue(date , closeValue));
        Asset asset = new Asset(dailyValues, fundCode, fundCode);
        PrintStream printStream = mock(PrintStream.class);
        MonthViewer monthViewer = new MonthViewer(printStream) ;
        ArrayList<AvailableMonthsAndYear> availableMonthsAndYears;
        AvailableMonthsAndYear availableMonthsAndYear;

        // when
        availableMonthsAndYears = monthViewer.getListOfAvailableMonthsAndYears(asset);
        availableMonthsAndYear = availableMonthsAndYears.get(0);

        // then
        assertThat(availableMonthsAndYears, Matchers.hasSize(1));
        assertThat(availableMonthsAndYear.getYear() , Matchers.equalTo(LocalDate.now().getYear()));
        assertThat(availableMonthsAndYear.getMonths(), Matchers.hasSize(2));
    }
}