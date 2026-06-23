package com.jumpstart.food_ordering_system.dto;
import jakarta.annotation.Nullable;
import jakarta.persistence.GeneratedValue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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

        @NotBlank(message = "Category name is required")
        @Size(min = 2, max = 50,
                message = "Name must be 2-50 characters")
        private String name;

}
