package com.example.Exceptions.controller;

import com.example.Exceptions.error.ErrorResponse;
import com.example.Exceptions.exceptions.DuplicateProductException;
import com.example.Exceptions.exceptions.InvalidProductPriceException;
import com.example.Exceptions.exceptions.ProductNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleProductNotFound(ProductNotFoundException exception, HttpServletRequest request) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(404, exception.getMessage(), request.getRequestURI()));
    }

    @ExceptionHandler(InvalidProductPriceException.class)
    public ResponseEntity<ErrorResponse> handleInvalidProductPriceException(InvalidProductPriceException exception, HttpServletRequest request) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(400, exception.getMessage(), request.getRequestURI()));
    }

    @ExceptionHandler(DuplicateProductException.class)
        public ResponseEntity<ErrorResponse> handleDuplicateProductException(DuplicateProductException exception, HttpServletRequest request) {
            return ResponseEntity
                    .status((HttpStatus.CONFLICT))
                    .body(new ErrorResponse(409, exception.getMessage(), request.getRequestURI()));
        }

    @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception, HttpServletRequest request) {
            return ResponseEntity
                    .status((HttpStatus.BAD_REQUEST))
                    .body(new ErrorResponse(400, exception.getMessage(), request.getRequestURI()));
        }
}
