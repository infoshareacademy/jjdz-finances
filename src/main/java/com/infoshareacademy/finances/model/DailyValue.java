package com.infoshareacademy.finances.model;

import java.math.BigDecimal;

public class DailyValue {

    private String fundDate;
    private BigDecimal fundClose;

    public DailyValue(String fundDate, BigDecimal fundClose) {
        this.fundDate = fundDate;
        this.fundClose = fundClose;
    }

    public String getFundDate() {
        return fundDate;
    }

    public void setFundDate(String fundDate) {
        this.fundDate = fundDate;
    }

    public BigDecimal getFundClose() {
        return fundClose;
    }

    public void setFundClose(BigDecimal fundClose) {
        this.fundClose = fundClose;
    }

    @Override
    public String toString() {
        return fundDate + " - " + fundClose;
    }
}
