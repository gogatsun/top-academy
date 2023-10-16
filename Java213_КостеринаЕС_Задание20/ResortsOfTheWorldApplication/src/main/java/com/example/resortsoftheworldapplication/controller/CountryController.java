package com.example.resortsoftheworldapplication.controller;

import com.example.resortsoftheworldapplication.entity.Country;
import com.example.resortsoftheworldapplication.service.CountryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("country")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("")
    public List<Country> getAll() {
        return countryService.getAll();
    }

    @GetMapping("{id}")
    public Optional<Country> getById(@PathVariable Integer id) {
        return countryService.getById(id);
    }

    @PostMapping("new")
    public Optional<Country> add(@RequestBody Country country) {
        return countryService.add(country);
    }

}
