package com.infoshareacademy.finances.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DailyValue {

    private LocalDate date;
    private BigDecimal closeValue;

    public DailyValue(LocalDate date, BigDecimal closeValue) {
        this.date = date;
        this.closeValue = closeValue;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
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
