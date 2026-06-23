package com.jumpstart.food_ordering_system.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
//custom exceptions because the built-in Java exceptions are usually too generic and don’t clearly
// describe your application’s business rules.
public class CategoryNotFoundException extends RuntimeException {


    public CategoryNotFoundException(String message) {
        super(message);
    }
}
