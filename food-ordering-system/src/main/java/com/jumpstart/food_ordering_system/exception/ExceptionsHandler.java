package com.jumpstart.food_ordering_system.exception;
import com.jumpstart.food_ordering_system.response.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class ExceptionsHandler {

     @ExceptionHandler(CategoryNotFoundException.class)
    public Response<String> categoryNotFound(CategoryNotFoundException ex){

        return Response.error(404, ex.getMessage());// gets the message thrown by the specific exception from the service and returns it with a not found

    }
    @ExceptionHandler(ConflictException.class)
    public Response<String> conflictingCategory(ConflictException ex){
         return Response.error(409, ex.getMessage());
    }

}
