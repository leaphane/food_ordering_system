## Q1. What is a Java generic type? Why is <T> useful?
> *Answer: It's a method or class that allows us to specify a type like a parameter*

## Q2. What does Lombok @Builder generate behind the scenes?
> *Answer: It generates a builder class and methods used to construct objects of the original class*

## Q3. What is the Builder design pattern? When to use it?
> *Answer: is a way of constructing objects using a builder class instead of a long constructor. It allows an object to be created step by step. It is normally used when a class has many fields,
> especially optional ones, to make object creation clearer and easier to read.*

## Q4. What is LocalDateTime? How is it different from Date?
> *Answer: LocalDateTime is a class in Java’s java.time API that represents both date and time without a time zone. It provides methods like now() to get the current date and time.
It is different from Date because LocalDateTime is part of the modern Java time API (Java 8+), which is more readable, immutable, and easier to use, while Date is older, less flexible, and includes legacy design issues.*

## Q5. Why does a consistent response format matter to frontend developers?
> *Answer: A consistent response format matters to frontend developers because it ensures they always know what structure to expect from the API. 
> This avoids the need for complex type casting and multiple conditional checks to handle different response formats , making frontend code simpler, cleaner, and easier to maintain.*

## Q6. What does @JsonInclude(JsonInclude.Include.NON_NULL) do?
> *Answer: tells Jackson (the JSON serializer) to exclude fields with null values when converting a Java object to JSON.*

## Q7. What is a static factory method? Why use Response.success(...) instead of new Response<>()?
> *Answer: A static factory method is a static method that is used to create and return objects. Unlike normal static methods, its main purpose is object creation instead of performing general logic.
We use Response.success(...) instead of new Response<>() because it improves readability, hides object creation logic, and allows more control over how objects are created (for example, setting default values or formatting responses consistently).