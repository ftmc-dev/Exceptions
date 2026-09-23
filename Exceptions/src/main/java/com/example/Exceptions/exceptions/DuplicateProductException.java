package com.example.Exceptions.exceptions;

public class DuplicateProductException extends RuntimeException{

    public DuplicateProductException(String message){
        super(message);
    }
}
