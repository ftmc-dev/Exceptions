package com.example.Exceptions.Service;

import com.example.Exceptions.exceptions.DuplicateProductException;
import com.example.Exceptions.exceptions.InvalidProductPriceException;
import com.example.Exceptions.exceptions.ProductNotFoundException;
import com.example.Exceptions.repository.ProductRepository;
import com.example.Exceptions.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product getProductById(Long id) throws ProductNotFoundException {
       return productRepository.findById(id);
    }

    public Product saveProduct(Product product) {
        if(product.getPrice() <= 0){
            throw new InvalidProductPriceException("Price must be greater than 0");
        }

        if(productRepository.existsByName(product.getName())){
            throw new DuplicateProductException("Product with name " + product.getName() + " already exists");
        }
      return productRepository.save(product);
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product updateProduct(Product product, Long id) {
        if(product.getPrice() <= 0){
            throw new InvalidProductPriceException("Price must be greater than 0");
        }

        if(productRepository.existsById(id)){
            Product updatedProduct = productRepository.findById(id);
            updatedProduct.setName(product.getName());
            updatedProduct.setPrice(product.getPrice());
            updatedProduct.setDescription(product.getDescription());

            return productRepository.save(updatedProduct);
        }
        throw new ProductNotFoundException("Product with not found");
        }

    public Product deleteById(Long id){
        Product product = productRepository.findById(id);
            productRepository.deleteById(id);
        return product;
    }

    public List<Product> getProductByName(String name) {
        return productRepository.findAllByName(name);
    }
}
