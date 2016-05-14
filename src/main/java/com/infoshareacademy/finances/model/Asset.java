package com.infoshareacademy.finances.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

public class Asset {

    private List<DailyValue> dailyValues;
    private String name;
    private String code;


    public Asset(List<DailyValue> dailyValues, String name, String code) {

        this.dailyValues = dailyValues;
        this.name = name;
        this.code = code;
    }

    public List<DailyValue> getDailyValues() {
        return dailyValues;
    }

    public void setDailyValues(List<DailyValue> dailyValues) {
        this.dailyValues = dailyValues;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return dailyValues + " - " + name + " - " + code;
    }
}
