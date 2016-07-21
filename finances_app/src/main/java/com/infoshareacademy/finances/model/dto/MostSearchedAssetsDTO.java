package com.infoshareacademy.finances.model.dto;

public class MostSearchedAssetsDTO {

	String assetName;
	Long amount;

	public MostSearchedAssetsDTO() {
	}

	public MostSearchedAssetsDTO(String assetName, Long amount) {
		this.assetName = assetName;
		this.amount = amount;
	}

	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}
}
