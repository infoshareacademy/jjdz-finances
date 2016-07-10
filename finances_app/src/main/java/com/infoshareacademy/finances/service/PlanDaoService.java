package com.infoshareacademy.finances.service;

import com.infoshareacademy.finances.entity.PlanCreationDto;
import com.infoshareacademy.finances.model.rest.PlanCreationDtoLite;
import com.infoshareacademy.finances.service.rest.PlanClient;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class PlanDaoService {
	private static final Logger LOGGER = LoggerFactory.getLogger(PlanDaoService.class);

    @PersistenceContext
    EntityManager em;

	@EJB
	PlanClient planClient;

    public void createOrUpdate(PlanCreationDto plan) {
		LOGGER.info("##### PlanCreationDto: {}", plan);
        em.merge(plan);
		PlanCreationDtoLite planLite = new PlanCreationDtoLite(plan.getPlanActionType(),plan.getQuantity(),plan
				.getAssetEntity().getAsset().getName(),plan.getAssetEntity().getId());
		planClient.createRemotePlan(planLite);
    }

    public void delete(Long id) {
        em.remove(em.find(PlanCreationDto.class, id));
    }

//    public void update (Long id, PlanCreationDto planCreationDto) {
//        em.merge(em.find(PlanCreationDto.class, id), planCreationDto);
//    }

    public PlanCreationDto find(Long id) {
        return em.find(PlanCreationDto.class, id);
    }

}
