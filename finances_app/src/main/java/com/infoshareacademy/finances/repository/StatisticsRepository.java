package com.infoshareacademy.finances.repository;

import com.infoshareacademy.finances.model.FundStatsDTO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class StatisticsRepository {

    private static final int LIMIT = 3;

    @PersistenceContext
    EntityManager em;

    public List<FundStatsDTO> findMaxPurchasingFunds(){
        return em.createQuery(
                "select new com.infoshareacademy.finances.model.FundStatsDTO(a.asset.name, " +
                        "p.assetEntity.id, sum(p.quantity)) " +
                        "from PlanCreationDto p " +
                        "join p.assetEntity a " +
                        "where p.planActionType = 'BUY' " +
                        "group by p.assetEntity.id " +
                        "order by sum(p.quantity) desc", FundStatsDTO.class)
                .setMaxResults(LIMIT)
                .getResultList();
    }

    public List<FundStatsDTO> findMaxSellingFunds(){
        return em.createQuery(
                "select new com.infoshareacademy.finances.model.FundStatsDTO(a.asset.name, " +
                        "p.assetEntity.id, sum(p.quantity)) " +
                        "from PlanCreationDto p " +
                        "join p.assetEntity a " +
                        "where p.planActionType = 'SELL' " +
                        "group by p.assetEntity.id " +
                        "order by sum(p.quantity) desc", FundStatsDTO.class)
                .setMaxResults(LIMIT)
                .getResultList();
    }


}
