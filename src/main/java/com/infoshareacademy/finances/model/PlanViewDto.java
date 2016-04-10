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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlanViewDto that = (PlanViewDto) o;

        if (getId() != that.getId()) return false;
        if (!getSellTime().equals(that.getSellTime())) return false;
        if (!getBuyTime().equals(that.getBuyTime())) return false;
        return getAsset().equals(that.getAsset());

    }

    @Override
    public int hashCode() {
        int result = getSellTime().hashCode();
        result = 31 * result + getBuyTime().hashCode();
        result = 31 * result + getAsset().hashCode();
        result = 31 * result + getId();
        return result;
    }
}
