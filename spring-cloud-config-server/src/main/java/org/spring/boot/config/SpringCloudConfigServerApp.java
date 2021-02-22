package org.spring.boot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.core.env.Environment;

/**
 * All the properties can be accessed by the below URL
 * http://localhost:8888/spring-cloud-config-server/default
 */
@SpringBootApplication
@EnableConfigServer
public class SpringCloudConfigServerApp implements CommandLineRunner {

    @Autowired
    private Environment env;

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigServerApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Git Details");
        System.out.println("URI :- " + env.getProperty("uri"));
        System.out.println("Username :- " + env.getProperty("username"));
        System.out.println("Password :- " + env.getProperty("password"));
    }
}
