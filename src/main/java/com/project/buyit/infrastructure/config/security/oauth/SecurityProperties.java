package com.project.buyit.infrastructure.config.security.oauth;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("security")
public class SecurityProperties {

    private String clientId;
    private String clientSecret;
    private int expirationTime;
}

