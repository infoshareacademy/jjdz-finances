package com.infoshareacademy.finances.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.infoshareacademy.finances.entity.CurrencyAssets;

@Stateless
public class CurrencyRepository {

	@PersistenceContext
	EntityManager em;

	public List<CurrencyAssets> findAllCurrency() {
		return em.createQuery("select f from CurrencyAssets f", CurrencyAssets.class).getResultList();
	}
}
