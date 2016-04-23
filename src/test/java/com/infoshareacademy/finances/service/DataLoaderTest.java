package com.infoshareacademy.finances.service;

import com.infoshareacademy.finances.model.DailyValue;
import org.hamcrest.Matchers;
import org.junit.Ignore;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

public class DataLoaderTest {

    @Test
    public void testLoadFundFromFile() throws Exception {
        //given
        ClassLoader classLoader = getClass().getClassLoader();
        String fundFilePath = classLoader.getResource("AGI001.txt").getPath();
        fundFilePath = fundFilePath.replaceFirst("^/(.:/)", "$1");
        DataLoader dataLoader = new DataLoader();
        LocalDate date = LocalDate.now().withYear(2009).withMonth(6).withDayOfMonth(25);
        BigDecimal value = new BigDecimal("1000.28");
        DailyValue expected = new DailyValue(date,value);
        
        //when
        List<DailyValue> dailyValues = dataLoader.loadDataFromFile(fundFilePath);

        //then
        assertThat(dailyValues.get(1).getDate(), Matchers.equalTo(expected.getDate()));
        assertThat(dailyValues.get(1).getCloseValue(), Matchers.equalTo(expected.getCloseValue()));
    }

    @Test
    public void testLoadCurrencyFromFile() throws Exception {
        //given
        ClassLoader classLoader = getClass().getClassLoader();
        String currencyFilePath = classLoader.getResource("EUR.txt").getPath();
        currencyFilePath = currencyFilePath.replaceFirst("^/(.:/)", "$1");
        DataLoader dataLoader = new DataLoader();
        LocalDate date = LocalDate.now().withYear(1999).withMonth(1).withDayOfMonth(4);
        BigDecimal value = new BigDecimal("4.0670");
        DailyValue expected = new DailyValue(date,value);

        //when
        List<DailyValue> dailyValues = dataLoader.loadDataFromFile(currencyFilePath);

        //then
        assertThat(expected.getDate() , Matchers.equalTo(dailyValues.get(1).getDate()));
        assertThat(dailyValues.get(1).getCloseValue(), Matchers.equalTo(expected.getCloseValue()));
    }
}