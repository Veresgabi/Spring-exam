package hu.flowacademy.test.foodorder.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table
public class Cart {

    @Id
    @Column
    private Long id;

    @Column
    private User user;

    @Column
    private LocalDateTime orderDate;

    @ManyToMany()
    @JoinTable(
            name = "food_cart",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "food_id"))
    private List <Food> foods;


    public Cart(Long id, User user, LocalDateTime orderDate, List <Food> foods) {
        this.id = id;
        this.user = user;
        this.orderDate = orderDate;
        this.foods = foods;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List <Food> foods) {
        this.foods = foods;
    }
}

