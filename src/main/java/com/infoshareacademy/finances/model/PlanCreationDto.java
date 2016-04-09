package com.infoshareacademy.finances.model;

import java.time.ZonedDateTime;

public class PlanCreationDto {
    private final ZonedDateTime sellTime;
    private final ZonedDateTime buyTime;
    private final Asset asset;

    public PlanCreationDto(ZonedDateTime sellTime, ZonedDateTime buyTime, Asset asset, int id) {
        this.sellTime = sellTime;
        this.buyTime = buyTime;
        this.asset = asset;
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

}
