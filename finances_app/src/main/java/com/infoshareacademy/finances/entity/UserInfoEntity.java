package com.infoshareacademy.finances.entity;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
public class UserInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Embedded
    private UserInfo userInfo;

    @Temporal(TemporalType.DATE)
    private Date date;

    public UserInfoEntity() {
    }

    public UserInfoEntity(Builder builder) {
        this.userInfo = builder.userInfo;
        this.date = builder.date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static Builder fromUserInfo(UserInfo userInfo) {
        return new Builder().withUserInfo(userInfo);
    }

    public static class Builder {
        private UserInfo userInfo;
        private Date date;

        public Builder withUserInfo(UserInfo userInfo) {
            this.userInfo = userInfo;
            return this;
        }

        public Builder withCurrentDate() {
            this.date = Calendar.getInstance().getTime();
            return this;
        }

        public Builder withDate(Date date) {
            this.date = date;
            return this;
        }

        public UserInfoEntity build(){
            return new UserInfoEntity(this);
        }


    }

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
