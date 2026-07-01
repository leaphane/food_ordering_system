package com.jumpstart.food_ordering_system.controller;
import com.jumpstart.food_ordering_system.response.Response;
import com.jumpstart.food_ordering_system.dto.CreateCategoryDTO;
import com.jumpstart.food_ordering_system.dto.Food_categoriesDTO;
import com.jumpstart.food_ordering_system.entity.Food_categories;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Response<Food_categoriesDTO> getFoodOrder(@PathVariable String id){

        Food_categoriesDTO food_category = service.food_order(Integer.parseInt(id));

        return Response.success( "Success",food_category);

        //else return ResponseEntity.badRequest().body("Food id does not exist");

    }
    @GetMapping()
    public Response<List<Food_categories>> getAllFoodCategories(){

        List<Food_categories>  foodCategories = service.getAllCategories();

        return Response.success("List of categories",foodCategories);

    }

   @PostMapping()
    public  Response<?> createCategory(@Valid @RequestBody CreateCategoryDTO categoryDTO){

       if(service.createCategory(categoryDTO)){//201 code?

           return Response.success("Category created",null);

       }
       return Response.error(400, "Invalid inputs");


   }

   @DeleteMapping("/{id}")
    public Response<?> deleteCategory(@PathVariable String id){

       if(service.deleteCategory(id)){

           return Response.success("Category deleted",null);

       }
       return Response.error(400, "Invalid category id");

   }
    @PutMapping("/{id}")
    public Response<CreateCategoryDTO> updateCategory(@PathVariable String id, @RequestBody @Valid CreateCategoryDTO categoryDTO){

        if(service.updateCategory(id,categoryDTO )){

            return Response.success("Category updated",new CreateCategoryDTO() );

        }
        return Response.error(400, "Bad request");

    }

}
