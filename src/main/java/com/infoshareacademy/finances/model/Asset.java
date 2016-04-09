package com.infoshareacademy.finances.model;

import java.util.List;

public class Asset {

    private List<DailyValue> dailyValues;
    private String fundName;
    private String fundCode;

    public Asset(List<DailyValue> dailyValues, String fundName, String fundCode) {

        this.dailyValues = dailyValues;
        this.fundName = fundName;
        this.fundCode = fundCode;
    }

    public List<DailyValue> getDailyValues() {
        return dailyValues;
    }

    public void setDailyValues(List<DailyValue> dailyValues) {
        this.dailyValues = dailyValues;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public String getFundCode() {
        return fundCode;
    }

    public void setFundCode(String fundCode) {
        this.fundCode = fundCode;
    }

    @Override
    public String toString() {
        return dailyValues + " - " + fundName + " - " + fundCode;
    }
}
