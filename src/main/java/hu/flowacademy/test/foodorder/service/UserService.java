package hu.flowacademy.test.foodorder.service;

import hu.flowacademy.test.foodorder.model.Cart;
import hu.flowacademy.test.foodorder.model.User;
import hu.flowacademy.test.foodorder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserService {

    @Autowired
    UserRepository userRepository;

    public User save(User user) {

        return userRepository.save(user);
    }

    public Optional<User> findOne(String username) {
        return userRepository.findByname(username);
    }

    // public List<User> update(Cart cart) {
    // }

    // public List<User> delete(Long id) {
    // }
}
