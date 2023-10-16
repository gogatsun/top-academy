package com.example.resortsoftheworldapplication.rdb.service;

import com.example.resortsoftheworldapplication.entity.Country;
import com.example.resortsoftheworldapplication.rdb.repositories.CountryRepositories;
import com.example.resortsoftheworldapplication.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RdbCountryService implements CountryService {

    private final CountryRepositories repositories;

    public RdbCountryService(CountryRepositories repositories) {
        this.repositories = repositories;
    }

    @Override
    public List<Country> getAll() {
        return (List<Country>) repositories.findAll();
    }

    @Override
    public Optional<Country> getById(Integer id) {
        return repositories.findById(id);
    }

    @Override
    public Optional<Country> add(Country country) {
        Optional<Country> existing = repositories.findByName(country.getName());
        if (existing.isPresent()) {
            return Optional.empty();
        }
        return Optional.of(repositories.save(country));
    }

    @Override
    public Optional<Country> update(Country country) {
        Optional<Country> updated = repositories.findById(country.getId());
        if (updated.isPresent()) {
            Optional<Country> existing = repositories.findByName(country.getName());
            if (existing.isEmpty()) {
                return Optional.of(repositories.save(country));
            }
        }
        return Optional.empty();
    }
}
