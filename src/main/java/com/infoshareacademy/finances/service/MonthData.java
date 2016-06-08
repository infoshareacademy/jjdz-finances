package com.infoshareacademy.finances.service;

import com.infoshareacademy.finances.model.DailyValue;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MonthData {

    public List<Integer> returnAllMonths(List<DailyValue> dailyValues, int year) {
		List<Integer> months = new ArrayList();
		dailyValues.stream()
				.filter(d -> d.getDate().getYear() == year)
				.forEach(d -> months.add(d.getDate().getMonth().getValue()));

		return months.stream().distinct().sorted((a,b) -> a.compareTo(b))
				.collect(Collectors.toList());
    }
}
