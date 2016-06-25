package com.infoshareacademy.finances.reports.repository;

import com.infoshareacademy.finances.reports.entities.PlanCreationDtoLite;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PlansRepository {

    @PersistenceContext(unitName = "sample")
    EntityManager em;

    public Long save(PlanCreationDtoLite plan) {
        em.persist(plan);
        return plan.getId();
    }

    public void update(PlanCreationDtoLite plan) {
        em.merge(plan);
    }

    public PlanCreationDtoLite retrievePlanById(Long id) {
       return em.find(PlanCreationDtoLite.class, id);
    }
}
