package com.metro.one.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI api(){
        return new OpenAPI().info(new Info().title("Spring Metro API Documentation")
                        .description("Spring Metro REST API")
                        .version("v3.0.1")
                        .license(new License().name("Apache 2.0").url("https://spring.io")))
                .externalDocs(new ExternalDocumentation()
                        .description("Spring Metro Proyect Documentation")
                        .url("https://github.com/swagerich/"));
    }
}
