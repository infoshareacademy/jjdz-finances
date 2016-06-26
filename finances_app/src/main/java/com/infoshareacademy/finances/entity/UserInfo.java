package com.infoshareacademy.finances.entity;

import javax.persistence.Embeddable;

@Embeddable
public class UserInfo {

    private String name;
    private String mail;

    public UserInfo() {
    }

    public UserInfo(String name, String mail) {
        this.name = name;
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
