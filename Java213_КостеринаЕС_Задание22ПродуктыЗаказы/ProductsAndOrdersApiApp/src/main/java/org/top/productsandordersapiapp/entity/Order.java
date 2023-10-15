package org.top.productsandordersapiapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "order_t")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "description_f")
    private String description;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @OneToMany(mappedBy = "order")
    @JsonIgnore
    private Set<ProductOrder> productOrder;

    public Order() {
        id = -1;
        description = null;
        client = null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Set<ProductOrder> getProductOrder() {
        return productOrder;
    }

    public void setProductOrder(Set<ProductOrder> productOrder) {
        this.productOrder = productOrder;
    }

    @Override
    public String toString() {
        return id + " - " + description + " - " + client + " - " + productOrder;
    }
}
