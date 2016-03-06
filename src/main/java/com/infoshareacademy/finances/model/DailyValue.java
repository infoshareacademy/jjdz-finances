package com.infoshareacademy.finances.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Date;

public class DailyValue {

    private ZonedDateTime date;
    private BigDecimal closeValue;

    public DailyValue(ZonedDateTime date, BigDecimal closeValue) {
        this.date = date;
        this.closeValue = closeValue;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public void setDate(ZonedDateTime date) {
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
