package com.infoshareacademy.finances.service;

import com.infoshareacademy.finances.model.UserInfo;
import com.infoshareacademy.finances.model.UserInfoEntity;

import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UserInfoService {

    @PersistenceContext
    EntityManager em;

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

