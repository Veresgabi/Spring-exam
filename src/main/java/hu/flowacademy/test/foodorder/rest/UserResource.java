package hu.flowacademy.test.foodorder.rest;


import hu.flowacademy.test.foodorder.model.Cart;
import hu.flowacademy.test.foodorder.model.Food;
import hu.flowacademy.test.foodorder.model.User;
import hu.flowacademy.test.foodorder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserResource {

    @Autowired
    UserService userService;

    @PostMapping("/create")
    User user (@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/{id}")
    public Optional<User> findOne(@PathVariable String username) {
        return userService.findOne(username);
    }

    /* @PutMapping("/")
    public List<User> update(@RequestBody Cart cart) {
        return userService.update(cart);
    }

    @DeleteMapping("/delete/{id}")
    public List<User> delete(@PathVariable Long id) {
        return userService.delete(id);
    } */

}
