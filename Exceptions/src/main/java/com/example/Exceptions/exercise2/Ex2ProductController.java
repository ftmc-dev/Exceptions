package com.example.Exceptions.exercise2;

import com.example.Exceptions.model.Product;

public class Ex2ProductController {
    private Ex2ProductService productService;

    public void setProductService(Ex2ProductService productService){
        this.productService = productService;
    }

    public Product handle(Long id){
        try{
            return productService.getProductById(id);
        }
        catch(Exception e){
            System.out.println("Controller caught "+ e.getClass().getSimpleName() + " -> " + e.getMessage());
            return null;
        }
    }
}
