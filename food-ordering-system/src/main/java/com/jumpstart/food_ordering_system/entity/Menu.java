package com.jumpstart.food_ordering_system.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "menus")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String name;
    @Column(length = 1000)
    private String description;
    private BigDecimal price;
    private String imageUrl;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Food_categories category;


    public Menu(String name, String description, BigDecimal price, String imageUrl) {

        this.name = name;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
    }
}
