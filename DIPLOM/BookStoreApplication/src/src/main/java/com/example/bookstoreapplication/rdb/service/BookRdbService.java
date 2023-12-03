package com.example.bookstoreapplication.rdb.service;

import com.example.bookstoreapplication.entity.Book;
import com.example.bookstoreapplication.rdb.repositories.BookRepository;
import com.example.bookstoreapplication.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookRdbService implements BookService {

    private final BookRepository bookRepository;

    public BookRdbService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public Optional<Book> add(Book book) {
        return Optional.empty();
    }

    @Override
    public Optional<Book> update(Book book) {
        return Optional.empty();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public List<Book> findAll() {
        return (List<Book>) bookRepository.findAll();
    }

    @Override
    public Optional<Book> delete(Long id) {
        return Optional.empty();
    }
}
