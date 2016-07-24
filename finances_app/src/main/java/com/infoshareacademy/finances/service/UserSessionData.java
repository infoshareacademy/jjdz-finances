package com.infoshareacademy.finances.service;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.oauth.OAuth20Service;
import com.infoshareacademy.finances.entity.Privileges;
import com.infoshareacademy.finances.entity.UserInfo;

@SessionScoped
public class UserSessionData implements Serializable {
	private static final long serialVersionUID = 5029555108673491952L;

	private OAuth20Service service;
    private OAuth2AccessToken authToken;
    private UserInfo userInfo;
	private Privileges privileges;
	private String authType;
	private Long userId;

	public String getCsrf() {
		return csrf;
	}

	public void setCsrf(String csrf) {
		this.csrf = csrf;
	}

	private String csrf;

	public void createAuthToken(String code) {
		authToken = service.getAccessToken(code);
	}

	public OAuth2AccessToken getAuthToken() {
		return authToken;
	}

	public OAuth20Service getService() {
		return service;
	}

    public void setService(OAuth20Service service) {
        this.service = service;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

	public Privileges getPrivileges() {
		return privileges;
	}

	public void setPrivileges(Privileges privileges) {
		this.privileges = privileges;
	}

	public String getAuthType() {
		return authType;
	}

	public void setAuthType(String authType) {
		this.authType = authType;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserId() {
		return userId;
	}


}
