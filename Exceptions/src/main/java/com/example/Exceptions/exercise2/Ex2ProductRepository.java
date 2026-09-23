package com.example.Exceptions.exercise2;

import com.example.Exceptions.exceptions.ProductNotFoundException;
import com.example.Exceptions.model.Product;

import java.util.HashMap;
import java.util.Map;

public class Ex2ProductRepository {
    Map<Long, Product> Products = new HashMap<>();
    public Product findById(Long id){
        if(!Products.containsKey(id)){
            System.out.println("Getting product with id " + id);
            throw new ProductNotFoundException("Product with id "+id+" not found");
        }
        return Products.get(id);
    }
}
