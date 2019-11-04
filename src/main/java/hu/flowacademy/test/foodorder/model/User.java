package hu.flowacademy.test.foodorder.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table
public class User {

    @Column
    private String username;

    @Column
    private String fullname;

    @Column
    private String address;

    public User(String username, String fullname, String address) {
        this.username = username;
        this.fullname = fullname;
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String adress) {
        address = adress;
    }
}
