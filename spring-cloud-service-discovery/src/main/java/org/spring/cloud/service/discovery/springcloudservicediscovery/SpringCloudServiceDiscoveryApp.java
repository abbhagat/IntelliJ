package org.spring.cloud.service.discovery.springcloudservicediscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringCloudServiceDiscoveryApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudServiceDiscoveryApp.class, args);
    }

}
