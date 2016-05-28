package com.infoshareacademy.finances.repository;

import com.infoshareacademy.finances.model.Asset;
import com.infoshareacademy.finances.model.PlanCreationDto;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.ZonedDateTime;
import java.util.ArrayList;
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
