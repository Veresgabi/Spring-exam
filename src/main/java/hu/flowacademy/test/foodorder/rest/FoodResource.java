package hu.flowacademy.test.foodorder.rest;

import hu.flowacademy.test.foodorder.model.Cart;
import hu.flowacademy.test.foodorder.model.Food;
import hu.flowacademy.test.foodorder.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/food")
public class FoodResource {

    @Autowired
    FoodService foodService;

    @PostMapping("/create")
    public Food save (@RequestBody Food food) {
        return foodService.save(food);
    }

    @GetMapping("/{id}")
    public Optional<Food> findOne(@PathVariable Long id) {
        return foodService.findOne(id);
    }

    /* @PutMapping("/")
    public List<Food> update(@RequestBody Food food) {
        return foodService.update(food);
    }

    @DeleteMapping("/delete/{id}")
    public List<Food> delete(@PathVariable Long id) {
        return foodService.delete(id);
    } */

}
