package com.example.Exceptions.repository;

import com.example.Exceptions.exceptions.ProductNotFoundException;
import com.example.Exceptions.model.Product;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public interface ProductRepository {
    Product findById(Long id) throws ProductNotFoundException;

    boolean existsById(Long id);

    void deleteById(Long id);

    List<Product> findAllByName(String name);

    Product save(Product updatedProduct);

    List<Product> findAll();

    boolean existsByName(@NotBlank String name);
}
