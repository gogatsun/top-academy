package com.example.resortsoftheworldapplication.rdb.repositories;

import com.example.resortsoftheworldapplication.entity.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryRepositories extends CrudRepository<Country, Integer> {

    Optional<Country> findByName(String name);
}
