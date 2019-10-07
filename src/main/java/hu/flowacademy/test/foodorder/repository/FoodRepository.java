package hu.flowacademy.test.foodorder.repository;

import hu.flowacademy.test.foodorder.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {

    Optional<Food> findById(Long id);

}