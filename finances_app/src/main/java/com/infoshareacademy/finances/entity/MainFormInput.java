package com.infoshareacademy.finances.entity;

import javax.persistence.*;

@Embeddable
public class MainFormInput {

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
