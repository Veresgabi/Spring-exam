package hu.flowacademy.test.foodorder.repository;

import hu.flowacademy.test.foodorder.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    Optional<Cart> findById(Long id);

}