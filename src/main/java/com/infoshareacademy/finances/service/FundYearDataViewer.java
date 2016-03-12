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


    public List<DailyValue> yearMaxValues (List<DailyValue> dailyValues, Integer giveYear) {
        List<BigDecimal> yearValues = new ArrayList<>();
        for (DailyValue x: dailyValues) if (x.getDate().getYear() == giveYear) yearValues.add(x.getCloseValue());

        List<DailyValue> output = new ArrayList<>();
        for (DailyValue x: dailyValues) if (Objects.equals(x.getCloseValue(), Collections.max(yearValues))) output.add(x);

        return output;
    }

    public List<DailyValue> yearMinValues (List<DailyValue> dailyValues, Integer giveYear) {
        List<BigDecimal> yearValues = new ArrayList<>();
        for (DailyValue x: dailyValues) if (x.getDate().getYear() == giveYear) yearValues.add(x.getCloseValue());

        List<DailyValue> output = new ArrayList<>();
        for (DailyValue x: dailyValues) if (Objects.equals(x.getCloseValue(), Collections.min(yearValues))) output.add(x);

        return output;
    }


    }


