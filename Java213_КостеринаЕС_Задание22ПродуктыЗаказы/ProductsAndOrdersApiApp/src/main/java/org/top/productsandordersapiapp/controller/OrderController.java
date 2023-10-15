package org.top.productsandordersapiapp.controller;

import org.aspectj.weaver.ast.Or;
import org.springframework.web.bind.annotation.*;

import org.top.productsandordersapiapp.entity.Order;
import org.top.productsandordersapiapp.service.OrderService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("")
    public List<Order> getAll() {
        return orderService.getAll();
    }

    @PostMapping("new")
    public Optional<Order> addNew(@RequestBody Order order) {
        return orderService.add(order);
    }

    @GetMapping("{id}")
    public Optional<Order> getById(@PathVariable Integer id) {
        return orderService.getById(id);
    }

    @GetMapping("client/{id}")
    public List<Order> getByClientId(@PathVariable Integer id) {
        return orderService.getByClientId(id);
    }

    @PostMapping("update")
    public Optional<Order> update(@RequestBody Order order) {
        return orderService.update(order);
    }


}
