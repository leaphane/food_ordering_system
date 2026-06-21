package com.jumpstart.food_ordering_system.controller;
import com.jumpstart.food_ordering_system.dto.CreateCategoryDTO;
import com.jumpstart.food_ordering_system.dto.Food_categoriesDTO;
import com.jumpstart.food_ordering_system.entity.Food_categories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.jumpstart.food_ordering_system.service.Food_orderingService;
import java.util.List;
import jakarta.validation.Valid;

// API layer. Handles HTTP requests and responses.
@RestController
@RequestMapping("/api/categories")
public class Food_orderingAPI {

    @Autowired
    private Food_orderingService service;

    @GetMapping("/{id}")
    public ResponseEntity<?> getFoodOrder(@PathVariable String id){

        Food_categoriesDTO food_category = service.food_order(Integer.parseInt(id));

        if( food_category!= null){

          return ResponseEntity.ok(food_category);
        }
        else return ResponseEntity.badRequest().body("Food id does not exist");

    }
    @GetMapping()
    public ResponseEntity<?> getAllFoodCategories(){

        List<Food_categories>  foodCategories = service.getAllCategories();

        return ResponseEntity.ok(foodCategories);

    }

   @PostMapping()
    public  ResponseEntity<?> createCategory(@Valid @RequestBody CreateCategoryDTO categoryDTO){

       if(service.createCategory(categoryDTO)){

           return ResponseEntity.status(201).build();

       }
       return ResponseEntity.badRequest().build();


   }

   @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable String id){

       if(service.deleteCategory(id)){

           return ResponseEntity.noContent().build();

       }
       return ResponseEntity.badRequest().build();

   }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable String id, @RequestBody @Valid CreateCategoryDTO categoryDTO){

        if(service.updateCategory(id,categoryDTO )){

            return ResponseEntity.ok().build();

        }
        return ResponseEntity.badRequest().build();

    }

}
