package com.kaya.kaya01.configuration.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "application.security")
public class SecurityProperties {

    private String apiKey;
    private String apiName;

}

