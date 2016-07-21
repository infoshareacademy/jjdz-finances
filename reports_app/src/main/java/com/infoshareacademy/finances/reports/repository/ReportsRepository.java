package com.infoshareacademy.finances.reports.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.infoshareacademy.finances.reports.entities.Report;
import com.infoshareacademy.finances.reports.entities.ReportName;

@Stateless
public class ReportsRepository {

	@PersistenceContext
	EntityManager em;

	public void save(Report report) {
		em.persist(report);
	}

	public Long returnReportMaxId(ReportName name) {
		return em.createQuery("select max(r.id) from Report r where r.name = :name", Number.class)
				.setParameter("name", name).getSingleResult().longValue();
	}

	public Report returnReport(Long id) {
		return em.find(Report.class, id);
	}

	public int deleteOldReports(ReportName name, Long id) {
		return em.createQuery("delete from Report r where r.name = :name and r.id < :id").setParameter("name", name)
				.setParameter("id", id).executeUpdate();
	}
}
