package com.infoshareacademy.finances.service.users;

import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Verb;
import com.infoshareacademy.finances.entity.Privileges;
import com.infoshareacademy.finances.entity.UserPrivileges;
import com.infoshareacademy.finances.model.UserInfo;
import com.infoshareacademy.finances.model.UserInfoEntity;
import com.infoshareacademy.finances.repository.UserInfoRepository;
import com.infoshareacademy.finances.repository.UserPrivilegesRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.ByteArrayInputStream;

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
        LOGGER.info("Getting the user's G+ profile for thread: {} ", threadId);
        OAuthRequest oReq = new OAuthRequest(Verb.GET,
                "https://www.googleapis.com/oauth2/v2/userinfo",
                sessionData.getService());
        sessionData.getService().signRequest(sessionData.getOAuthToken(), oReq);
        Response oResp = oReq.send();

        JsonReader reader = Json.createReader(new ByteArrayInputStream(
                oResp.getBody().getBytes()));
        JsonObject profile = reader.readObject();

		String email = profile.getString("email");
        UserInfo userInfo = new UserInfo(profile.getString("name"), email);
        sessionData.setUserInfo(userInfo);
        LOGGER.info("User information {} acquired for thread: {} - end", userInfo, threadId);

        if (userInfoRepository.userNotExists(userInfo)) {
			UserInfoEntity userInfoEntity = UserInfoEntity
					.fromUserInfo(userInfo)
					.withCurrentDate()
					.build();
            userInfoRepository.saveUserInfoEntityToDB(userInfoEntity);
			userPrivilegesRepository.saveUserPrivileges(new UserPrivileges(Privileges.MORTAL,userInfoEntity));
			sessionData.setPrivileges(Privileges.MORTAL);
        }else{
			sessionData.setPrivileges(userPrivilegesRepository.loadUserPrivileges(email));
		}
    }





}

