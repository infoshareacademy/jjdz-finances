package com.infoshareacademy.finances.repository;

import com.infoshareacademy.finances.entity.PlanCreationDto;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PlansRepository {

	@PersistenceContext
	EntityManager em;

	public List<PlanCreationDto> findAllPlans(Long userId) {
	return em.createQuery("select p from PlanCreationDto p join p.userInfoEntity u where u.id = :Id", PlanCreationDto.class)
			.setParameter("Id", userId).getResultList();
	}
}
