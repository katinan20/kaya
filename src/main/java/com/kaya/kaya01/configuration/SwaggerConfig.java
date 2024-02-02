package com.kaya.kaya01.configuration;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Kaya REST API",
                description = "Kaya API documentation",
                version = "0.3.1",
                contact = @Contact(
                        name = "KaYa",
                        email = "kaya.@gmail.com"
                ),
                license = @License(
                        name = "Pas de licence pour l'instant"
                )
        )
)
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        ApiResponse unauthorizedResponse = new ApiResponse()
                .description("Unauthorized - Invalid API key")
                .content(new Content().addMediaType("application/json", new MediaType()));

        ApiResponse forbiddenResponse = new ApiResponse()
                .description("Forbidden - Insufficient permissions")
                .content(new Content().addMediaType("application/json", new MediaType()));

        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("apiKey", new SecurityScheme()
                                .type(SecurityScheme.Type.APIKEY)
                                .name("X-API-KEY")
                                .in(SecurityScheme.In.HEADER)
                        )
                )
                .addSecurityItem(new SecurityRequirement().addList("apiKey"))
                .extensions(Map.of("401", unauthorizedResponse, "403", forbiddenResponse));
    }
}

