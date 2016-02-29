package com.infoshareacademy.finances.service;

import com.infoshareacademy.finances.model.DailyValue;
import com.infoshareacademy.finances.model.Fund;
import org.junit.Ignore;
import org.junit.Test;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class FundMonthViewerTest {

    @Ignore
    @Test
    public void testShowMonths() throws Exception {
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
        Fund fund = new Fund(dailyValues, fundCode, fundCode);
        PrintStream printStream = mock(PrintStream.class);
        FundMonthViewer fundMonthViewer = new FundMonthViewer(printStream) ;

        // when
        fundMonthViewer.showMonths(fund);

        // then
        verify(printStream).print("03  ");
        verify(printStream).print("02  ");
    }

    @Test
    public void testPrintType() {
        // given
        FundDataLoader fundDataLoader = new FundDataLoader();
        List<DailyValue> dailyValues = fundDataLoader.loadDataFromFile("D:\\IdeaProjects\\jjdz-finances\\Data\\AGI001.txt");
        String fundCode = "AGI001";
        Fund fund = new Fund(dailyValues, fundCode, fundCode);

        //when
        FundMonthViewer fundMonthViewer = new FundMonthViewer(System.out);
        fundMonthViewer.showMonths(fund);

        //then
    }
}