package com.infoshareacademy.finances.service;

import com.infoshareacademy.finances.model.PlanCreationDto;

import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

@RequestScoped
public class PlanDaoService implements PlanDao {

    @PersistenceContext
//    EntityManagerFactory emf;
    EntityManager em;
//            = emf.createEntityManager() ;


    @Override
    public PlanCreationDto createOrUpdate(PlanCreationDto plan) {
        return em.merge(plan);
    }

    @Override
    public void delete(Long id) {
        em.getTransaction().begin();
        em.remove(em.find(PlanCreationDto.class, id));
        em.getTransaction().commit();
    }

    @Override
    public PlanCreationDto find(Long id) {
        return em.find(PlanCreationDto.class, id);
    }

}
