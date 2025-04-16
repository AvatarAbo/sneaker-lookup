package com.example.sneakerlookup;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Allow all endpoints
                .allowedOrigins("http://localhost:3000") // Allow requests from React on localhost:3000
                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS") // Allow specific methods
                .allowedHeaders("*") // Allow all headers
                .allowCredentials(true); // Allow cookies and other credentials
    }
}

