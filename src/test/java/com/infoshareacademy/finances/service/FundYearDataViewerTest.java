package com.infoshareacademy.finances.service;

import com.infoshareacademy.finances.model.DailyValue;
import com.infoshareacademy.finances.model.Fund;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class FundYearDataViewerTest {

    @Test
    public void testMinMaxValues() {

        List<DailyValue> dailyValues = Arrays.asList(
                new DailyValue(LocalDate.of(2009, 12, 12), new BigDecimal("12.1")),
                new DailyValue(LocalDate.of(2009, 12, 13), new BigDecimal("12.3")));

        FundYearDataViewer viewer = new FundYearDataViewer();
        HashMap<String, BigDecimal> map = viewer.yearExtremes(new Fund(dailyValues, "", ""), 2009);

        assertThat(map.get("Max"), is(equalTo(new BigDecimal("12.3"))));
        assertThat(map.get("Min"), is(equalTo(new BigDecimal("12.1"))));
    }


    @Test
    public void testShowYears() throws Exception {

        List<DailyValue> dailyValues = Arrays.asList(
                new DailyValue(LocalDate.of(2009, 12, 12), new BigDecimal("12.3")),
                new DailyValue(LocalDate.of(2009, 12, 13), new BigDecimal("12.3")),
                new DailyValue(LocalDate.of(2010, 12, 12), new BigDecimal("12.3")));

        FundYearDataViewer viewer = new FundYearDataViewer();
        Set<Integer> integers = viewer.showYears(new Fund(dailyValues, "", ""));

        System.out.println("Dates as integers = " + integers);

        assertThat(integers.size(), is(equalTo(2)));
        assertThat(integers, hasItems(2009, 2010));
    }

}