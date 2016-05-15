package com.infoshareacademy.finances.service;

import com.infoshareacademy.finances.model.AvailableMonths;
import com.infoshareacademy.finances.model.DailyValue;

import static org.junit.Assert.*;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AvailableMonthsRetrieverTest {

    @Test
    public void testRetrieveAvailableMonthsAndYears() throws Exception {
        // given
        LocalDate date;
        BigDecimal closeValue;
        List<DailyValue> dailyValues = new ArrayList<DailyValue>();

        date = LocalDate.now().withMonth(2);
        closeValue = new BigDecimal(3.15);
        dailyValues.add(new DailyValue(date, closeValue));

        date = LocalDate.now().withMonth(3);
        closeValue = new BigDecimal(43.25);
        dailyValues.add(new DailyValue(date, closeValue));

        AvailableMonths availableMonths;

        // when
        ArrayList<AvailableMonths> currentAvailableMonths = new AvailableMonthsRetriever().retrieveAvailableMonths(dailyValues);
        availableMonths = currentAvailableMonths.get(0);

        // then
        assertThat(currentAvailableMonths, Matchers.hasSize(1));
        assertThat(availableMonths.getYear(), Matchers.equalTo(LocalDate.now().getYear()));
        assertThat(availableMonths.getMonths(), Matchers.hasSize(2));
    }
}