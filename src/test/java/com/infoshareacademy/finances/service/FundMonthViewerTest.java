package com.infoshareacademy.finances.service;

import com.infoshareacademy.finances.model.DailyValue;
import com.infoshareacademy.finances.model.Fund;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class FundMonthViewerTest {

    @Test
    public void testShowMonths() throws Exception {
        // given
        ZonedDateTime date;
        BigDecimal closeValue;
        List<DailyValue> dailyValues = new ArrayList<DailyValue>();
        String fundCode = "AGI001";
        date = ZonedDateTime.now().withMonth(2);
        closeValue = new BigDecimal(3.15);
        dailyValues.add(new DailyValue(date , closeValue));
        date = ZonedDateTime.now().withMonth(3);
        closeValue = new BigDecimal(43.25);
        dailyValues.add(new DailyValue(date , closeValue));
        Fund fund = new Fund(dailyValues, fundCode, fundCode);
        PrintStream printStream = mock(PrintStream.class);
        FundMonthViewer fundMonthViewer = new FundMonthViewer(printStream) ;

        // when
        fundMonthViewer.showMonths(fund);

        // then
        verify(printStream).print("03  ");
        verify(printStream).print("02  ");
    }
}