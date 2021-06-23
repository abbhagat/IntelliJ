package org.retail.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ManageProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManageProductApplication.class, args);
    }

}
