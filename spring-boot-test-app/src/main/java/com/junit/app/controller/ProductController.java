package com.junit.app.controller;

import com.junit.app.model.Product;
import com.junit.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping(value = "/getAllProducts", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }

    @GetMapping(value = "/getProductByID/{productID}", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Product getProductByID(@PathVariable Long productID) {
        return service.getProductByID(productID);
    }

    @PostMapping(value = "/saveProduct", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void saveProduct(@RequestBody Product product) {
        service.saveProduct(product);
    }

    @DeleteMapping(value = "/deleteProductByID/{productID}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteProductByID(@PathVariable Long productID) {
        service.deleteProductByID(productID);
    }
}
