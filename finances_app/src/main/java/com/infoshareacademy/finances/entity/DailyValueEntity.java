package com.infoshareacademy.finances.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
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

	@ManyToOne
	private AssetEntity assetEntity;

	public DailyValueEntity() {
	}

	public DailyValueEntity(DailyValue dailyValue, AssetEntity assetEntity) {
		this.dailyValue = dailyValue;
		this.assetEntity = assetEntity;
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

	@Override
	public String toString() {
		return "DailyValueEntity{" +
				"id=" + id +
				", dailyValue=" + dailyValue +
				", assetEntity=" + assetEntity +
				'}';
	}
}
