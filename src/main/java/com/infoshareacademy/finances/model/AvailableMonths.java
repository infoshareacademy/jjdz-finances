package com.infoshareacademy.finances.model;

import java.time.Month;
import java.util.List;

public class AvailableMonths {
    private Integer year;
    private List<Month> months;

    public AvailableMonths(Integer year, List<Month> months) {
        this.year = year;
        this.months = months;
    }

    public Integer getYear() {
        return year;

    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public List<Month> getMonths() {
        return months;
    }

    public void setMonths(List<Month> months) {
        this.months = months;
    }
}
