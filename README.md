# Java Exceptions

This repository contains my beginner-level practice on **Exception Handling in Java**.

## Objective

The goal of this practice is to understand how Java handles errors and unexpected situations during program execution.

I practiced:

* `try`
* `catch`
* `finally`
* `throw`
* `throws`
* Checked and unchecked exceptions
* Exception propagation
* Custom exceptions

## What I Learned

### 1. try / catch

`try` contains code that may cause an exception.

`catch` is used to handle the exception when it occurs.

try
   ↓
Code that may fail
   ↓
Exception?
   ↓
catch
   ↓
Handle the problem

### 2. finally

`finally` contains code that is executed after the `try`/`catch` block.

It is commonly used for cleanup operations.

### 3. throw

`throw` is used to **actually create and throw an exception**.

Example:

```java
if (age < 0) {
    throw new IllegalArgumentException("Age cannot be negative");
}
```

### 4. throws

`throws` is used in a method declaration to **declare that the method may throw an exception**.

It allows the exception to propagate to the method that called it.

throw  → actually throws the exception
throws → declares that the method may throw it

### 5. Exception Propagation

If a method throws an exception and does not handle it, the exception can move back through the methods that called it until it is handled.

method A
   ↓ calls
method B
   ↓ calls
method C
   ↓
exception
   ↑
propagates back
   ↑
method B
   ↑
method A
   ↓
catch

### 6. Custom Exceptions

I also learned how to create application-specific exceptions by extending `RuntimeException`.

For example:
java
public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String message) {
        super(message);
    }
}

This allows an application to describe specific business problems instead of relying only on generic exceptions.

## Exercises Practiced

* Division with `ArithmeticException`
* Validating an age with `IllegalArgumentException`
* Using `try/catch/finally`
* Using `throw`
* Using `throws`
* Observing exception propagation
* Creating custom exceptions
* Handling exceptions in Spring Boot with `@ExceptionHandler`
* Creating a global exception handler with `@RestControllerAdvice`

## Key Difference

The most important concept I learned is:

> **`throw` is used to throw an exception, while `throws` is used to declare that a method may throw an exception.**

