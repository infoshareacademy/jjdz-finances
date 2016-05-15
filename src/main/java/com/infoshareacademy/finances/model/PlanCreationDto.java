package com.infoshareacademy.finances.model;

import com.infoshareacademy.finances.service.DateConverter;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
public class PlanCreationDto {

    @Id
    @GeneratedValue
    private Long id;
    @Convert(converter = DateConverter.class)
    private ZonedDateTime sellTime;
    @Convert(converter = DateConverter.class)
    private ZonedDateTime buyTime;
    @ManyToOne
    private Asset asset;
    private int quantity;

    public PlanCreationDto() {
    }

    public PlanCreationDto(Long id, ZonedDateTime sellTime, ZonedDateTime buyTime, Asset asset, int quantity) {
        this.id = id;
        this.sellTime = sellTime;
        this.buyTime = buyTime;
        this.asset = asset;
        this.quantity = quantity;
    }


    public ZonedDateTime getSellTime() {
        return sellTime;
    }

    public ZonedDateTime getBuyTime() {
        return buyTime;
    }

    public Asset getAsset() {
        return asset;
    }

    public int getQuantity() {
        return quantity;
    }

    public Long getId() {
        return id;
    }
}
