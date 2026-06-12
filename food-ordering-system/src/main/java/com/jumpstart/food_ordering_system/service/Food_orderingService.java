package com.jumpstart.food_ordering_system.service;

import com.jumpstart.food_ordering_system.dto.Food_categoriesDTO;
import com.jumpstart.food_ordering_system.entity.Food_categories;
import org.springframework.beans.factory.annotation.Autowired;
import com.jumpstart.food_ordering_system.repository.Food_orderingRepo;
import org.springframework.stereotype.Service;

@Service
public class Food_orderingService {

    @Autowired
    private Food_orderingRepo repo;

    public Food_categoriesDTO food_order(int id){

        if(repo.findById(id).isPresent()){

            Food_categories foodCategory = repo.findById(id).get();

            return  new Food_categoriesDTO( id, foodCategory.getName());

        }
        else{
            return null;
        }
    }
}
