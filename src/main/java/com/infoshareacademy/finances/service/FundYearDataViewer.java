package com.infoshareacademy.finances.service;

import com.infoshareacademy.finances.model.DailyValue;
import com.infoshareacademy.finances.model.Fund;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

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



    public List<DailyValue> yearMaxValues (List<DailyValue> dailyValues, int giveYear) {
        BigDecimal yearlyMax = getMaxCloseYearValue(dailyValues, giveYear);

        return dailyValues.stream()
                .filter(dailyValue -> dailyValue.getDate().getYear() == giveYear)
                .filter(dailyValue -> dailyValue.getCloseValue().compareTo(yearlyMax) == 0)
                .collect(Collectors.toList());
    }

    private BigDecimal getMaxCloseYearValue(List<DailyValue> dailyValues, int giveYear) {
        return dailyValues.stream()
                .filter(dailyValue -> dailyValue.getDate().getYear() == giveYear)
                .max((dailyValue1, dailyValue2) -> dailyValue1.getCloseValue().compareTo(dailyValue2.getCloseValue()))
                .get().getCloseValue();
    }

    public List<DailyValue> yearMinValues (List<DailyValue> dailyValues, int giveYear) {
        BigDecimal yearlyMin = getMinCloseYearValue(dailyValues, giveYear);

        return dailyValues.stream()
                .filter(dailyValue -> dailyValue.getDate().getYear() == giveYear)
                .filter(dailyValue -> dailyValue.getCloseValue().compareTo(yearlyMin) == 0)
                .collect(Collectors.toList());
    }

    private BigDecimal getMinCloseYearValue(List<DailyValue> dailyValues, int giveYear) {
        return dailyValues.stream()
                .filter(dailyValue -> dailyValue.getDate().getYear() == giveYear)
                .min((dailyValue1, dailyValue2) -> dailyValue1.getCloseValue().compareTo(dailyValue2.getCloseValue()))
                .get().getCloseValue();
    }

}


