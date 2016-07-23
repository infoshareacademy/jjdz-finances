package com.infoshareacademy.finances.reports.repository;

import com.infoshareacademy.finances.reports.dto.AssetsSumDTO;
import com.infoshareacademy.finances.reports.entities.PlanActionType;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class StatisticRepository {

    private static final int LIMIT = 3;

    @PersistenceContext(unitName = "sample")
    EntityManager em;

    public List<AssetsSumDTO> findMostPurchasedOrSoldAssets(PlanActionType planActionType){

        return em.createQuery(
                "select new com.infoshareacademy.finances.reports.dto.AssetsSumDTO(" +
                        "p.assetId, p.assetName, sum(p.quantity), p.planActionType) " +
                        "from PlanCreationDtoLite p " +
                        "where p.planActionType = :planActionType " +
                        "group by p.assetId " +
                        "order by sum(p.quantity) desc ", AssetsSumDTO.class)
                .setParameter("planActionType", planActionType)
                .setMaxResults(LIMIT)
                .getResultList();
    }


}