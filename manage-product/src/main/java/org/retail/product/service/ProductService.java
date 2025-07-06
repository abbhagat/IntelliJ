package org.retail.product.service;

import org.retail.product.model.product.Product;
import org.retail.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productDAO;

    @Autowired
    private Environment env;

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

    public ResponseEntity<?> getEnvConfig() {
        String eureka = env.getProperty("eureka.client.fetch-registry");
        String dynamicProp = env.getProperty("dynamic.prop");
        System.out.println(dynamicProp + "\t" +  eureka);
        return  ResponseEntity.ok().body(dynamicProp + "\t" +  eureka);
    }
}
