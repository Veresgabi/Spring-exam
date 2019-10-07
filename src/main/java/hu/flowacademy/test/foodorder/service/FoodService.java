package hu.flowacademy.test.foodorder.service;

import hu.flowacademy.test.foodorder.model.Food;
import hu.flowacademy.test.foodorder.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class FoodService {

    @Autowired
    FoodRepository foodRepository;

    public Food save(Food food) {
        return foodRepository.save(food);
    }

    public Optional<Food> findOne(Long id) {
        return foodRepository.findById(id);
    }

    // public List<Food> update(Food food) {
    // }

    // public List<Food> delete(Long id) {
    // }
}
