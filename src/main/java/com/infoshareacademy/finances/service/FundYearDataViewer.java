package com.infoshareacademy.finances.service;

import com.infoshareacademy.finances.model.DailyValue;
import com.infoshareacademy.finances.model.Fund;

import java.math.BigDecimal;
import java.util.*;

public class FundYearDataViewer {

    public Set<Integer> showYears(Fund fund) {
        List<DailyValue> dailyData = fund.getDailyValues();
        Set<Integer> years = new HashSet<Integer>();

        for (DailyValue x: dailyData) {
            Integer y = x.getDate().getYear();
            if (!years.contains(y)) years.add(y);
        }
        return years;
    }

    public HashMap<String, BigDecimal> yearExtremes(Fund fund, Integer giveYear) {
        List<DailyValue> dailyData = fund.getDailyValues();
        List<BigDecimal> yearValues = new ArrayList<BigDecimal>();
        HashMap<String, BigDecimal> minMax = new HashMap<String, BigDecimal>();

        for (DailyValue x: dailyData) {
            if (x.getDate().getYear() == giveYear) yearValues.add(x.getCloseValue());
            }

        System.out.println("Year values = " + yearValues);

        minMax.put("Max", Collections.max(yearValues));
        minMax.put("Min", Collections.min(yearValues));

        return minMax;
        }
    }


