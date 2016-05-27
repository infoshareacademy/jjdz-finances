package com.infoshareacademy.finances.model;

import com.infoshareacademy.finances.service.DateConverter;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
public class PlanCreationDto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Convert(converter = DateConverter.class)
    private ZonedDateTime actionTime;
    @Embedded
    private Asset asset;
    @Enumerated(EnumType.STRING)
    private PlanActionType planActionType;
    private int quantity;


    public PlanCreationDto() {
    }

    public PlanCreationDto(Long id, ZonedDateTime actionTime, Asset asset, PlanActionType planActionType, int quantity) {
        this.id = id;
        this.actionTime = actionTime;
        this.asset = asset;
        this.planActionType = planActionType;
        this.quantity = quantity;
    }


    public Long getId() {
        return id;
    }

    public ZonedDateTime getActionTime() {
        return actionTime;
    }

    public Asset getAsset() {
        return asset;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setActionTime(ZonedDateTime actionTime) {
        this.actionTime = actionTime;
    }

    public enum PlanActionType {
        BUY, SELL
    }
}
