package org.spring.aop.config;

import org.spring.aop.shape.Triangle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public Triangle getTriangle() {
        return new Triangle("Equilateral Triangle");
    }
}
