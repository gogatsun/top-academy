package org.top.productsandordersapiapp.controller;

import org.springframework.web.bind.annotation.*;
import org.top.productsandordersapiapp.entity.Client;
import org.top.productsandordersapiapp.service.ClientService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("client")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("")
    public List<Client> findAll() {
        return clientService.getAll();
    }

    @PostMapping("new")
    public Optional<Client> addNew(@RequestBody Client client) {
        return clientService.add(client);
    }

    @GetMapping("{id}")
    public Optional<Client> findById(@PathVariable Integer id) {
        return clientService.getById(id);
    }

    @GetMapping("delete/{id}")
    public Boolean deleteById(@PathVariable Integer id) {
        return clientService.deletedById(id);
    }

    @PostMapping("update")
    public Optional<Client> update(@RequestBody Client client) {
        return clientService.update(client);
    }

}
