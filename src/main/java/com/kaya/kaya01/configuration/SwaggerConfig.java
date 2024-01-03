package com.kaya.kaya01.configuration;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "Kaya REST API",
                description = "Kaya API documentation",
                summary = "Cette doc api va faire resortir create, deleteand update,  ",
                contact = @Contact(
                        name = "KaYa",
                        email = "kaya.@gmail.com"
                ),
                license = @License(
                        name = "Pas de licence pour l'instant"
                ),
                version = "V1"
        )
)
@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI();
        // Vous pouvez ajouter plus de configurations personnalisées ici si nécessaire.
    }

}
