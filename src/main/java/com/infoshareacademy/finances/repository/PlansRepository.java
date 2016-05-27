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
		plansList.add(new PlanCreationDto(1L, ZonedDateTime.now(), new Asset("NOVO Akcji Globalnych", "OPE033"), PlanCreationDto.PlanActionType.BUY, 67));
		plansList.add(new PlanCreationDto(2L, ZonedDateTime.now(), new Asset("NOVO Akcji Globalnych", "OPE033"), PlanCreationDto.PlanActionType.BUY, 57));
		plansList.add(new PlanCreationDto(3L, ZonedDateTime.now(), new Asset("NOVO Zrownowazonego Wzrostu", "SEB001"), PlanCreationDto.PlanActionType.SELL, 26));
		plansList.add(new PlanCreationDto(4L, ZonedDateTime.now(), new Asset("NOVO Akcji Globalnych", "OPE033"), PlanCreationDto.PlanActionType.BUY, 27));
		plansList.add(new PlanCreationDto(5L, ZonedDateTime.now(), new Asset("ALLIANZ Akcji", "ALL001"), PlanCreationDto.PlanActionType.BUY, 17));
		plansList.add(new PlanCreationDto(6L, ZonedDateTime.now(), new Asset("NOVO Zrownowazonego Wzrostu", "SEB001"), PlanCreationDto.PlanActionType.SELL, 25));
		return plansList;
	}
}
