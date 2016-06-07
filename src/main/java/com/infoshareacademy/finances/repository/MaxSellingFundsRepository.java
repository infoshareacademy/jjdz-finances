package com.infoshareacademy.finances.repository;

import com.infoshareacademy.finances.model.*;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class MaxSellingFundsRepository {

    //private static final String ACTION_TYPE = "SELL";
    private static final int LIMIT = 3;

    @PersistenceContext
    EntityManager em;


    public List<FundStatsDTO> findMaxSellingFunds(){
        return em.createQuery(
                "select new com.infoshareacademy.finances.model.FundStatsDTO(a.asset.name, " +
                        "p.assetEntity.id, sum(p.quantity)) " +
                        "from PlanCreationDto p " +
                        "join p.assetEntity a " +
                        "where p.planActionType = 'SELL' " +
                        "group by p.assetEntity.id " +
                        "order by sum(p.quantity) desc", FundStatsDTO.class)
                //.setParameter("actionType", ACTION_TYPE)
                .setMaxResults(LIMIT)
                .getResultList();
    }

}
