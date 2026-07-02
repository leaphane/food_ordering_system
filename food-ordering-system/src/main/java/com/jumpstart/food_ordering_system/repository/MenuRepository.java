package com.jumpstart.food_ordering_system.repository;

import com.jumpstart.food_ordering_system.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MenuRepository extends JpaRepository<Menu, Long> {

    @Override
    Optional<Menu> findById(String name);
}

