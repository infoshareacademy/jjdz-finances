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

    @Ignore
    @Test
    public void testLoadFundFromFile() throws Exception {
        //given
        ClassLoader classLoader = getClass().getClassLoader();
        String fundFilePath = classLoader.getResource("AGI001.txt").getPath();
        DataLoader dataLoader = new DataLoader();
        LocalDate date = LocalDate.now().withYear(2009).withMonth(6).withDayOfMonth(25);
        BigDecimal value = new BigDecimal(1000.28);
        DailyValue expected = new DailyValue(date,value);

        //when
        List<DailyValue> dailyValues = dataLoader.loadDataFromFile(fundFilePath);

        //then
        assertThat(expected.getCloseValue() , Matchers.equalTo(dailyValues.get(2).getCloseValue()));

    }
}