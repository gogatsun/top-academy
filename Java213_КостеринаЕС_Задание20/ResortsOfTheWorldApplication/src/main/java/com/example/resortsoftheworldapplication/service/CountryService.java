package com.example.resortsoftheworldapplication.service;

import com.example.resortsoftheworldapplication.entity.Country;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CountryService {
    List<Country> getAll();
    Optional<Country> getById(Integer id);
    Optional<Country> add(Country country);
    Optional<Country> update(Country country); // изменить название (ну, а вдруг!)
}
