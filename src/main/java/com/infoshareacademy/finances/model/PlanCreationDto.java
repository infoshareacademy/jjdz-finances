package com.infoshareacademy.finances.model;

import java.time.ZonedDateTime;

public class PlanCreationDto {
    private final ZonedDateTime sellTime;
    private final ZonedDateTime buyTime;
    private final Asset asset;
    private final int quantity;

    public PlanCreationDto(ZonedDateTime sellTime, ZonedDateTime buyTime, Asset asset, int quantity) {
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
}
