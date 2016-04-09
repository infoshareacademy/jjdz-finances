package com.infoshareacademy.finances.service;

import com.infoshareacademy.finances.model.Asset;
import com.infoshareacademy.finances.model.DailyValue;

import java.math.BigDecimal;
import java.util.*;

public class YearDataViewer {

    public Set<Integer> showYears(Asset asset) {
        List<DailyValue> dailyData = asset.getDailyValues();
        Set<Integer> years = new HashSet<Integer>();

        for (DailyValue x: dailyData) {
            Integer y = x.getDate().getYear();
            if (!years.contains(y)) years.add(y);
        }
        return years;
    }

    public List<DailyValue> yearMaxValues (List<DailyValue> dailyValues, Integer giveYear) {
        List<BigDecimal> yearValues = new ArrayList<BigDecimal>();
        for (DailyValue x: dailyValues) if (x.getDate().getYear() == giveYear) yearValues.add(x.getCloseValue());

        List<DailyValue> output = new ArrayList<DailyValue>();
        for (DailyValue x: dailyValues) if (Objects.equals(x.getCloseValue(), Collections.max(yearValues))) output.add(x);

        return output;
    }

    public List<DailyValue> yearMinValues (List<DailyValue> dailyValues, Integer giveYear) {
        List<BigDecimal> yearValues = new ArrayList<BigDecimal>();
        for (DailyValue x: dailyValues) if (x.getDate().getYear() == giveYear) yearValues.add(x.getCloseValue());

        List<DailyValue> output = new ArrayList<DailyValue>();
        for (DailyValue x: dailyValues) if (Objects.equals(x.getCloseValue(), Collections.min(yearValues))) output.add(x);

        return output;
    }


    }


