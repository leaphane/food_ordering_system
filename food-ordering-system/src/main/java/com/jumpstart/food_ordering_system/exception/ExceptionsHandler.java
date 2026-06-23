package com.jumpstart.food_ordering_system.exception;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class ExceptionsHandler {

     @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<String> categoryNotFound(CategoryNotFoundException ex){

        return ResponseEntity.status(404).body(ex.getMessage());// gets the message thrown by the specific exception from the service and returns it with a not found

    }

}
