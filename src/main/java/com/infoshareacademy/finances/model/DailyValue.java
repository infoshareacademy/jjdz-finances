package com.infoshareacademy.finances.model;

import java.math.BigDecimal;
import java.util.Date;

public class DailyValue {

    private String date;
    private BigDecimal closeValue;

    public DailyValue(String date, BigDecimal closeValue) {
        this.date = date;
        this.closeValue = closeValue;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public BigDecimal getCloseValue() {
        return closeValue;
    }

    public void setCloseValue(BigDecimal closeValue) {
        this.closeValue = closeValue;
    }

    @Override
    public String toString() {
        return date + " - " + closeValue;
    }
}
