package com.infoshareacademy.finances.service.calculation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import com.infoshareacademy.finances.entity.DailyValue;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

public class MonthlyTrendsServiceTest {

	private List<DailyValue> dailyValues;

	@Before
	public void initialize(){
		LocalDate date;
		BigDecimal closeValue;
		dailyValues = new ArrayList<>();

		date = LocalDate.now().withMonth(3).withDayOfMonth(1);
		closeValue = new BigDecimal("43.25");
		dailyValues.add(new DailyValue(date , closeValue));

		date = LocalDate.now().withMonth(3).withDayOfMonth(2);
		closeValue = new BigDecimal("22.25");
		dailyValues.add(new DailyValue(date , closeValue));

		date = LocalDate.now().withMonth(3).withDayOfMonth(3);
		closeValue = new BigDecimal("1.25");
		dailyValues.add(new DailyValue(date , closeValue));

		date = LocalDate.now().withMonth(2).withDayOfMonth(3);
		closeValue = new BigDecimal("12.45");
		dailyValues.add(new DailyValue(date , closeValue));

		date = LocalDate.now().withMonth(2).withDayOfMonth(2);
		closeValue = new BigDecimal("48.35");
		dailyValues.add(new DailyValue(date , closeValue));

		date = LocalDate.now().withMonth(2).withDayOfMonth(5);
		closeValue = new BigDecimal("3.17");
		dailyValues.add(new DailyValue(date , closeValue));

		date = LocalDate.now().withMonth(2).withDayOfMonth(10);
		closeValue = new BigDecimal("3.16");
		dailyValues.add(new DailyValue(date , closeValue));

		date = LocalDate.now().withMonth(2).withDayOfMonth(4);
		closeValue = new BigDecimal("50.15");
		dailyValues.add(new DailyValue(date , closeValue));

		date = LocalDate.now().withMonth(2).withDayOfMonth(7);
		closeValue = new BigDecimal("50.25");
		dailyValues.add(new DailyValue(date , closeValue));
	}

	@Test
	public void testCalculateTrend_return_proper_trend_values() throws Exception {
		//given
		//when
		MonthlyTrendsService monthlyTrendsService = new MonthlyTrendsService();
		List<DailyValue> actual = monthlyTrendsService.calculateTrend(dailyValues);
		List<DailyValue> actualAfterTwoExecutions = monthlyTrendsService.calculateTrend(actual);
		//then

		assertThat(actualAfterTwoExecutions, notNullValue());
		assertThat(actualAfterTwoExecutions.size(), CoreMatchers.equalTo(3));
		assertThat(actualAfterTwoExecutions.get(0).getCloseValue().toString(), CoreMatchers.equalTo("43.25"));
		assertThat(actualAfterTwoExecutions.get(1).getCloseValue().toString(), CoreMatchers.equalTo("1.25"));
	}
}