package com.jumpstart.food_ordering_system.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Food_categoriesDTO {// dto class for carrying entity data between the service and API for request

        private int id;
        private String name;

}
