package org.top.productsandordersapiapp.service;

import org.springframework.stereotype.Service;
import org.top.productsandordersapiapp.entity.Client;

import java.util.List;
import java.util.Optional;

@Service
public interface ClientService {
    Optional<Client> add(Client client);
    List<Client> getAll();
    Optional<Client> getById(Integer id);
    Boolean deletedById(Integer id);
    Optional<Client> update(Client client);
}
