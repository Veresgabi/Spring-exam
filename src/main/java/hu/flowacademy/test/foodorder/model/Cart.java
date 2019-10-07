package hu.flowacademy.test.foodorder.model;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    private Food[] foods;


}

