package com.infoshareacademy.finances.reports.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.infoshareacademy.finances.reports.dto.MostSearchedAssetsDTO;
import com.infoshareacademy.finances.reports.entities.MainFormInput;

@Stateless
public class MainFormInputRepository {

	@PersistenceContext
	EntityManager em;

	public Long save(MainFormInput data) {
		em.persist(data);
		return data.getId();
	}

	public List<MostSearchedAssetsDTO> findMostSearchedAssets() {
		return em.createQuery("select new com.infoshareacademy.finances.reports.dto.MostSearchedAssetsDTO(m.assetName, "
				+ "count(m)) from MainFormInput m group by  m.assetName", MostSearchedAssetsDTO.class).getResultList();
	}
}
