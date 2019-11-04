package hu.flowacademy.test.foodorder.service;

import hu.flowacademy.test.foodorder.exception.ValidationException;
import hu.flowacademy.test.foodorder.model.Cart;
import hu.flowacademy.test.foodorder.model.Food;
import hu.flowacademy.test.foodorder.model.User;
import hu.flowacademy.test.foodorder.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class CartService {

    @Autowired
    CartRepository cartRepository;

    public Cart save(Cart cart) {
        if (cart.getUser() == null || CollectionUtils.isEmpty(cart.getFoods())) {
            throw new ValidationException(HttpStatus.BAD_REQUEST, "Cart not found");
        }
        cart.setOrderDate(LocalDateTime.now());
        return cartRepository.save(cart);
    }

    public Optional<Cart> findOne(Long id) {
        return cartRepository.findById(id);
    }

    /* public Cart update(Long id, @NotNull Cart cart) {
        Cart modifyCart = findOne(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cart not found"));
        if (CollectionUtils.isEmpty(cart.getFoods()) ||
                cart.getUser() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The submitted arguments are invalid.");
        } else {
            modifyCart.setFoods(cart.getFoods());
            cartRepository.save(modifyCart);
            return modifyCart;
        }
    } */

    /* private Long id;
    private User user;
    private LocalDateTime orderDate;
    private Food[] foods; */

    public void delete(Long id) {
        Cart deletedCart = findOne(id).orElseThrow(() -> new ValidationException(HttpStatus.BAD_REQUEST, "Cart not found"));
        cartRepository.delete(deletedCart);
    }
}
