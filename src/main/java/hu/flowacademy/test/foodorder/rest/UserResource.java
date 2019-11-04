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
    public UserService userService;

    @PostMapping("/create")
    public User user (@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/getall")
    public List<User> findAll () {
        return userService.findAll();
    }

    @GetMapping("/{username}")
    public Optional<User> findOne(@PathVariable("username") String username) {
        return userService.findOne(username);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable("id") Long id, @RequestBody User user) {
        return userService.update(id, user);
    }

    @DeleteMapping("/delete/{username}")
    public void delete(@PathVariable String username) {
        userService.delete(username);
    }

}
