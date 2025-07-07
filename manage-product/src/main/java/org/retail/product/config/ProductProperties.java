package org.retail.product.config;

import lombok.Getter;
import lombok.Setter;
import org.retail.product.model.product.Product;
import org.springframework.boot.context.properties.ConfigurationProperties;
import java.util.List;

@Getter
@Setter
@ConfigurationProperties(prefix = "product")
public class ProductProperties {

    private List<Product> items;

}
