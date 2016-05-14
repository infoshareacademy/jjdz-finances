package com.infoshareacademy.finances.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.ZonedDateTime;

@Entity
public class PlanCreationDto {

    @Id
    @GeneratedValue
    private final Long id;
    private final ZonedDateTime sellTime;
    private final ZonedDateTime buyTime;
    @OneToMany
    private final Asset asset;
    private final int quantity;

//    public PlanCreationDto() {
//    }

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
