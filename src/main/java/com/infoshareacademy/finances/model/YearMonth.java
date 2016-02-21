package com.infoshareacademy.finances.model;

import java.util.List;

public class YearMonth {
    private String year;
    private List<String> months;

    public YearMonth(String year, List<String> months) {
        this.year = year;
        this.months = months;
    }

    public String getYear() {
        return year;

    }

    public void setYear(String year) {
        this.year = year;
    }

    public List<String> getMonths() {
        return months;
    }

    public void setMonths(List<String> months) {
        this.months = months;
    }
}
