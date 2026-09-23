package com.example.Exceptions.repository;

import com.example.Exceptions.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductSpringRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByName(String name);

    boolean existsByName(String name);
}
