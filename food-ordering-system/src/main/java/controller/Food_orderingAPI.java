package controller;

import entity.Food_categories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.Food_orderingService;

@RestController
public class Food_orderingAPI {

    @Autowired
    private Food_orderingService service;

    @GetMapping("")
    public ResponseEntity<?> getFoodOrder(@PathVariable String id){

        Food_categories food_category = service.food_order(Integer.parseInt(id));

        if( food_category!= null){
          return ResponseEntity.ok(food_category);
        }
        else return ResponseEntity.badRequest().body("Food id does not exist");

    }
}
