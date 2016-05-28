package com.infoshareacademy.finances.model;

import com.infoshareacademy.finances.service.DateConverter;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
public class PlanCreationDto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private PlanActionType planActionType;

    private int quantity;

//    @Convert(converter = DateConverter.class)
    private ZonedDateTime actionTime;

    @ManyToOne
    private AssetEntity assetEntity;

    @ManyToOne
    private UserInfoEntity userInfoEntity;


    public PlanCreationDto() {
    }

    public PlanCreationDto(PlanActionType planActionType, int quantity, ZonedDateTime actionTime, AssetEntity assetEntity, UserInfoEntity userInfoEntity) {
        this.planActionType = planActionType;
        this.quantity = quantity;
        this.actionTime = actionTime;
        this.assetEntity = assetEntity;
        this.userInfoEntity = userInfoEntity;
    }

    public Long getId() {
        return id;
    }

    public PlanActionType getPlanActionType() {
        return planActionType;
    }

    public int getQuantity() {
        return quantity;
    }

    public ZonedDateTime getActionTime() {
        return actionTime;
    }

    public AssetEntity getAssetEntity() {
        return assetEntity;
    }

    public UserInfoEntity getUserInfoEntity() {
        return userInfoEntity;
    }

    public enum PlanActionType {
        BUY, SELL
    }
}
