package com.infoshareacademy.finances.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.infoshareacademy.finances.model.UserInfo;
import com.infoshareacademy.finances.model.UserInfoEntity;

@Stateless
public class UserInfoRepository {

	@PersistenceContext
	EntityManager em;

	public void saveUserInfoEntityToDB(UserInfoEntity userInfoEntity) {
		em.persist(userInfoEntity);
	}

	public boolean userNotExists(UserInfo userInfo) {
		return em.createQuery("select u from UserInfoEntity u " +
				"where u.userInfo.name = :user and u.userInfo.mail = :mail")
				.setParameter("user", userInfo.getName())
				.setParameter("mail", userInfo.getMail())
				.getResultList().isEmpty();
	}
}
