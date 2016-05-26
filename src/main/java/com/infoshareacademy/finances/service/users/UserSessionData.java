package com.infoshareacademy.finances.service.users;

import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.oauth.OAuth20Service;
import com.infoshareacademy.finances.entity.Privileges;
import com.infoshareacademy.finances.model.UserInfo;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@SessionScoped
public class UserSessionData implements Serializable {

    private OAuth20Service service;
    private OAuth2AccessToken oAuthToken;
    private UserInfo userInfo;
	private Privileges privileges;

    public OAuth20Service getService() {
        return service;
    }

    public void setService(OAuth20Service service) {
        this.service = service;
    }

    public OAuth2AccessToken getOAuthToken() {
        return oAuthToken;
    }

    public void createOAuthToken(String code) {
        this.oAuthToken = service.getAccessToken(code);
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
}
