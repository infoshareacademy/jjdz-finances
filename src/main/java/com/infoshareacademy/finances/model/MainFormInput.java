package com.infoshareacademy.finances.model;

import javax.persistence.*;
import java.time.Month;
import java.time.Year;

@Embeddable
public class MainFormInput {

    @ManyToOne
    private AssetEntity assetCode;

    private Month month;
    private Year year;

    @ManyToOne
    private UserInfoEntity userId;

    public MainFormInput() {
    }

    public MainFormInput(AssetEntity assetCode, Month month, Year year, UserInfoEntity userId) {
        this.assetCode = assetCode;
        this.month = month;
        this.year = year;
        this.userId = userId;
    }

    public UserInfoEntity getUserId() {
        return userId;
    }

    public void setUserId(UserInfoEntity userId) {
        this.userId = userId;
    }

    public AssetEntity getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(AssetEntity assetCode) {
        this.assetCode = assetCode;
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


}
