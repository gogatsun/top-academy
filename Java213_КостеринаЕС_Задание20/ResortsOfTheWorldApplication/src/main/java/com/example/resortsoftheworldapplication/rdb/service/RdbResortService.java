package com.example.resortsoftheworldapplication.rdb.service;

import com.example.resortsoftheworldapplication.entity.Resort;
import com.example.resortsoftheworldapplication.rdb.repositories.ResortRepositories;
import com.example.resortsoftheworldapplication.service.ResortService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RdbResortService implements ResortService {

    private final ResortRepositories resortRepositories;

    public RdbResortService(ResortRepositories resortRepositories) {
        this.resortRepositories = resortRepositories;
    }
    @Override
    public List<Resort> getAll() {
        return (List<Resort>) resortRepositories.findAll();
    }

    @Override
    public Optional<Resort> getById(Integer id) {
        return resortRepositories.findById(id);
    }

    @Override
    public Optional<Resort> add(Resort resort) {
        Optional<Resort> existing = resortRepositories.findByName(resort.getName());
        if (existing.isEmpty()) { // курорта с таким названием нет
            return Optional.of(resortRepositories.save(resort));
        }
        if (existing.get().getCountry().equals(resort.getCountry())) { // если есть и страны равны
            return Optional.empty();
        }
        return Optional.of(resortRepositories.save(resort));
    }

    @Override
    public Boolean deleteById(Integer id) {
        Optional<Resort> deleted = resortRepositories.findById(id);
        if (deleted.isPresent()) {
            resortRepositories.deleteById(id);
        }
        return deleted.isPresent();
    }

    @Override
    public Optional<Resort> update(Resort resort) {
        Optional<Resort> updated = resortRepositories.findById(resort.getId());
        if (updated.isEmpty()) { // изменяемый объект не существует
            return Optional.empty();
        }
        Optional<Resort> existing = resortRepositories.findByName(resort.getName());
        if (existing.isPresent()) { // объект с таким же именем уже есть
            if (existing.get().getCountry().getId().equals(resort.getCountry().getId())) { // страны в объектах равны
                return Optional.empty(); // ничего не изменяем
            }
        }
        return Optional.of(resortRepositories.save(resort)); // сохраняем изменения
    }
}
