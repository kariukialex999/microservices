package org.kariioke.inventoryservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Configuration
public class OpenAPIConfig {
    
    private static final Logger logger = LoggerFactory.getLogger(OpenAPIConfig.class);

    @Bean
    public OpenAPI customOpenAPI() {
        logger.info("Initializing OpenAPI configuration");
        
        try {
            OpenAPI openAPI = new OpenAPI()
                    .info(new Info()
                            .title("Inventory Service API")
                            .version("1.0.0")
                            .description("REST API for managing inventory items and stock")
                            .contact(new Contact()
                                    .name("Inventory Service Team")
                                    .email("support@inventory.local")
                                    .url("http://localhost:8081"))
                            .license(new License()
                                    .name("Apache 2.0")
                                    .url("https://www.apache.org/licenses/LICENSE-2.0.html")))
                    .addServersItem(new Server()
                            .url("http://localhost:8081")
                            .description("Local Development Server"));
            
            logger.info("OpenAPI configuration initialized successfully");
            return openAPI;
        } catch (Exception e) {
            logger.error("Error initializing OpenAPI configuration", e);
            throw new RuntimeException("Failed to initialize OpenAPI configuration", e);
        }
    }
}

