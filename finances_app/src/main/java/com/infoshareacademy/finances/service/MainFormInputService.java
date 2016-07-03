package com.infoshareacademy.finances.service;

import com.infoshareacademy.finances.entity.MainFormInput;
import com.infoshareacademy.finances.entity.MainFormInputEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class MainFormInputService {

	@PersistenceContext
	EntityManager em;

	public void logToDB(MainFormInput input){
		MainFormInputEntity entity = MainFormInputEntity.fromMainFormInput(input)
				.withCurrentDate()
				.build();

		em.persist(entity);
	}

}
