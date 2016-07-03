package com.infoshareacademy.finances.reports.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PlanCreationDtoLite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private PlanActionType planActionType;

    private int quantity;

    private String assetName;

    private Long assetId;

    public PlanCreationDtoLite() {
    }

    public PlanCreationDtoLite(PlanActionType planActionType, int quantity, String assetName, Long assetId) {
        this.planActionType = planActionType;
        this.quantity = quantity;
        this.assetName = assetName;
        this.assetId = assetId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PlanActionType getPlanActionType() {
        return planActionType;
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
                "id=" + id +
                ", planActionType=" + planActionType +
                ", quantity=" + quantity +
                ", assetName='" + assetName + '\'' +
                ", assetId=" + assetId +
                '}';
    }
}
