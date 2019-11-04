package hu.flowacademy.test.foodorder.service;

import hu.flowacademy.test.foodorder.exception.ValidationException;
import hu.flowacademy.test.foodorder.model.Cart;
import hu.flowacademy.test.foodorder.model.Food;
import hu.flowacademy.test.foodorder.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

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

    public Food update(Long id, Food food) {
        Food modifiedFood =  findOne(id).orElseThrow(() -> new ValidationException(HttpStatus.BAD_REQUEST, "Cart not found"));
        modifiedFood.setCarts(food.getCarts());
        modifiedFood.setName(food.getName());
        modifiedFood.setParts(food.getParts());

        foodRepository.save(modifiedFood);

        return modifiedFood;
    }

    public void delete(Long id) {
        Food deletedFood = findOne(id).orElseThrow(() -> new ValidationException(HttpStatus.BAD_REQUEST, "Food not found"));
        foodRepository.delete(deletedFood);
    }
}
