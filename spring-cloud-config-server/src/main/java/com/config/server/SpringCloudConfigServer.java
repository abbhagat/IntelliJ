package com.config.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.ConfigServerApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.core.env.Environment;

@SpringBootApplication
@EnableConfigServer
public class SpringCloudConfigServer implements CommandLineRunner {

    @Autowired
    private Environment env;

    public static void main(String[] args) {
        System.out.println("Before Command Line Runner ");
        SpringApplication.run(ConfigServerApplication.class, args);
        System.out.println("After Command Line Runner ");
    }

    @Override
    public void run(String[] args) {
        System.out.println("Git Details");
        System.out.println("URL " + env.getProperty("uri"));
        System.out.println("Username " + env.getProperty("username"));
        System.out.println("Password " + env.getProperty("password"));
    }

}
