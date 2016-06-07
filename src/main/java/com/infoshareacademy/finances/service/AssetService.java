package com.infoshareacademy.finances.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.infoshareacademy.finances.model.DailyValue;
import com.infoshareacademy.finances.model.LstList;
import com.infoshareacademy.finances.repository.CurrencyRepository;
import com.infoshareacademy.finances.repository.DailyValuesRepository;
import com.infoshareacademy.finances.repository.FundsRepository;

@Stateless
public class AssetService {

	@EJB
	FundsRepository fundsRepository;

	@EJB
	CurrencyRepository currencyRepository;

	@EJB
	DailyValuesRepository dailyValuesRepository;

	public List<LstList> returnAllFunds() {
		List<LstList> out = new ArrayList<>();
		fundsRepository.findAllFunds().parallelStream()
				.forEach(s -> out.add(new LstList(s.getAsset().getName(), s.getAsset().getCode())));
		return out;
	}

	public List<LstList> returnAllCurrency() {
		List<LstList> out = new ArrayList<>();
		currencyRepository.findAllCurrency().parallelStream()
				.forEach(s -> out.add(new LstList(s.getAsset().getName(), s.getAsset().getCode())));
		return out;
	}

	public List<String> returnAvailableYears(String assetCode) {
		List<DailyValue> dailyValues = dailyValuesRepository.findAllDailyValues(assetCode);
		Set<Integer> integers = new YearData().returnAllYears(dailyValues);

		List<String> years = new ArrayList<>();
		integers.forEach(i -> years.add(i.toString()));
		return years;
	}

	public List<String> returnAvailableMonths(String assetCode, int year) {
		List<DailyValue> dailyValues = dailyValuesRepository.findAllDailyValues(assetCode);
		Set<String> months = new MonthData().returnAllMonths(dailyValues, year);

		List<String> monthsList = new ArrayList<>();
		months.forEach(m -> monthsList.add(m));
		monthsList.sort((m,n) -> m.compareTo(n));
		return monthsList;
	}
}
