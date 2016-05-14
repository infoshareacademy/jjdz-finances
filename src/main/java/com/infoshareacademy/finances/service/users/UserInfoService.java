package com.infoshareacademy.finances.service.users;

import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Verb;
import com.infoshareacademy.finances.model.UserInfo;
import com.infoshareacademy.finances.model.UserInfoEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Asynchronous;
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
    private static Logger logger = LoggerFactory.getLogger(UserInfoService.class);

    @Inject
    UserSessionData sessionData;

    @PersistenceContext
    EntityManager em;

    public void getUserDetails() {
        Long threadId = Thread.currentThread().getId();
        logger.info("Getting the user's G+ profile for thread: {} ", threadId);
        OAuthRequest oReq = new OAuthRequest(Verb.GET,
                "https://www.googleapis.com/oauth2/v2/userinfo",
                sessionData.getService());
        sessionData.getService().signRequest(sessionData.getOAuthToken(), oReq);
        Response oResp = oReq.send();

        JsonReader reader = Json.createReader(new ByteArrayInputStream(
                oResp.getBody().getBytes()));
        JsonObject profile = reader.readObject();

        UserInfo userInfo = new UserInfo(profile.getString("name"), profile.getString("email"));
        sessionData.setUserInfo(userInfo);
        logger.info("User information {} acquired for thread: {} - end", userInfo, threadId);

        if (!userExists(userInfo)) {
            saveUserInfoToDB(userInfo);
        }
    }

    public boolean userExists(UserInfo userInfo) {
        return !em.createQuery("select u from UserInfoEntity u " +
                "where u.userInfo.name = :user and u.userInfo.mail = :mail")
                .setParameter("user", userInfo.getName())
                .setParameter("mail", userInfo.getMail())
                .getResultList().isEmpty();
    }

    public void saveUserInfoToDB(UserInfo userInfo) {
        UserInfoEntity entity = UserInfoEntity
                .fromUserInfo(userInfo)
                .withCurrentDate()
                .build();

        em.persist(entity);
    }
}

