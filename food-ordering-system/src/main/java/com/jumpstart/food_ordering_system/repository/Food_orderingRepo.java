package com.jumpstart.food_ordering_system.repository;

import com.jumpstart.food_ordering_system.entity.Food_categories;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

import java.util.Optional;

// for CRUD operations
public interface Food_orderingRepo  extends JpaRepository<Food_categories, Long> {
    Optional<Food_categories> findById(int Id);
    List<Food_categories> findAll();

}
