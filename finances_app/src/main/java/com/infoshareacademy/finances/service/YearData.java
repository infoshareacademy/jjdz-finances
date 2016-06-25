package com.infoshareacademy.finances.service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.ejb.Stateless;

import com.infoshareacademy.finances.model.DailyValue;

@Stateless
public class YearData {

	public Set<Integer> returnAllYears(List<DailyValue> dailyValues) {
		Set<Integer> years = new HashSet<>();

		for (DailyValue x : dailyValues) {
			Integer y = x.getDate().getYear();
			if (!years.contains(y))
				years.add(y);
		}
		return years;
	}

	public List<DailyValue> yearMaxValues(List<DailyValue> dailyValues, Integer giveYear) {
		List<BigDecimal> yearValues = dailyValues.stream()
				.filter(x -> x.getDate().getYear() == giveYear)
				.map(DailyValue::getCloseValue).collect(Collectors.toList());

		return dailyValues.stream()
				.filter(x -> Objects.equals(x.getCloseValue(), Collections.max(yearValues)))
				.collect(Collectors.toList());
	}

	public List<DailyValue> yearMinValues(List<DailyValue> dailyValues, Integer giveYear) {
		List<BigDecimal> yearValues = dailyValues.stream()
				.filter(x -> x.getDate().getYear() == giveYear)
				.map(DailyValue::getCloseValue).collect(Collectors.toList());

		return dailyValues.stream()
				.filter(x -> Objects.equals(x.getCloseValue(), Collections.min(yearValues)))
				.collect(Collectors.toList());
	}

}


