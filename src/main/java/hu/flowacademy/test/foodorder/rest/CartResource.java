package hu.flowacademy.test.foodorder.rest;

import hu.flowacademy.test.foodorder.model.Cart;
import hu.flowacademy.test.foodorder.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/cart")
public class CartResource {

    @Autowired
    CartService cartService;

    @PostMapping("/create")
    public Cart save (@RequestBody Cart cart) {
        return cartService.save(cart);
    }

    @GetMapping("/{id}")
    public Optional<Cart> findOne(@PathVariable Long id) {
        return cartService.findOne(id);
    }

    /* @PutMapping("/{id}")
    public Cart update(@PathVariable("id") Long id, @RequestBody Cart cart) {
        return cartService.update(id, cart);
    } */

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        cartService.delete(id);
    }


}
