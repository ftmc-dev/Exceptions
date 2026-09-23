package com.example.Exceptions.repository.impl;

import com.example.Exceptions.exceptions.ProductNotFoundException;
import com.example.Exceptions.repository.ProductSpringRepository;
import com.example.Exceptions.repository.ProductRepository;
import com.example.Exceptions.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductJpaRepository implements ProductRepository {
    private final ProductSpringRepository productSpringRepository;

    @Override
    public Product findById(Long id) throws ProductNotFoundException {
        return productSpringRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found"));
    }

    @Override
    public boolean existsById(Long id) throws ProductNotFoundException {
        return productSpringRepository.existsById(id);
    }

    @Override
    public void deleteById(Long id) {
        if(productSpringRepository.existsById(id)) {
            productSpringRepository.deleteById(id);
        }
        throw new ProductNotFoundException("Product not found");
    }

    @Override
    public List<Product> findAllByName(String name) {
        return productSpringRepository.findAllByName(name);
    }

    @Override
    public Product save(Product updatedProduct) {
        return productSpringRepository.save(updatedProduct);
    }

    @Override
    public List<Product> findAll() {
        return productSpringRepository.findAll();
    }

    @Override
    public boolean existsByName(String name) {
        return productSpringRepository.existsByName(name);
    }
}
