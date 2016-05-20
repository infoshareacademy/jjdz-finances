package com.infoshareacademy.finances.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.infoshareacademy.finances.model.FundsAssets;

@Stateless
public class FundsRepository {

	@PersistenceContext
	EntityManager em;

	public List<FundsAssets> findAllFunds() {
		return em.createQuery("select f from FundsAssets f", FundsAssets.class).getResultList();
	}
}
