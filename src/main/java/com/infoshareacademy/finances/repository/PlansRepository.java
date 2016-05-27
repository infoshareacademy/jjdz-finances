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

	public List<PlanCreationDto> findAllPlans() {
	//	return em.createQuery("select p from PlanCreationDto p", PlanCreationDto.class).getResultList();
		List<PlanCreationDto> plansList = new ArrayList<>();
		plansList.add(new PlanCreationDto(1L, ZonedDateTime.now(), new Asset("Azoty", "AZ001"), PlanCreationDto.PlanActionType.BUY, 67));
		plansList.add(new PlanCreationDto(2L, ZonedDateTime.now(), new Asset("Koty", "DZ031"), PlanCreationDto.PlanActionType.BUY, 57));
		plansList.add(new PlanCreationDto(3L, ZonedDateTime.now(), new Asset("Mloty", "BB021"), PlanCreationDto.PlanActionType.SELL, 26));
		return plansList;
	}
}
