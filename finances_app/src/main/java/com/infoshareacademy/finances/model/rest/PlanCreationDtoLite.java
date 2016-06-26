package com.infoshareacademy.finances.model.rest;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.EnumDeserializer;
import com.fasterxml.jackson.databind.ser.std.EnumSerializer;
import com.infoshareacademy.finances.entity.PlanActionType;

public class PlanCreationDtoLite {

//	@JsonSerialize(using = EnumSerializer.class)
//	@JsonDeserialize(using = EnumDeserializer.class)
    private PlanActionType planActionType;

    private int quantity;

    private String assetName;

    private Long assetId;

    public PlanCreationDtoLite() {
    }

	public PlanCreationDtoLite(PlanActionType planActionType, int quantity, String assetName,
			Long assetId) {
		this.planActionType = planActionType;
		this.quantity = quantity;
		this.assetName = assetName;
		this.assetId = assetId;
	}

	public void setPlanActionType(PlanActionType planActionType) {
		this.planActionType = planActionType;
	}

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public Long getAssetId() {
        return assetId;
    }

    public void setAssetId(Long assetId) {
        this.assetId = assetId;
    }

	@Override
	public String toString() {
		return "PlanCreationDtoLite{" +
				"planActionType=" + planActionType +
				", quantity=" + quantity +
				", assetName='" + assetName + '\'' +
				", assetId=" + assetId +
				'}';
	}
}
