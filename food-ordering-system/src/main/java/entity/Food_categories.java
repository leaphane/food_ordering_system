package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Food_categories {

    @Id
    @GeneratedValue
    public int id;

    @Column(nullable = false)// cannot have the food ordered name as null
    public String name;

}
