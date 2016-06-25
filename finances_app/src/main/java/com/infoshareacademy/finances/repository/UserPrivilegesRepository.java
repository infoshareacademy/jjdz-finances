package com.infoshareacademy.finances.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.infoshareacademy.finances.entity.Privileges;
import com.infoshareacademy.finances.entity.UserPrivileges;

@Stateless
public class UserPrivilegesRepository {

	@PersistenceContext
	EntityManager em;

	public void saveUserPrivileges(UserPrivileges userPrivileges) {
		em.persist(userPrivileges);
	}

	public Privileges loadUserPrivileges(String email) {
		return em.createQuery(
				"select p.privileges from UserPrivileges p join p.userInfoEntity i where i.userInfo.mail = :email",
				Privileges.class).setParameter("email", email).getSingleResult();
	}


}
