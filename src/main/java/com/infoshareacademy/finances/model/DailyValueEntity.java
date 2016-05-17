package com.infoshareacademy.finances.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class DailyValueEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Embedded
	private DailyValue dailyValue;

	@ManyToOne (fetch = FetchType.EAGER)
	private AssetEntity assetEntity;

	public DailyValueEntity() {
	}

	public DailyValueEntity(DailyValue dailyValue) {
		this.dailyValue = dailyValue;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DailyValue getDailyValue() {
		return dailyValue;
	}

	public void setDailyValue(DailyValue dailyValue) {
		this.dailyValue = dailyValue;
	}
}
