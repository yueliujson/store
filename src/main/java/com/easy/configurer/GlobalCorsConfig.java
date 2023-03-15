//package com.easy.configurer;
////
////import org.springframework.context.annotation.Bean;
////import org.springframework.context.annotation.Configuration;
////import org.springframework.web.cors.CorsConfiguration;
////import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
////import org.springframework.web.filter.CorsFilter;
////
////@Configuration
////public class GlobalCorsConfig {
////    @Bean
////    public CorsFilter corsFilter() {
//////1.添加ORS配置信息
////        CorsConfiguration config = new CorsConfiguration();
//////1) 允许的域，不要写*， 否则cookie就无法使用了
////        config.addAllowedOrigin("http://192.168.110.120/");
//////2)是否发送Cookie信息
////        config.setAllowCredentials(true);
//////3)允许的请求方式
////        config.addAllowedMethod("OPTIONS");
////        config.addAllowedMethod("HEAD");
////        config.addAllowedMethod("GET");
////        config.addAllowedMethod("PUT");
////        config.addAllowedMethod("POST");
////        config.addAllowedMethod("DELETE");
////        config.addAllowedMethod("PATCH");
////// 4)允许的头信息
////        config.addAllowedHeader("*");
////        UrlBasedCorsConfigurationSource configSource = new
////                UrlBasedCorsConfigurationSource();
////        configSource.registerCorsConfiguration("/**", config);
//////3. 返回新的CorsFilter.
////        return new CorsFilter(configSource);
////    }
////}
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import org.springframework.web.filter.CorsFilter;
//
///**
// * 全局跨域配置
// * Created by macro on 2019/7/27.
// */
//@Configuration
//public class GlobalCorsConfig {
//
//    /**
//     * 允许跨域调用的过滤器
//     */
//    @Bean
//    public CorsFilter corsFilter() {
//        CorsConfiguration config = new CorsConfiguration();
//        //允许所有域名进行跨域调用
//        config.addAllowedOriginPattern("");
//        //允许跨越发送cookie
//        config.setAllowCredentials(true);
//        //放行全部原始头信息
//        config.addAllowedHeader("*");
//        //允许所有请求方法跨域调用
//        config.addAllowedMethod("*");
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", config);
//        return new CorsFilter(source);
//    }
//}