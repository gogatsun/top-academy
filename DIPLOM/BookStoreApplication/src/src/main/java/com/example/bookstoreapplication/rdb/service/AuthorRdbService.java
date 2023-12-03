package com.example.bookstoreapplication.rdb.service;

import com.example.bookstoreapplication.entity.Author;
import com.example.bookstoreapplication.rdb.repositories.AuthorRepository;
import com.example.bookstoreapplication.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class AuthorRdbService implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorRdbService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Optional<Author> add(Author author) {
        List<Author> existing = authorRepository.findBySurnameAndNameAndPatronymic(author.getSurname(),
                author.getName(), author.getPatronymic());
        // если автора с идентичными ФИО нет
        if (existing.isEmpty()) {
            return Optional.of(authorRepository.save(author));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public List<Author> findAll() {
        return (List<Author>) authorRepository.findAll();
    }

    @Override
    public Optional<Author> update(Author author) {
        List<Author> updated = authorRepository.findBySurnameAndNameAndPatronymic(author.getSurname(),
                author.getName(), author.getPatronymic());
        if (updated.isEmpty()) {
            return Optional.of(authorRepository.save(author));
        }
        return Optional.empty();
    }

    @Override
    public List<Author> findByName(String name) {
        List<Author> bySurname = authorRepository.findBySurname(name);
        List<Author> byName = authorRepository.findByName(name);
        return Stream.concat(bySurname.stream(), byName.stream()).toList();
    }
}
