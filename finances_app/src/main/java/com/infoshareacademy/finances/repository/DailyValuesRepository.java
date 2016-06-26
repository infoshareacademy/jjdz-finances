package com.infoshareacademy.finances.repository;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.infoshareacademy.finances.entity.DailyValue;

@Stateless
public class DailyValuesRepository {

	@PersistenceContext
	EntityManager em;

	public List<DailyValue> findDailyValuesByRange(String code, LocalDate dateFrom, LocalDate dateTo) {
		return em.createQuery(
				"select d.dailyValue from DailyValueEntity d "
						+ "join d.assetEntity a "
						+ "where a.asset.code = :code "
						+ "and d.dailyValue.date >= :dateFrom "
						+ "and d.dailyValue.date <= :dateTo",
				DailyValue.class)
				.setParameter("code", code)
				.setParameter("dateFrom", dateFrom)
				.setParameter("dateTo", dateTo)
				.getResultList();
	}

	public List<DailyValue> findAllDailyValues(String code) {
		return em.createQuery("select d.dailyValue from DailyValueEntity d "
				+ "join d.assetEntity a "
				+ "where a.asset.code = :code", DailyValue.class)
				.setParameter("code", code)
				.getResultList();
	}
}
