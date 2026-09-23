package com.example.Exceptions;

import com.example.Exceptions.Service.ProductService;
import com.example.Exceptions.exceptions.ProductNotFoundException;
import com.example.Exceptions.model.Product;
import com.example.Exceptions.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindByIdTest{

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductService productService;

    @Test
    public void findByIdFailedTest(){
        //Given
        Long id = 1L;
        when(productRepository.findById(id)).thenThrow(ProductNotFoundException.class);

        //Then
        assertThrows(ProductNotFoundException.class, ()->{
            productService.getProductById(1L);
                });
        verify(productRepository).findById(id);
    }

    @Test
    public void findByIdTestSuccess(){
        //Given
        Product product = new Product();

        Long id = 1L;
        when(productRepository.findById(id)).thenReturn(product);

        //When
        Product result = productService.getProductById(1L);

        //Then
        assertThat(result).isEqualTo(product);
        verify(productRepository).findById(id);

    }


}
