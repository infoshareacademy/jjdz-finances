package com.infoshareacademy.finances.service;

import com.infoshareacademy.finances.model.DailyValue;

import java.util.*;

public class MonthData {

    public Set<String> returnAllMonths(List<DailyValue> dailyValues, int year) {
        Set<String> months = new HashSet<>();

		dailyValues.forEach( d ->{
			if (d.getDate().getYear() == year){
				months.add(d.getDate().getMonth().toString());
			}
		});
        return months;
    }
}
