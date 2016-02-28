package com.infoshareacademy.finances.service;

import com.infoshareacademy.finances.model.DailyValue;
import com.infoshareacademy.finances.model.Fund;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class FundYearDataViewerTest {

    @Test
    public void testMinMaxValues() {
        List<DailyValue> dailyValues = Arrays.asList(
                new DailyValue("20091212", new BigDecimal("12.1")),
                new DailyValue("20091213", new BigDecimal("12.3")));

        FundYearDataViewer viewer = new FundYearDataViewer();
        HashMap<String, BigDecimal> map = viewer.yearExtremes(new Fund(dailyValues, "", ""), "2009");

        assertThat(map.get("Max"), is(equalTo(new BigDecimal("12.3"))));
        assertThat(map.get("Min"), is(equalTo(new BigDecimal("12.1"))));
    }


    @Test
    public void testShowYears() throws Exception {
//        FundDataLoader loader = new FundDataLoader();
//        List<DailyValue> dailyValues = loader.loadDataFromFile("Data/Unziped/AGI001.txt");

        List<DailyValue> dailyValues = Arrays.asList(
                new DailyValue("20091212", new BigDecimal("12.3")),
                new DailyValue("20091213", new BigDecimal("12.3")),
                new DailyValue("20101212", new BigDecimal("12.3")));

        FundYearDataViewer viewer = new FundYearDataViewer();
        Set<String> strings = viewer.showYears(new Fund(dailyValues, "", ""));

        System.out.println("strings = " + strings);

        assertThat(strings.size(), is(equalTo(2)));
        assertThat(strings, hasItems("2009", "2010"));
    }


}