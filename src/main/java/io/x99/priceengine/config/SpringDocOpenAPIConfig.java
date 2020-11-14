package io.x99.priceengine.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocOpenAPIConfig {
    @Value("${spring.application.version}")
    private String appVersion;

    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
                .info(new Info()
                        .title("99x Price Engine API Specification")
                        .version(appVersion)
                        .description("99x Price Engine API Specification")
                        .license(new License()
                                .name("Copyright 2020 99x. All rights reserved")
                                .url("https://99x.io")
                        )
                );
    }
}
