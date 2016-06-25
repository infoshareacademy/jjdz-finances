package com.infoshareacademy.finances.service;

import com.infoshareacademy.finances.model.MainFormInput;
import com.infoshareacademy.finances.model.MainFormInputEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class MainFormInputLogService {

    @PersistenceContext
    EntityManager em;

    public void logToDB(MainFormInput input){
        MainFormInputEntity entity = MainFormInputEntity.fromMainFormInput(input)
                .withCurrentDate()
                .build();

        em.persist(entity);
    }

}
