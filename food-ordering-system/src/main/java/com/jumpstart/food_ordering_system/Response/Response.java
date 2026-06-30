package com.jumpstart.food_ordering_system.Response;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Response<T> {

    private int statusCode;
    private T data;
    @Builder.Default
    private final LocalDateTime TIMESTAMP = LocalDateTime.now();
    private String message;


    public static <T> Response<T> success(String message, T data) {
        return Response.<T>builder()
                .statusCode(200).message(message).data(data).build();
    }

    public static <T> Response<T> error(int code, String message) {
        return Response.<T>builder()
                .statusCode(code).message(message).build();
    }



}