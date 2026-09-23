package com.example.Exceptions.exceptions;

public class InvalidProductPriceException extends RuntimeException{

    public InvalidProductPriceException(String message){
        super(message);
    }
}
