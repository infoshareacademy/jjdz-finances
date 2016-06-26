package com.infoshareacademy.finances.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.infoshareacademy.finances.entity.AssetEntity;

@Stateless
public class AssetRepository {
    @PersistenceContext
    EntityManager entityManager;

    public Long findAssetID(String assetCode) {
        return entityManager.createQuery("select u.id from AssetEntity u where u.asset.code = :assetCode", Long.class)
                .setParameter("assetCode",assetCode).getSingleResult();
    }

	public AssetEntity findAssetByCode(String assetCode) {
		return entityManager.createQuery("select u from AssetEntity u where u.asset.code = :assetCode", AssetEntity.class)
				.setParameter("assetCode",assetCode).getSingleResult();
	}

}
