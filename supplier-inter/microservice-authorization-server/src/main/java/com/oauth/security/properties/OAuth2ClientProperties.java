package com.oauth.security.properties;

import lombok.Data;

/**
 * Created on 2018/7/24 0024.
 *
 * @author szy
 * @email i@suntray.com
 * @since 1.0
 */
@Data
public class OAuth2ClientProperties {

    public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public Integer getAccessTokenValiditySeconds() {
		return accessTokenValiditySeconds;
	}

	public void setAccessTokenValiditySeconds(Integer accessTokenValiditySeconds) {
		this.accessTokenValiditySeconds = accessTokenValiditySeconds;
	}

	private String clientId;

    private String clientSecret;

    private Integer accessTokenValiditySeconds = 7200;
}
