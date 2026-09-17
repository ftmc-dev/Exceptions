package com.example.Exceptions.Exceptions;

public class InvalidProductPriceException extends RuntimeException{

    public InvalidProductPriceException(String message){
        super(message);
    }
}
