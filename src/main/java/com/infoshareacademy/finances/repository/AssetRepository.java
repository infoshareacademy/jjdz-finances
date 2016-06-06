package com.infoshareacademy.finances.repository;

import javax.ejb.Stateless;
import javax.faces.convert.LongConverter;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AssetRepository {
    @PersistenceContext
    EntityManager entityManager;

    public Long findAssetID(String assetCode) {
        return entityManager.createQuery("select u.id from AssetEntity u where u.asset.code = :assetCode", Long.class)
                .setParameter("assetCode",assetCode).getSingleResult();
    }
}
