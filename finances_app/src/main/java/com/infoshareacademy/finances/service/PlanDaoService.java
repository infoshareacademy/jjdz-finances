package com.infoshareacademy.finances.service;

import com.infoshareacademy.finances.entity.PlanCreationDto;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PlanDaoService  {

    @PersistenceContext
    EntityManager em;

    public void createOrUpdate(PlanCreationDto plan) {
        em.merge(plan);
    }

    public void delete(Long id) {
        em.remove(em.find(PlanCreationDto.class, id));
    }

    public PlanCreationDto find(Long id) {
        return em.find(PlanCreationDto.class, id);
    }

}
