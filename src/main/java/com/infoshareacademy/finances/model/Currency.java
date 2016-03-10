package com.infoshareacademy.finances.model;

import java.util.List;

public class Currency {
    public Currency(List<DailyValue> dailyCurrencyValue, String currencyName, String currencyCode) {
        this.dailyCarrencyValue = dailyCurrencyValue;
        this.currencyName = currencyName;
        this.currencyCode = currencyCode;
    }

    public List<DailyValue> getDailyCarrencyValue() {
        return dailyCarrencyValue;
    }

    public void setDailyCarrencyValue(List<DailyValue> dailyCarrencyValue) {
        this.dailyCarrencyValue = dailyCarrencyValue;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    @Override
    public String toString() {
        return "Currency[dailyCarrencyValue=" + dailyCarrencyValue + ", currencyName=" + currencyName
                + ", currencyCode=" + currencyCode + "] ";
    }

    private List<DailyValue> dailyCarrencyValue;
    private String currencyName;
    private String currencyCode;
}