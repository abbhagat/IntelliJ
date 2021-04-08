package org.retail.supplier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ManageSupplier {

    public static void main(String[] args) {
        SpringApplication.run(ManageSupplier.class, args);
    }

}
