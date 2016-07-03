package com.infoshareacademy.finances.reports.entities;

import javax.enterprise.context.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.io.Serializable;

@Entity
public class MainFormInput implements Serializable {
	private static final long serialVersionUID = 7128674038756548668L;

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String assetCode;

	@Column(nullable = false)
	private String assetName;

	@Column(nullable = false)
	private Long userId;

	private String month;
	private String year;

	public MainFormInput() {
	}

	public MainFormInput(String assetCode, String assetName, Long userId, String month, String year) {
		this.assetCode = assetCode;
		this.assetName = assetName;
		this.userId = userId;
		this.month = month;
		this.year = year;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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
}
