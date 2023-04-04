package com.easy.configurer;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//解决跨域问题配置类
@Configuration
public class CorsConfigurer implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").
                allowedOriginPatterns("*").
                allowCredentials(true).
                allowedMethods("GET","POST","OPTIONS","PUT","DELETE").
                allowedHeaders("*").maxAge(3600);
    }
}
