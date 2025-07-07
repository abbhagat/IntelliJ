package org.retail.product;

import org.retail.product.config.ProductProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ProductProperties.class)
public class ManageProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManageProductApplication.class, args);
    }

}
