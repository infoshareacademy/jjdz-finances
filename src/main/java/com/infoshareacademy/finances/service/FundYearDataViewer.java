package com.infoshareacademy.finances.service;

import com.infoshareacademy.finances.model.DailyValue;
import com.infoshareacademy.finances.model.Fund;
import com.infoshareacademy.finances.model.YearMonth;

import java.math.BigDecimal;
import java.util.*;

public class FundYearDataViewer {


    public static Set<String> showYears(Fund fund) {
        List<DailyValue> dailyData = fund.getDailyValues();
        Set<String> years = new HashSet<String>();

        for (DailyValue x: dailyData) {
            String y = x.getDate().substring(0, 3);
            if (!years.contains(y)) years.add(y);
        }
        return years;
    }

    public static List<BigDecimal> yearExtremes(Fund fund, String giveYear) {
        List<DailyValue> dailyData = fund.getDailyValues();
        String year = giveYear;
        List<BigDecimal> yearValues = new ArrayList<BigDecimal>();
        List<BigDecimal> minMax = new ArrayList<BigDecimal>();


        for (DailyValue x: dailyData) {
            if (x.getDate().substring(0, 3) == year) yearValues.add(x.getCloseValue());

            }
        minMax.add(Collections.max(yearValues));
        minMax.add(Collections.min(yearValues));

        return minMax;
        }
    }


