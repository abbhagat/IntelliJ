package org.retail.product.service;

import lombok.AllArgsConstructor;
import org.retail.product.config.ProductProperties;
import org.retail.product.model.product.Product;
import org.retail.product.repository.ProductRepository;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productDAO;
    private final Environment env;
    private final ProductProperties productProperties;

    public List<Product> getAllProducts() {
        return productDAO.findAll();
    }

    public Product getProductByID(Long productID) {
        return productDAO.getOne(productID);
    }

    public Product saveProduct(Product product) {
        return productDAO.save(product);
    }

    public void deleteProductByID(Long productID) {
        productDAO.deleteById(productID);
    }

    public ResponseEntity<?> getProductProperties() {
        String eureka = env.getProperty("eureka.client.fetch-registry");
        String dynamicProp = env.getProperty("dynamic.prop");
        System.out.println(dynamicProp + "\t" +  eureka);
        System.out.println("Product Info From Yaml Config : " + productProperties.getItems());
        return  ResponseEntity.ok().body(dynamicProp + "\t" +  eureka + "\t" +  productProperties.getItems());
    }
}
