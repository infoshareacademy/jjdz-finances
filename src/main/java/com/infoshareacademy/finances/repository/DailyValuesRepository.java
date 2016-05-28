package com.infoshareacademy.finances.repository;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.infoshareacademy.finances.model.Asset;
import com.infoshareacademy.finances.model.DailyValue;
import com.infoshareacademy.finances.model.DailyValueEntity;

@Stateless
public class DailyValuesRepository {

	@PersistenceContext
	EntityManager em;

	public List<DailyValueEntity> findDailyValuesByRange(String code, LocalDate dateFrom, LocalDate dateTo) {
		return em.createQuery(
				"select d from DailyValueEntity d "
						+ "join d.assetEntity a "
						+ "where a.asset.code = :code "
						+ "and d.dailyValue.date >= :dateFrom "
						+ "and d.dailyValue.date <= :dateTo",
				DailyValueEntity.class)
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
