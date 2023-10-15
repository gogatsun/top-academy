package org.top.productsandordersapiapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "client_t")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name_f", nullable = false)
    private String name;

    @Column(name = "email_f", nullable = false)
    private String email;

    @OneToMany(mappedBy = "client")
    @JsonIgnore
    private Set<Order> order;

    public Client() {
        id = -1;
        name = null;
        email = null;
        order = null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Order> getOrder() {
        return order;
    }

    public void setOrder(Set<Order> order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return id + " - " + name + " - " + email + " - " + order;
    }
}
