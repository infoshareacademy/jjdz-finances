package com.infoshareacademy.finances.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;

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

	@EJB
	MonthData monthData;

	@EJB
	YearData yearData;

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
		Set<Integer> integers = yearData.returnAllYears(dailyValues);

		List<String> years = new ArrayList<>();
		integers.forEach(i -> years.add(i.toString()));
		return years;
	}

	public List<Integer> returnAvailableMonths(String assetCode, int year) {
		List<DailyValue> dailyValues = dailyValuesRepository.findAllDailyValues(assetCode);
		List<Integer> months = monthData.returnAllMonths(dailyValues, year);
		return months;
	}
}
