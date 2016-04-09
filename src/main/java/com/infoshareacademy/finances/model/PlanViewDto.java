package com.infoshareacademy.finances.model;

import java.time.ZonedDateTime;

public class PlanViewDto {
    private final ZonedDateTime sellTime;
    private final ZonedDateTime buyTime;
    private final Asset asset;
    private final int id;

    public PlanViewDto(ZonedDateTime sellTime, ZonedDateTime buyTime, Asset asset, int id) {
        this.sellTime = sellTime;
        this.buyTime = buyTime;
        this.asset = asset;
        this.id = id;
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

    public int getId() {
        return id;
    }
}
