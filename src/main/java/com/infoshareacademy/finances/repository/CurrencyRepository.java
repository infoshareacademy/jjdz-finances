package com.infoshareacademy.finances.repository;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.infoshareacademy.finances.model.CurrencyAssests;

@Stateless
public class CurrencyRepository {

	@PersistenceContext
	EntityManager em;

	public List<CurrencyAssests> findAllCurrency() {
		return em.createQuery("select f from CurrencyAssests f", CurrencyAssests.class).getResultList();
	}
}
