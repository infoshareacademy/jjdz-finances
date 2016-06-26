package com.infoshareacademy.finances.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Asset {

    private String name;
    private String code;

    public Asset() {
    }

    public Asset(String name, String code) {
        this.name = name;
        this.code = code;
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
        return "Asset{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
