package com.easy.configurer;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 跨越问题
 */
@Configuration
public class CorsConfigurer implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").
                allowedOriginPatterns("*").
                allowCredentials(true).
                allowedMethods("GET","POST","PUT","DELETE").
                allowedHeaders("*").maxAge(3600);
    }
}
