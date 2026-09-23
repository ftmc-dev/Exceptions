package com.example.Exceptions;

public class Exercise1 {

    public static void divide(int a, int b){
        if (b == 0) {
            throw new ArithmeticException("Cannot be zero");
        }
    }

    public static void readAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Invalid age");
        }
    }

    public static void main(String[] args) {

        try {
            divide(10, 0);

            readAge(-12);
        }
         catch(ArithmeticException e){
            System.out.println("Cannot be zero " + e);
        }
        catch (IllegalArgumentException e){
            System.out.println("Age cannot be negative " + e);
        }
        finally {
            System.out.println("Done");
        }
    }


}