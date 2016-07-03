package com.infoshareacademy.finances.service;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@SessionScoped
public class MainFormInputData implements Serializable {
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
