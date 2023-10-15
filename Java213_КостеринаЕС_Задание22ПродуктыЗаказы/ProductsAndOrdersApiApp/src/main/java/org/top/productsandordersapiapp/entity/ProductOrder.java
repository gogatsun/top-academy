package org.top.productsandordersapiapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

// Класс ProductOrder - описывает объект заказа на товар
// соответсвует таблице product_order_t из БД
// позволяет хранить информацию об объекте "Заказ на товар", не реализует бизнес-логику
// является dataclass-ом
@Entity
@Table(name="product_order_t")
public class ProductOrder {

    // поля
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="description_f")
    private String description;

    @Column(name="quantity_f", nullable = false)
    private Integer quantity;

    // поля, реализующие связь "один-ко-многим"
    @ManyToOne
    @JoinColumn(name="product_id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    public ProductOrder() {
        id = 0;
        description = null;
        quantity = 0;
        product = null;
        order = null;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return id + " - " + description + " - " + quantity + " - " + product;
    }
}
