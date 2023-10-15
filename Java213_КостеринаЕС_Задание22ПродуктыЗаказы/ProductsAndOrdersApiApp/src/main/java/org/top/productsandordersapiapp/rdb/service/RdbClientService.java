package org.top.productsandordersapiapp.rdb.service;

import org.springframework.stereotype.Service;
import org.top.productsandordersapiapp.entity.Client;
import org.top.productsandordersapiapp.rdb.repository.ClientRepository;
import org.top.productsandordersapiapp.service.ClientService;

import java.util.List;
import java.util.Optional;

@Service
public class RdbClientService implements ClientService {

    private final ClientRepository clientRepository;

    public RdbClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    @Override
    public Optional<Client> add(Client client) { // добавление
        Optional<Client> existing = clientRepository.findByEmail(client.getEmail());
        if (existing.isPresent()) { // если есть клиент с таким email
            return Optional.empty();
        }
        return Optional.of(clientRepository.save(client));
    }

    @Override
    public List<Client> getAll() { // All
        return (List<Client>) clientRepository.findAll();
    }

    @Override
    public Optional<Client> getById(Integer id) { // byId
        return clientRepository.findById(id);
    }

    @Override
    public Boolean deletedById(Integer id) { // delete
        Optional<Client> deleted = getById(id);
        if (deleted.isPresent()) {
            clientRepository.deleteById(id);
        }
        return deleted.isPresent();
    }

    @Override
    public Optional<Client> update(Client client) { // todo: update in client
        Optional<Client> updated = clientRepository.findById(client.getId());
        if (updated.isPresent()) {
            if (client.getEmail().equals(updated.get().getEmail())) {
                return Optional.of(clientRepository.save(client));
            }
            Optional<Client> existingMail = clientRepository.findByEmail(client.getEmail());
            if (existingMail.isPresent()) {
                return Optional.empty();
            }
            return Optional.of(clientRepository.save(client));
        }
        return Optional.empty();
    }
}
