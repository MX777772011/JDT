package com.oauth.security.properties;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created on 2018/7/24 0024.
 *
 * @author szy
 * @email i@suntray.com
 * @since 1.0
 */
@Configuration
@EnableConfigurationProperties(OAuth2Properties.class)
public class OAuth2CoreConfig {
}
