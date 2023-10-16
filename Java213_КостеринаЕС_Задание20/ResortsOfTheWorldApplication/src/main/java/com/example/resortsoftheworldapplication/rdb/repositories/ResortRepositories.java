package com.example.resortsoftheworldapplication.rdb.repositories;

import com.example.resortsoftheworldapplication.entity.Resort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResortRepositories extends CrudRepository<Resort, Integer> {
    Optional<Resort> findByName(String name);
}
