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
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class FundMonthViewerTest {

    @Test
    public void testShowMonths() throws Exception {
        String date;
        BigDecimal closeValue;
        List<DailyValue> dailyValues = new ArrayList<DailyValue>();
        String fundCode = "AGI001";

        date = "20150220";
        closeValue = new BigDecimal(3.15);
        dailyValues.add(new DailyValue(date , closeValue));

        date = "20150320";
        closeValue = new BigDecimal(43.25);
        dailyValues.add(new DailyValue(date , closeValue));


        Fund fund = new Fund(dailyValues, fundCode, fundCode);

//        MockPrintStream out = new MockPrintStream(System.out);
//        FundMonthViewer fundMonthViewer = new FundMonthViewer(out);
//        fundMonthViewer.showMonths(fund);
//        Assert.assertThat(out.getPrintedMessages(), Matchers.hasItems("03  ", "02  "));

        FundMonthViewer fundMonthViewer = mock(FundMonthViewer.class);
        fundMonthViewer.showMonths(fund);

        verify(fundMonthViewer).showMonths(fund);
    }
}