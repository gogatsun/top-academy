package org.top.productsandordersapiapp.rdb.service;

import org.springframework.stereotype.Service;
import org.top.productsandordersapiapp.entity.Client;
import org.top.productsandordersapiapp.entity.Order;
import org.top.productsandordersapiapp.rdb.repository.ClientRepository;
import org.top.productsandordersapiapp.rdb.repository.OrderRepository;
import org.top.productsandordersapiapp.service.OrderService;

import java.util.List;
import java.util.Optional;

@Service
public class RdbOrderService implements OrderService {

    private final OrderRepository orderRepository;
    private final ClientRepository clientRepository;

    public RdbOrderService(OrderRepository orderRepository, ClientRepository clientRepository) {
        this.orderRepository = orderRepository;
        this.clientRepository = clientRepository;
    }


    @Override
    public List<Order> getAll() { // получить все записи
        return (List<Order>) orderRepository.findAll();
    }

    @Override
    public Optional<Order> add(Order order) { // добавить запись
        Optional<Client> client = clientRepository.findById(order.getClient().getId());
        if (client.isPresent()) {
            return Optional.of(orderRepository.save(order));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Order> getById(Integer id) { // получить запись по ID
        return orderRepository.findById(id);
    }

    @Override
    public List<Order> getByClientId(Integer id) { // получить заказы по id клиента
        Optional<Client> client = clientRepository.findById(id);
        if (client.isPresent()) {
            return orderRepository.findOrdersByClient_Id(id);
        }
        return null;
    }

    @Override
    public Optional<Order> update(Integer id, String description) {
        Optional<Order> updated = getById(id);
        if (updated.isPresent()) {
            updated.get().setDescription(description);
            orderRepository.save(updated.get());
        }
        return updated;
    }
}
