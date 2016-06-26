package com.infoshareacademy.finances.web;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.infoshareacademy.finances.entity.Asset;
import com.infoshareacademy.finances.entity.AssetEntity;
import com.infoshareacademy.finances.entity.CurrencyAssets;
import com.infoshareacademy.finances.entity.DailyValue;
import com.infoshareacademy.finances.entity.DailyValueEntity;
import com.infoshareacademy.finances.entity.FundsAssets;
import com.infoshareacademy.finances.entity.PlanActionType;
import com.infoshareacademy.finances.entity.PlanCreationDto;
import com.infoshareacademy.finances.entity.Privileges;
import com.infoshareacademy.finances.entity.UserInfo;
import com.infoshareacademy.finances.entity.UserInfoEntity;
import com.infoshareacademy.finances.entity.UserPrivileges;
import com.infoshareacademy.finances.repository.CurrencyRepository;
import com.infoshareacademy.finances.repository.FundsRepository;
import com.infoshareacademy.finances.repository.PlansRepository;
import com.infoshareacademy.finances.repository.UserInfoRepository;
import com.infoshareacademy.finances.repository.UserPrivilegesRepository;
import com.infoshareacademy.finances.service.fileOperations.AssetsLoader;
import com.infoshareacademy.finances.service.fileOperations.DailyValuesLoader;

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

	@EJB
	PlansRepository plansRepository;

	@PostConstruct
	public void initialize() {
		AssetsLoader assetsLoader = new AssetsLoader();
		//-----------------------------------------------------
		Asset asset1 = new Asset("NOVO Akcji Globalnych", "OPE033");
		Asset asset2 = new Asset("NOVO Zrownowazonego Wzrostu", "SEB001");
		Asset asset3 = new Asset("ALLIANZ Akcji", "ALL001");
		List<Asset> funds = Arrays.asList(asset1,asset2,asset3);
		//-----------------------------------------------------
//		List<Asset> funds = assetsLoader.readAssetsFromFile("/omegafun.lst");
		DailyValuesLoader dataLoader = new DailyValuesLoader();
		funds.forEach(f -> {
			FundsAssets asset = new FundsAssets(f);
			List<DailyValue> dailyValues = dataLoader.loadDataFromFile("funds/" + f.getCode() + ".txt");
						em.persist(asset);
			for (DailyValue dailyValue : dailyValues) {
								em.persist(new DailyValueEntity(dailyValue, asset));
			}
		});
		//-----------------------------------------------------
		Asset currency1 = new Asset("euro", "EUR");
		Asset currency2 = new Asset("dolar australijski ", "AUD");
		Asset currency3 = new Asset("jen (Japonia)", "JPY");
		List<Asset> currencies = Arrays.asList(currency1, currency2, currency3);
		//-----------------------------------------------------
//		List<Asset> currencies = assetsLoader.readAssetsFromFile("/omeganbp.lst");
		currencies.forEach(c -> {
			CurrencyAssets asset = new CurrencyAssets(c);
			List<DailyValue> dailyValues = dataLoader.loadDataFromFile("currencies/" + c.getCode() + ".txt");
						em.persist(asset);
			for (DailyValue dailyValue : dailyValues) {
								em.persist(new DailyValueEntity(dailyValue, asset));
			}
		});

		UserInfo userInfo = new UserInfo("Vash The Stampede", "karol.zyskowski1@gmail.com");
		UserInfoEntity userInfoEntityVash = UserInfoEntity.fromUserInfo(userInfo).withCurrentDate().build();
		userInfoRepository.saveUserInfoEntityToDB(userInfoEntityVash);
		userPrivilegesRepository.saveUserPrivileges(new UserPrivileges(Privileges.ADMIN, userInfoEntityVash));

		userInfo = new UserInfo("kowalaski", "kowalski@mail.com");
		UserInfoEntity userInfoEntity = UserInfoEntity.fromUserInfo(userInfo).withCurrentDate().build();
		userInfoRepository.saveUserInfoEntityToDB(userInfoEntity);
		userPrivilegesRepository.saveUserPrivileges(new UserPrivileges(Privileges.MORTAL, userInfoEntity));

		userInfo = new UserInfo("kowalaski2", "kowalski2@mail.com");
		userInfoEntity = UserInfoEntity.fromUserInfo(userInfo).withCurrentDate().build();
		userInfoRepository.saveUserInfoEntityToDB(userInfoEntity);
		userPrivilegesRepository.saveUserPrivileges(new UserPrivileges(Privileges.MORTAL, userInfoEntity));

        userInfo = new UserInfo("Łukasz Goc", "goc.lukasz@gmail.com");
		userInfoEntity = UserInfoEntity.fromUserInfo(userInfo).withCurrentDate().build();
		userInfoRepository.saveUserInfoEntityToDB(userInfoEntity);
		userPrivilegesRepository.saveUserPrivileges(new UserPrivileges(Privileges.MORTAL, userInfoEntity));

		String code = "OPE033";
		AssetEntity asset = fundsRepository.findRandomAsset(code);
		em.persist(new PlanCreationDto(PlanActionType.BUY, 65, ZonedDateTime.now(), asset,
				userInfoEntity));
		em.persist(new PlanCreationDto(PlanActionType.SELL, 37, ZonedDateTime.now(), asset,
				userInfoEntity));
		em.persist(new PlanCreationDto(PlanActionType.BUY, 65, ZonedDateTime.now(), asset,
				userInfoEntity));
		em.persist(new PlanCreationDto(PlanActionType.SELL, 47, ZonedDateTime.now(), asset,
				userInfoEntity));
		em.persist(new PlanCreationDto(PlanActionType.BUY, 12, ZonedDateTime.now(), asset,
				userInfoEntity));
		AssetEntity asset4 = fundsRepository.findRandomAsset("OPE033");
		AssetEntity asset5 = fundsRepository.findRandomAsset("SEB001");
		AssetEntity asset6 = fundsRepository.findRandomAsset("ALL001");
		em.persist(new PlanCreationDto(PlanActionType.BUY, 65, ZonedDateTime.now(), asset4, userInfoEntity));
		em.persist(new PlanCreationDto(PlanActionType.SELL, 37, ZonedDateTime.now(), asset5, userInfoEntity));
		em.persist(new PlanCreationDto(PlanActionType.BUY, 65, ZonedDateTime.now(), asset6, userInfoEntity));
		em.persist(new PlanCreationDto(PlanActionType.SELL, 47, ZonedDateTime.now(), asset4, userInfoEntity));
		em.persist(new PlanCreationDto(PlanActionType.BUY, 12, ZonedDateTime.now(), asset5, userInfoEntity));

		String codeVash = "SEB001";
		AssetEntity assetVash = fundsRepository.findRandomAsset(codeVash);
		em.persist(new PlanCreationDto(PlanActionType.BUY, 65, ZonedDateTime.now(), assetVash,
				userInfoEntityVash));
		em.persist(new PlanCreationDto(PlanActionType.SELL, 37, ZonedDateTime.now(), assetVash,
				userInfoEntityVash));
		em.persist(new PlanCreationDto(PlanActionType.BUY, 65, ZonedDateTime.now(), assetVash,
				userInfoEntityVash));
		em.persist(new PlanCreationDto(PlanActionType.SELL, 47, ZonedDateTime.now(), assetVash,
				userInfoEntityVash));
		em.persist(new PlanCreationDto(PlanActionType.BUY, 12, ZonedDateTime.now(), assetVash,
				userInfoEntityVash));
	}
}
