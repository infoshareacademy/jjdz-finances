package com.infoshareacademy.finances.reports.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.infoshareacademy.finances.reports.entities.MainFormInputData;

@Stateless
public class MainFormInputRepository {

	@PersistenceContext
	EntityManager em;

	public Long save(MainFormInputData data){
		em.persist(data);
		return data.getId();
	}
}
