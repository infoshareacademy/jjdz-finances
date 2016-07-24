package com.infoshareacademy.finances.model.dto;

import com.infoshareacademy.finances.entity.PlanActionType;


public class AssetsSumDTO {

    private Long idAsset;
    private String nameAsset;
    private Long sum;
    private PlanActionType planActionType;

    public AssetsSumDTO() { }

    public AssetsSumDTO(Long idAsset, String nameAsset, Long sum, PlanActionType planActionType) {
        this.idAsset = idAsset;
        this.nameAsset = nameAsset;
        this.sum = sum;
        this.planActionType = planActionType;
    }

    public Long getIdAsset() {
        return idAsset;
    }

    public void setIdAsset(Long idAsset) {
        this.idAsset = idAsset;
    }

    public String getNameAsset() {
        return nameAsset;
    }

    public void setNameAsset(String nameAsset) {
        this.nameAsset = nameAsset;
    }

    public Long getSum() {
        return sum;
    }

    public void setSum(Long sum) {
        this.sum = sum;
    }

    public PlanActionType getPlanActionType() {
        return planActionType;
    }

    public void setPlanActionType(PlanActionType planActionType) {
        this.planActionType = planActionType;
    }
}
