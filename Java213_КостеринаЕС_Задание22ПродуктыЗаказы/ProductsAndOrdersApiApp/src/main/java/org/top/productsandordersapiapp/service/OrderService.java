package org.top.productsandordersapiapp.service;

import org.springframework.stereotype.Service;
import org.top.productsandordersapiapp.entity.Order;

import java.util.List;
import java.util.Optional;

@Service
public interface OrderService {
    List<Order> getAll(); // получение всех записей
    Optional<Order> add(Order order); // добавление заказа
    Optional<Order> getById(Integer id); // получение заказа по id
    List<Order> getByClientId(Integer id); // получение заказов по id клиента
    Optional<Order> update(Order order); // изменение description заказа

}
