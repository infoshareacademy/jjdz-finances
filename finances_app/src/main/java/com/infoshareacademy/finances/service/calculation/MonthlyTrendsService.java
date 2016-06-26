package com.infoshareacademy.finances.service.calculation;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.infoshareacademy.finances.entity.DailyValue;

@Stateless
public class MonthlyTrendsService {
	private static final Logger LOGGER = LoggerFactory.getLogger(MonthlyTrendsService.class);

	public List<DailyValue> calculateTrend(List<DailyValue> dailyValues) {

		dailyValues.forEach(d -> LOGGER.debug("|{}|", d.getCloseValue()));

		List<DailyValue> extremes = new ArrayList<>();
		extremes.add(dailyValues.get(0));
		int size = dailyValues.size();
		for (int i = 1; i < size; i++) {
			DailyValue previous = dailyValues.get(i - 1);
			DailyValue current = dailyValues.get(i);
			DailyValue extreme;
			DailyValue next = null;
			if (i + 1 < size) {
				next = dailyValues.get(i + 1);
			}

			if (previous.getCloseValue().compareTo(current.getCloseValue()) > 0) {
				extreme = current;
				if (next != null && extreme.getCloseValue().compareTo(next.getCloseValue()) < 0) {
					extremes.add(extreme);
				}
			}

		}
		extremes.add(dailyValues.get(size - 1));
		LOGGER.debug("Extrema:");
		extremes.forEach(d -> LOGGER.debug("|{}|", d.getCloseValue()));
		return extremes;
	}
}
