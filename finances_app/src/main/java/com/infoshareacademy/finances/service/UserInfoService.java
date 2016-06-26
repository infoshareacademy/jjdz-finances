package com.infoshareacademy.finances.service;

import java.io.ByteArrayInputStream;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Verb;
import com.infoshareacademy.finances.entity.Privileges;
import com.infoshareacademy.finances.entity.UserPrivileges;
import com.infoshareacademy.finances.entity.UserInfo;
import com.infoshareacademy.finances.entity.UserInfoEntity;
import com.infoshareacademy.finances.repository.UserInfoRepository;
import com.infoshareacademy.finances.repository.UserPrivilegesRepository;

@Stateless
public class UserInfoService {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserInfoService.class);

	@Inject
	UserSessionData sessionData;

	@EJB
	UserPrivilegesRepository userPrivilegesRepository;

	@EJB
	UserInfoRepository userInfoRepository;

	public void getUserDetails() {
		Long threadId = Thread.currentThread().getId();
		OAuthRequest oReq;

		if (sessionData.getAuthType().equals("g")) {
			LOGGER.info("Getting the user's G+ profile for thread: {}", threadId);
			oReq = new OAuthRequest(Verb.GET, "https://www.googleapis.com/oauth2/v2/userinfo",
					sessionData.getService());
		} else {
			LOGGER.info("Getting the user's Facebook profile for thread: {}", threadId);
			oReq = new OAuthRequest(Verb.GET, "https://graph.facebook.com/me?fields=name,email",
					sessionData.getService());
		}
		sessionData.getService().signRequest(sessionData.getAuthToken(), oReq);
		Response oResp = oReq.send();

		UserInfo userInfo = retrieveUserInfoFromResponse(oResp, threadId);
		saveUserInfo(userInfo, threadId);
	}

	private UserInfo retrieveUserInfoFromResponse(Response oResp, Long threadId) {
		LOGGER.info("Reading profile from Jason for thread: {}", threadId);

		JsonReader reader = Json.createReader(new ByteArrayInputStream(oResp.getBody().getBytes()));
		JsonObject profile = reader.readObject();
		UserInfo userInfo = new UserInfo(profile.getString("name"), profile.getString("email"));

		LOGGER.info("User information {} acquired for thread: {} - end", userInfo, threadId);
		return userInfo;
	}

	private void saveUserInfo(UserInfo userInfo, Long threadId) {
		LOGGER.info("Saving user to sessionData and DB for thread: {}", threadId);
		sessionData.setUserInfo(userInfo);

		if (userInfoRepository.userNotExists(userInfo)) {

			UserInfoEntity userInfoEntity = UserInfoEntity.fromUserInfo(userInfo).withCurrentDate().build();
			userInfoRepository.saveUserInfoEntityToDB(userInfoEntity);

			userPrivilegesRepository.saveUserPrivileges(new UserPrivileges(Privileges.MORTAL, userInfoEntity));
			sessionData.setPrivileges(Privileges.MORTAL);

		} else {
			sessionData.setPrivileges(userPrivilegesRepository.loadUserPrivileges(userInfo.getMail()));
		}
		Long userId = userInfoRepository.findUserId(userInfo.getMail());
		sessionData.setUserId(userId);
	}

}

