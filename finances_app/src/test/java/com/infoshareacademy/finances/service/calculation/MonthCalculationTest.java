package com.infoshareacademy.finances.service.calculation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Year;
import java.util.Arrays;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import com.infoshareacademy.finances.entity.DailyValue;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

public class MonthCalculationTest {

	@Test
	public void testReturnAllMonths_return_proper_values() throws Exception {
		//given
		List<DailyValue> dailyValues = Arrays.asList(
				new DailyValue(LocalDate.of(2009, 02, 11), new BigDecimal("13.3")),
				new DailyValue(LocalDate.of(2009, 01, 12), new BigDecimal("34.5")),
				new DailyValue(LocalDate.of(2009, 01, 13), new BigDecimal("11.3")),
				new DailyValue(LocalDate.of(2009, 02, 14), new BigDecimal("15.8")),
				new DailyValue(LocalDate.of(2010, 01, 15), new BigDecimal("12.1")));
		int year = 2009;

		//when
		List<Integer> actual = new MonthCalculation().returnAllMonths(dailyValues, year);

		//then
		assertThat(actual, notNullValue());
		assertThat(actual.size(), equalTo(2));
		assertThat(actual.get(1), equalTo(2));
	}
}