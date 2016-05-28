package com.infoshareacademy.finances.model;


public class FundStatsDTO {

    //private final D
    private final Asset asset;
    private final Long count;

    public FundStatsDTO(Long count, Asset asset) {
        this.asset = asset;
        this.count = count;
    }

    public Asset getAsset() {
        return asset;
    }

    public Long getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "FundStatsDTO{" +
                "asset=" + asset +
                ", count=" + count +
                '}';
    }
}
