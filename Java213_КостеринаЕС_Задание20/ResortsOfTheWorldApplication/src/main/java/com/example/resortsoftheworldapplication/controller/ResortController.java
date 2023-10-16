package com.example.resortsoftheworldapplication.controller;

import com.example.resortsoftheworldapplication.entity.Resort;
import com.example.resortsoftheworldapplication.service.ResortService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("resort")
public class ResortController {

    private final ResortService resortService;

    public ResortController(ResortService resortService) {
        this.resortService = resortService;
    }

    @GetMapping("")
    public List<Resort> getAll() {
        return resortService.getAll();
    }

    @GetMapping("{id}")
    public Optional<Resort> getById(@PathVariable Integer id) {
        return resortService.getById(id);
    }

    @PostMapping("new")
    public Optional<Resort> add(@RequestBody Resort resort) {
        return resortService.add(resort);
    }

    @GetMapping("delete/{id}")
    public Boolean deleteById(@PathVariable Integer id) {
        return resortService.deleteById(id);
    }

    @PostMapping("update")
    public Optional<Resort> update(@RequestBody Resort resort) {
        return resortService.update(resort);
    }
}
