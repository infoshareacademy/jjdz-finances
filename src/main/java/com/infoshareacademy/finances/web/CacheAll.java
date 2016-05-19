package com.infoshareacademy.finances.web;

import javax.annotation.PostConstruct;
import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.infoshareacademy.finances.model.*;
import com.infoshareacademy.finances.service.AssetsLoader;
import com.infoshareacademy.finances.service.DataLoader;

import java.util.List;


@Singleton
@Startup
public class CacheAll {
/*    public List<LstList> getAllFunds() {
        return em.createQuery().getResultList();
    }*/

    @PersistenceContext
    EntityManager em;

    @PostConstruct
    public void initialize() {

		System.out.println("post construct !!!!!!!!!!");
		AssetsLoader assetsLoader = new AssetsLoader();
		System.out.println("Made asset loader");
		List<Asset> funds = assetsLoader.readAssetsFromFile("/omegafun.lst");
        //DataLoader dataLoader = new DataLoader();
        funds.forEach((f) -> {
            FundsAssets assets = new FundsAssets(f);
            //List<DailyValue> dailyValues = dataLoader.loadDataFromFile(f.getCode());
            //pobrac daily values
            //assets.setDV(dv)
            em.persist(assets);
        });

//
//        List<Asset> currencies = assetsLoader.readAssetsFromFile("/omeganbp.lst");
//        currencies.forEach((c) -> em.persist(new CurrencyAssests(c)));

        return;
    }

    public List<LstList> returnAllFunds() {
        return null;
    }
}
