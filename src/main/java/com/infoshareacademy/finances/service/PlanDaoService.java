package com.infoshareacademy.finances.service;

import com.infoshareacademy.finances.model.PlanCreationDto;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PlanDaoService implements PlanDao {

    @PersistenceContext
    EntityManager em;


    @Override
    public PlanCreationDto createOrUpdate(PlanCreationDto plan) {
        return em.merge(plan);
    }

    @Override
    public void delete(Long id) {
        em.remove(em.find(PlanCreationDto.class, id));
    }

    @Override
    public PlanCreationDto find(Long id) {
        return em.find(PlanCreationDto.class, id);
    }
}
