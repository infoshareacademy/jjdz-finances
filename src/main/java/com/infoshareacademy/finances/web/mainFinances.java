package com.infoshareacademy.finances.web;

import javax.annotation.PostConstruct;
import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.infoshareacademy.finances.model.Asset;
import com.infoshareacademy.finances.model.CurrencyAssests;
import com.infoshareacademy.finances.model.FundsAssets;
import com.infoshareacademy.finances.model.LstList;
import com.infoshareacademy.finances.service.AssetsLoader;
import com.infoshareacademy.finances.service.LstLoad;

import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


@Singleton
@Startup
@Lock(LockType.READ)
public class mainFinances {
/*    public List<LstList> getAllFunds() {
        return em.createQuery().getResultList();
    }*/

    @PersistenceContext
    EntityManager em;

    @PostConstruct
    public void initialize() {

        AssetsLoader assetsLoader = new AssetsLoader();
        List<Asset> funds = assetsLoader.readAssetsFromFile("/omegafun.lst");
        funds.forEach((f) -> {
            FundsAssets assets = new FundsAssets(f);
            //pobrac daily values
            //assets.setDV(dv)
            em.persist(assets);
        });


        List<Asset> currencies = assetsLoader.readAssetsFromFile("/omeganbp.lst");
        currencies.forEach((c) -> em.persist(new CurrencyAssests(c)));


    }


}
