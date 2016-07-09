package com.infoshareacademy.finances.reports.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Report {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private ReportName name;
	private String report;

	public Report() {
	}

	public Report(ReportName name, String report) {
		this.name = name;
		this.report = report;
	}

	public ReportName getName() {
		return name;
	}

	public void setName(ReportName reportName) {
		this.name = reportName;
	}

	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
