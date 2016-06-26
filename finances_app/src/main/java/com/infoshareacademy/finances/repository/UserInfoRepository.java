package com.infoshareacademy.finances.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.infoshareacademy.finances.entity.Privileges;
import com.infoshareacademy.finances.entity.UserInfo;
import com.infoshareacademy.finances.entity.UserInfoEntity;

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

    public List<UserInfoEntity> loadUsersWithPrivileges(Privileges privileges) {
        return em.createQuery("select u from UserPrivileges p join p.userInfoEntity u where p.privileges = :privileges",
                UserInfoEntity.class).setParameter("privileges", privileges).getResultList();
    }

    public List<UserInfoEntity> loadAllUsers() {
        return em.createQuery("select i from UserInfoEntity i",
                UserInfoEntity.class).getResultList();
    }


	public Long findUserId(String mail) {
		return em.createQuery("select u.id from UserInfoEntity u where u.userInfo.mail= :adres", Long.class)
				.setParameter("adres", mail).getSingleResult();
	}

    public UserInfoEntity findUserById(Long id) {
        return em.find(UserInfoEntity.class, id);
    }
}
