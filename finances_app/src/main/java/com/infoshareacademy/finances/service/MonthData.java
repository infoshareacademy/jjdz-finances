package com.infoshareacademy.finances.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;

import com.infoshareacademy.finances.model.DailyValue;

@Stateless
public class MonthData {

	public List<Integer> returnAllMonths(List<DailyValue> dailyValues, int year) {
		List<Integer> months = new ArrayList();
		dailyValues.stream()
				.filter(d -> d.getDate().getYear() == year)
				.forEach(d -> months.add(d.getDate().getMonth().getValue()));

		return months.stream()
				.distinct()
				.sorted((a, b) -> a.compareTo(b))
				.collect(Collectors.toList());
	}
}
