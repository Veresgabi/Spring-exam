package hu.flowacademy.test.foodorder.service;

import hu.flowacademy.test.foodorder.exception.ValidationException;
import hu.flowacademy.test.foodorder.model.Cart;
import hu.flowacademy.test.foodorder.model.Food;
import hu.flowacademy.test.foodorder.model.User;
import hu.flowacademy.test.foodorder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;

import javax.persistence.Column;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

public class UserService {

    @Autowired
    UserRepository userRepository;

    public User save(User user) {
        if (StringUtils.isEmpty(user.getUsername()) ||
                StringUtils.isEmpty(user.getFullname()) ||
                StringUtils.isEmpty(user.getAddress())) {
            throw new ValidationException(HttpStatus.BAD_REQUEST, "No enough data!");
        }
        return userRepository.save(user);
    }

    public Optional<User> findOne(String username) {
        return userRepository.findByName(username);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User update(Long id, User user) {
        User modifiedUser =  findOne(user.getUsername()).orElseThrow(() -> new ValidationException(HttpStatus.BAD_REQUEST, "User not found"));
        if (StringUtils.isEmpty(user.getUsername()) ||
                StringUtils.isEmpty(user.getFullname()) ||
                StringUtils.isEmpty(user.getAddress())) {
            throw new ValidationException(HttpStatus.BAD_REQUEST, "No enough data!");
        }
        return userRepository.save(modifiedUser);
    }

    public void delete(String username) {
        User modifiedUser =  findOne(username).orElseThrow(() -> new ValidationException(HttpStatus.BAD_REQUEST, "User not found"));
        userRepository.delete(modifiedUser);
    }


    /* private String username;
    private String fullname;
    private String address; */

}
