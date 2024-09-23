package com.junit.app.service;

import com.junit.app.model.Product;
import com.junit.app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productDAO;

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
}
