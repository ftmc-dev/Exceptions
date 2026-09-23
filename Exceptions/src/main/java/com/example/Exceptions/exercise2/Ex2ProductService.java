package com.example.Exceptions.exercise2;

import com.example.Exceptions.model.Product;

public class Ex2ProductService {
    private final Ex2ProductRepository productRepository;

    public Ex2ProductService(Ex2ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProductById(Long id) {
        System.out.println("Getting product by id from the service"+id);
        return productRepository.findById(id);
    }
}
