package repository;

import entity.Food_categories;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface Food_orderingRepo  extends JpaRepository<Food_categories, Long> {

    Optional<Food_categories> findById(int Id);


}
