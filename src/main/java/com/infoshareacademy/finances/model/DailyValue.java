package com.infoshareacademy.finances.model;

import java.math.BigDecimal;

public class DailyValue {

    private String fundDate;
    private BigDecimal fundClose;

    public DailyValue(String fundDate, BigDecimal fundClose) {
        this.fundDate = fundDate;
        this.fundClose = fundClose;
    }
}
