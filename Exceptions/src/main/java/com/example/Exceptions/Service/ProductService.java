package com.example.Exceptions.Service;

import com.example.Exceptions.Exceptions.InvalidProductPriceException;
import com.example.Exceptions.Exceptions.ProductNotFoundException;
import com.example.Exceptions.Repository.ProductRepository;
import com.example.Exceptions.model.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProductById(Long id) {
       return productRepository.findById(id)
               .orElseThrow(() -> new ProductNotFoundException("Product with " + id + " not found"));

    }

    public Product saveProduct(Product product) {
      if(product.getPrice() <= 0 ){
          throw new InvalidProductPriceException("Price must be greater than 0");
      }

      return productRepository.save(product);
    }
}
