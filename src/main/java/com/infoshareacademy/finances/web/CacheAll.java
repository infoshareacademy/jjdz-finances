package com.infoshareacademy.finances.web;

import javax.annotation.PostConstruct;
import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.infoshareacademy.finances.entity.Privileges;
import com.infoshareacademy.finances.entity.UserPrivileges;
import com.infoshareacademy.finances.model.*;
import com.infoshareacademy.finances.repository.CurrencyRepository;
import com.infoshareacademy.finances.repository.FundsRepository;
import com.infoshareacademy.finances.repository.UserInfoRepository;
import com.infoshareacademy.finances.repository.UserPrivilegesRepository;
import com.infoshareacademy.finances.service.AssetsLoader;
import com.infoshareacademy.finances.service.DataLoader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Singleton
@Startup
public class CacheAll {

	@PersistenceContext
	EntityManager em;

	@EJB
	FundsRepository fundsRepository;

	@EJB
	CurrencyRepository currencyRepository;

	@EJB
	UserPrivilegesRepository userPrivilegesRepository;

	@EJB
	UserInfoRepository userInfoRepository;

	@PostConstruct
	public void initialize() {
		AssetsLoader assetsLoader = new AssetsLoader();
		//-----------------------------------------------------
		Asset asset1 = new Asset("NOVO Akcji Globalnych","OPE033");
		Asset asset2 = new Asset("NOVO Zrownowazonego Wzrostu","SEB001");
		Asset asset3 = new Asset("ALLIANZ Akcji","ALL001");
		List<Asset> funds = Arrays.asList(asset1);
		//-----------------------------------------------------
		//List<Asset> funds = assetsLoader.readAssetsFromFile("/omegafun.lst");
		DataLoader dataLoader = new DataLoader();
		funds.forEach((f) -> {
			FundsAssets asset = new FundsAssets(f);
			List<DailyValue> dailyValues = dataLoader.loadDataFromFile("funds/" + f.getCode() + ".txt");
	//		em.persist(asset);
			for (DailyValue dailyValue : dailyValues) {
	//			em.persist(new DailyValueEntity(dailyValue, asset));
			}
		});
		//-----------------------------------------------------
		Asset currency1 = new Asset("euro","EUR");
		Asset currency2 = new Asset("dolar australijski ","AUD");
		Asset currency3 = new Asset("jen (Japonia)","JPY");
		List<Asset> currencies = Arrays.asList(currency1,currency2,currency3);
		//-----------------------------------------------------
		//List<Asset> currencies = assetsLoader.readAssetsFromFile("/omeganbp.lst");
		currencies.forEach((c) -> {
			CurrencyAssets asset = new CurrencyAssets(c);
			List<DailyValue> dailyValues = dataLoader.loadDataFromFile("currencies/" + c.getCode() + ".txt");
	//		em.persist(asset);
			for (DailyValue dailyValue : dailyValues) {
//				em.persist(new DailyValueEntity(dailyValue, asset));
				}
		});

		UserInfo userInfo = new UserInfo("Vash The Stampede","karol.zyskowski1@gmail.com");
		UserInfoEntity userInfoEntity = UserInfoEntity
				.fromUserInfo(userInfo)
				.withCurrentDate()
				.build();
		userInfoRepository.saveUserInfoEntityToDB(userInfoEntity);
		userPrivilegesRepository.saveUserPrivileges(new UserPrivileges(Privileges.ADMIN,userInfoEntity));

		userInfo = new UserInfo("kowalaski","kowalski@mail.com");
		userInfoEntity = UserInfoEntity
				.fromUserInfo(userInfo)
				.withCurrentDate()
				.build();
		userInfoRepository.saveUserInfoEntityToDB(userInfoEntity);
		userPrivilegesRepository.saveUserPrivileges(new UserPrivileges(Privileges.MORTAL,userInfoEntity));
	}

	public List<LstList> returnAllFunds() {
		List<LstList> out = new ArrayList<>();
		fundsRepository.findAllFunds().parallelStream()
				.forEach( s -> out.add(new LstList(s.getAsset().getName(),s.getAsset().getCode())));
		return out;
	}
	public List<LstList> returnAllCurrency() {
		List<LstList> out = new ArrayList<>();
		currencyRepository.findAllCurrency().parallelStream()
				.forEach( s -> out.add(new LstList(s.getAsset().getName(),s.getAsset().getCode())));
		return out;
	}
}
