package com.jumpstart.food_ordering_system.Response;
import lombok.Data;
import java.time.LocalDateTime;


@Data
public class Response<T> {

    private int statusCode;
    private T data;
    private final LocalDateTime TIMESTAMP = LocalDateTime.now();
    private String message;




}