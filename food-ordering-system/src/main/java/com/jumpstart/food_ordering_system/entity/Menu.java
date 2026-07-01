package com.jumpstart.food_ordering_system.entity;

import jakarta.persistence.*;
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
    public Long id ;
    public String name;
    @Column(length = 1000)
    public String description;
    public BigDecimal price;
    public String imageUrl;
    @ManyToOne
    @JoinColumn(name = "category_id")
    public Food_categories category;



}
