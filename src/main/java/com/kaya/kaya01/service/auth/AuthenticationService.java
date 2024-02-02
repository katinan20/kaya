package com.kaya.kaya01.service.auth;

import com.kaya.kaya01.configuration.security.SecurityProperties;
import com.kaya.kaya01.security.auth.ApiKeyAuthentication;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationService {

    private static SecurityProperties securityProperties = new SecurityProperties();

    @Autowired
    public AuthenticationService(SecurityProperties securityProperties) {
        AuthenticationService.securityProperties = securityProperties;
    }

    public static ApiKeyAuthentication getAuthentication(HttpServletRequest request) {
        String apiKey = request.getHeader(securityProperties.getApiName());
        if (apiKey == null || !apiKey.equals(securityProperties.getApiKey())) {
            throw new BadCredentialsException("Invalid API Key");
        }

        return new ApiKeyAuthentication(apiKey, AuthorityUtils.NO_AUTHORITIES);
    }
}
