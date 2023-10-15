package org.top.productsandordersapiapp.rdb.repository;

import org.aspectj.weaver.ast.Or;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.top.productsandordersapiapp.entity.Client;
import org.top.productsandordersapiapp.entity.Order;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {
    Optional<Order> findByClient(Client client);
    List<Order> findOrdersByClient_Id(Integer id);

}
