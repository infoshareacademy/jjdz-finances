package com.infoshareacademy.finances.service;

import com.infoshareacademy.finances.model.DailyValue;
import com.infoshareacademy.finances.model.Fund;
import com.infoshareacademy.finances.model.YearMonth;

import java.math.BigDecimal;
import java.util.*;

public class FundYearDataViewer {

    public Set<String> showYears(Fund fund) {
        List<DailyValue> dailyData = fund.getDailyValues();
        Set<String> years = new HashSet<String>();

        for (DailyValue x: dailyData) {
            String y = x.getDate().substring(0, 4);
            if (!years.contains(y)) years.add(y);
        }
        return years;
    }

    public HashMap<String, BigDecimal> yearExtremes(Fund fund, String giveYear) {
        List<DailyValue> dailyData = fund.getDailyValues();
//        String year = giveYear;
        List<BigDecimal> yearValues = new ArrayList<BigDecimal>();
//        List<BigDecimal> minMax = new ArrayList<BigDecimal>();
        HashMap<String, BigDecimal> minMax = new HashMap<String, BigDecimal>();


        for (DailyValue x: dailyData) {
            if (x.getDate().substring(0, 4).equals(giveYear)) yearValues.add(x.getCloseValue());

            }

        System.out.println("yearValues = " + yearValues);

        minMax.put("Max", Collections.max(yearValues));
        minMax.put("Min", Collections.min(yearValues));

//        minMax.add(Collections.max(yearValues));
//        minMax.add(Collections.min(yearValues));

        return minMax;
        }
    }


