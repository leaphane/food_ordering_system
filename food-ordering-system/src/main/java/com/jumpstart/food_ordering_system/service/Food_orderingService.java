package com.jumpstart.food_ordering_system.service;
import com.jumpstart.food_ordering_system.dto.CreateCategoryDTO;
import com.jumpstart.food_ordering_system.dto.Food_categoriesDTO;
import com.jumpstart.food_ordering_system.entity.Food_categories;
import org.springframework.beans.factory.annotation.Autowired;
import com.jumpstart.food_ordering_system.repository.Food_orderingRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Food_orderingService {

    @Autowired
    private Food_orderingRepo repo;//Inject CategoryRepository

    public Food_categoriesDTO food_order(int id){

        if(repo.findById(id).isPresent()){ //check category of the given id

            Food_categories foodCategory = repo.findById(id).get();

            return  new Food_categoriesDTO( id, foodCategory.getName()); // return a new dto object with the id and name

        }
        else{
            return null; // return null if the id is not in the db
        }
    }

    public List<Food_categories> getAllCategories(){

        if(!repo.findAll().isEmpty()){
            return repo.findAll();// List of all food categories
        }
        else {
            return null; // return null if the list is empty

        }

    }

    public boolean createCategory(CreateCategoryDTO categoryDTO){

       try{

           repo.save(new Food_categories(categoryDTO.getName()));
           return true;

       }
       catch (Exception e) {
           return false;
       }

    }
    public boolean deleteCategory(String id){

        try{

            repo.deleteById(Integer.parseInt(id));
            return true;

        }
        catch (Exception e) {
            return false;
        }

    }


    public boolean updateCategory(String id, CreateCategoryDTO categoryDTO) {
        try {

            if (repo.findById(Integer.parseInt(id)).isPresent()) {

                Food_categories foodCategories = repo.findById(Integer.parseInt(id)).get();
                foodCategories.setName(categoryDTO.getName());
                repo.save(foodCategories);

                return true;
            }

            return false;// if the id does not exist

        } catch (Exception e) {

            return false;
        }
    }
}
