package com.infoshareacademy.finances.model;

import javax.persistence.*;
import java.time.Month;
import java.time.Year;

@Embeddable
public class MainFormInput {

    @Enumerated(EnumType.STRING)
    private AssetType type;

    private String assetCode;
    private Month month;
    private Year year;
    private Long userId;

    public MainFormInput() {
    }

    public MainFormInput(AssetType type, String assetCode, Month month, Year year, Long userId) {
        this.type = type;
        this.assetCode = assetCode;
        this.month = month;
        this.year = year;
        this.userId = userId;
    }


    public AssetType getType() {
        return type;
    }

    public void setType(AssetType type) {
        this.type = type;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long user) {
        this.userId = user;
    }

    public String getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(String assetName) {
        this.assetCode = assetName;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    enum AssetType {
        CURRENCY, FUND
    }
}
