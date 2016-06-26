package com.infoshareacademy.finances.model.dto;

public class FundStatsDTO {

    private final String assetName;
    private final Long assetId;
    private final Long sum;

    public FundStatsDTO(String assetName, Long assetId, Long sum) {
        this.assetName = assetName;
        this.assetId = assetId;
        this.sum = sum;
    }

    public String getAssetName() {
        return assetName;
    }

    public Long getAssetId() {
        return assetId;
    }

    public Long getSum() {
        return sum;
    }

    @Override
    public String toString() {
        return "FundStatsDTO{" +
                "assetName='" + assetName + '\'' +
                ", assetId=" + assetId +
                ", sum=" + sum +
                '}';
    }
}
