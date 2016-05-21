package com.infoshareacademy.finances.model;

import com.infoshareacademy.finances.service.DateConverter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;

@Entity
public class PlanCreationDto implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    @Convert(converter = DateConverter.class)
    private ZonedDateTime sellTime;
    @Convert(converter = DateConverter.class)
    private ZonedDateTime buyTime;
    private String asset;
    private int quantity;

    public PlanCreationDto() {
    }

    public PlanCreationDto(Long id, ZonedDateTime sellTime, ZonedDateTime buyTime, Asset asset, int quantity) {
        this.id = id;
        this.sellTime = sellTime;
        this.buyTime = buyTime;
        this.asset = asset.getName();
        this.quantity = quantity;
    }


    public Long getId() {
        return id;
    }

    public ZonedDateTime getSellTime() {
        return sellTime;
    }

    public ZonedDateTime getBuyTime() {
        return buyTime;
    }

    public String getAsset() {
        return asset;
    }

    public int getQuantity() {
        return quantity;
    }
}
