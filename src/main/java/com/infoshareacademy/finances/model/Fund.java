package com.infoshareacademy.finances.model;

import java.util.List;

public class Fund {

    private List<DailyValue> DailyValue;
    private String fundName;
    private String fundCode;

    public Fund(List<DailyValue> DailyValue, String fundName, String fundCode) {

        this.DailyValue = DailyValue;
        this.fundName = fundName;
        this.fundCode = fundCode;
    }

    public List<com.infoshareacademy.finances.model.DailyValue> getDailyValue() {
        return DailyValue;
    }

    public void setDailyValue(List<com.infoshareacademy.finances.model.DailyValue> dailyValue) {
        DailyValue = dailyValue;
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
        return DailyValue + " - " + fundName + " - " + fundCode;
    }
}
