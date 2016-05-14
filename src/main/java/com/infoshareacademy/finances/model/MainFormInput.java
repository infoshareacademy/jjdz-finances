package com.infoshareacademy.finances.model;

import javax.persistence.*;
import java.time.Month;
import java.time.Year;

@Embeddable
public class MainFormInput {

    @Enumerated(EnumType.STRING)
    private AssetType type;

    private String assetName;
    private Month month;
    private Year year;
    private String user;

    public MainFormInput() {
    }

    public MainFormInput(AssetType type, String assetName, Month month, Year year, String user) {
        this.type = type;
        this.assetName = assetName;
        this.month = month;
        this.year = year;
        this.user = user;
    }


    public AssetType getType() {
        return type;
    }

    public void setType(AssetType type) {
        this.type = type;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
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
