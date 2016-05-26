package com.infoshareacademy.finances.model;

public class LstList {

    private String name;
    private String code;

    @Override
    public String toString() {
        return "LstList{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

    public LstList(String name, String code) {
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


}
