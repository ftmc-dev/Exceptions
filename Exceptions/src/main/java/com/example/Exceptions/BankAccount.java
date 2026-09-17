package com.example.Exceptions;

public class BankAccount extends RuntimeException{
    public double balance;

    public void deposit(double balance) {
        this.balance = balance;
    }

    public void withdraw(double balance) {
        this.balance = balance;
    }

    public static void main(String[] args) {
        try{
            int deposit = 0;

            if(deposit <= 0){
                System.out.println("Deposit amount must be greater than 0.");
            }
        }

        catch (InvalidAmountException e){
            System.out.println(e);
        }

    }
}
