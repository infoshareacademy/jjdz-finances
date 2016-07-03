package com.infoshareacademy.finances.reports.entities;

import javax.enterprise.context.SessionScoped;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.io.Serializable;

@Entity
public class MainFormInputData implements Serializable {
	private static final long serialVersionUID = 7128674038756548668L;

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;

    private Long assetId;
    private String assetCode;
	private String assetName;
    private String month;
    private String year;
    private Long userId;

	public MainFormInputData() {
	}

	public MainFormInputData(Long assetId, String assetCode, String assetName, String month, String year, Long userId) {
		this.assetId = assetId;
		this.assetCode = assetCode;
		this.assetName = assetName;
		this.month = month;
		this.year = year;
		this.userId = userId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAssetId() {
		return assetId;
	}

	public void setAssetId(Long assetId) {
		this.assetId = assetId;
	}

	public String getAssetCode() {
		return assetCode;
	}

	public void setAssetCode(String assetCode) {
		this.assetCode = assetCode;
	}

	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
