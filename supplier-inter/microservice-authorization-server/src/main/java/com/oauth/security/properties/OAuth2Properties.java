package com.oauth.security.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created on 2018/7/24 0024.
 *
 * @author szy
 * @email i@suntray.com
 * @since 1.0
 */
@Data
@ConfigurationProperties(prefix = "suntray.security.oauth2")
public class OAuth2Properties {

    private String jwtSigningKey = "suntray";

    public String getJwtSigningKey() {
		return jwtSigningKey;
	}

	public void setJwtSigningKey(String jwtSigningKey) {
		this.jwtSigningKey = jwtSigningKey;
	}

	public OAuth2ClientProperties[] getClients() {
		return clients;
	}

	public void setClients(OAuth2ClientProperties[] clients) {
		this.clients = clients;
	}

	private OAuth2ClientProperties[] clients = {};
}
