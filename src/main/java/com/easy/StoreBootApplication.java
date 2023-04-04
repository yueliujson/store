package com.easy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

//SpringBoot启动类

@SpringBootApplication
@ComponentScan("com")
@ServletComponentScan({"com.easy.filter"})
public class StoreBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(StoreBootApplication.class, args);
    }
}
