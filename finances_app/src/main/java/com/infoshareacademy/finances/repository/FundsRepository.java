package com.infoshareacademy.finances.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.infoshareacademy.finances.entity.AssetEntity;
import com.infoshareacademy.finances.entity.FundsAssets;

@Stateless
public class FundsRepository {

	@PersistenceContext
	EntityManager em;

	public List<FundsAssets> findAllFunds() {
		return em.createQuery("select f from FundsAssets f", FundsAssets.class).getResultList();
	}

	public AssetEntity findRandomAsset(String code) {
		return em.createQuery("select a from AssetEntity a where a.asset.code = :kod", AssetEntity.class).setParameter("kod", code).getSingleResult();
	}
}
