package com.example.resortsoftheworldapplication.service;

import com.example.resortsoftheworldapplication.entity.Resort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ResortService {
    List<Resort> getAll(); // получить все записи
    Optional<Resort> getById(Integer id); // получить записи по id
    Optional<Resort> add(Resort resort); //добавить запись
    Boolean deleteById(Integer id); // удалить запись
    Optional<Resort> update(Resort resort); // редактировать запись
}
