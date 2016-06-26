package com.infoshareacademy.finances.service;

import com.infoshareacademy.finances.entity.DailyValue;
import com.infoshareacademy.finances.service.fileOperations.DailyValuesLoader;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

public class DailyValuesLoaderTest {

    @Test
    public void testLoadFundFromFile() throws Exception {
        //given
        String fileName = "AGI001.txt";
        LocalDate date = LocalDate.now().withYear(2009).withMonth(6).withDayOfMonth(25);
        BigDecimal value = new BigDecimal("1000.28");
        DailyValue expected = new DailyValue(date,value);
        
        //when
        List<DailyValue> dailyValues = new DailyValuesLoader().loadDataFromFile(fileName);

        //then
        assertThat(dailyValues.get(1).getDate(), Matchers.equalTo(expected.getDate()));
        assertThat(dailyValues.get(1).getCloseValue(), Matchers.equalTo(expected.getCloseValue()));
    }

    @Test
    public void testLoadCurrencyFromFile() throws Exception {
        //given
        String fileName = "EUR.txt";
        LocalDate date = LocalDate.now().withYear(1999).withMonth(1).withDayOfMonth(4);
        BigDecimal value = new BigDecimal("4.0670");
        DailyValue expected = new DailyValue(date,value);

        //when
        List<DailyValue> dailyValues = new DailyValuesLoader().loadDataFromFile(fileName);

        //then
        assertThat(expected.getDate() , Matchers.equalTo(dailyValues.get(1).getDate()));
        assertThat(dailyValues.get(1).getCloseValue(), Matchers.equalTo(expected.getCloseValue()));
    }
}