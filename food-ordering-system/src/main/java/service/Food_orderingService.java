package service;

import entity.Food_categories;
import org.springframework.beans.factory.annotation.Autowired;
import repository.Food_orderingRepo;

public class Food_orderingService {

    @Autowired
    private Food_orderingRepo repo;

    @Autowired
    Food_categories categories;

    public Food_categories food_order(int id){

        if(repo.findById(id).isPresent()){

            categories = repo.findById(id).get();
            return  categories;

        }
        else{
            return null;
        }
    }
}
