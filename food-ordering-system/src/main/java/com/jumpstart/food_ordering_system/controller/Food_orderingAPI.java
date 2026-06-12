package com.jumpstart.food_ordering_system.controller;
import com.jumpstart.food_ordering_system.dto.Food_categoriesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.jumpstart.food_ordering_system.service.Food_orderingService;

@RestController
@RequestMapping("/api/category")
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

}
