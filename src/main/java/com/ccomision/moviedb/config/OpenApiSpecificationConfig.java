package com.ccomision.moviedb.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiSpecificationConfig {

    @Bean
    public OpenAPI defineOpenApiSpec() {
        return new OpenAPI()
            .info(new Info()
            .title("MovieDB API")
            .version("1.0")
            .description("Movie Catalog that consumes TMDb API"));
    }
}
