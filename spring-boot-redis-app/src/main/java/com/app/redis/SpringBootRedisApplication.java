package com.app.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ConfigurationPropertiesScan
@EnableScheduling
public class SpringBootRedisApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringBootRedisApplication.class, args);
  }

}
