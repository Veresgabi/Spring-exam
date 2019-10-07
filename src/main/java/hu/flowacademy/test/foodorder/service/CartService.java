package hu.flowacademy.test.foodorder.service;

import hu.flowacademy.test.foodorder.model.Cart;
import hu.flowacademy.test.foodorder.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CartService {

    @Autowired
    CartRepository cartRepository;

    public Cart save(Cart cart) {
        return cartRepository.save(cart);
    }

    public Optional<Cart> findOne(Long id) {
        return cartRepository.findById(id);
    }

    // public List<Cart> update(Cart cart) {
    // }

    // public List<Cart> delete(Long id) {
    // }
}
