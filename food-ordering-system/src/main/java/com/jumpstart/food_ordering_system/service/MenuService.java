package com.jumpstart.food_ordering_system.service;

import com.jumpstart.food_ordering_system.dto.MenuDto;
import com.jumpstart.food_ordering_system.entity.Menu;
import com.jumpstart.food_ordering_system.exception.ConflictException;
import com.jumpstart.food_ordering_system.repository.MenuRepository;
import com.jumpstart.food_ordering_system.response.Response;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MenuService {

    @Autowired
    private MenuRepository menuRepo ;

    public boolean createMenu(MenuDto dto){

        if(menuRepo.findById(dto.getName()).isPresent()){

            throw new ConflictException("Name already exist");

        }
        menuRepo.save(new Menu(dto.getName(), dto.getDescription(), dto.getPrice(), dto.getImageUrl()));
        return true;
    }
    public List<Menu> getAllMenus(){

        return menuRepo.findAll();
    }
    public MenuDto getMenuById(Long id){

        if(menuRepo.findById(id).isPresent()){

            Menu menu = menuRepo.findById(id).get();
            return new MenuDto(menu.getName(), menu.getDescription(), menu.getPrice(), menu.getImageUrl())
        }
    }
}
