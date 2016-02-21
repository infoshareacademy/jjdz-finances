package com.infoshareacademy.finances.service;

import com.infoshareacademy.finances.model.DailyValue;
import com.infoshareacademy.finances.model.Fund;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class FundMonthViewer {
    public static void showMonths(Fund fund){
        List<DailyValue> dailyValues = fund.getDailyValue();
        dailyValues.get(0);

    }
}
