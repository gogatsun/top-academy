package com.example.bookstoreapplication.rdb.service;

import com.example.bookstoreapplication.entity.Book;
import com.example.bookstoreapplication.rdb.repositories.BookRepository;
import com.example.bookstoreapplication.service.BookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class BookRdbService implements BookService {

    private final BookRepository bookRepository;

    public BookRdbService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public Optional<Book> add(Book book) {
        Optional<Book> existing = bookRepository.findByTitleAndAuthor(book.getTitle(), book.getAuthor());
        if (existing.isPresent()) {
            return Optional.empty();
        }
        return Optional.of(bookRepository.save(book));
    }

    @Override
    public Optional<Book> update(Book book) {
        Optional<Book> updated = bookRepository.findById(book.getId());
        if (updated.isEmpty()) {
            return Optional.empty();
        }
        Optional<Book> existing = bookRepository.findByTitleAndAuthor(book.getTitle(), book.getAuthor());
        if (existing.isPresent()) {
            return Optional.empty();
        }
        return Optional.of(bookRepository.save(book));
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
    public List<Book> findList(int count) {
        List<Book> bookList = (List<Book>) bookRepository.findAll();
        Random random = new Random();
        List<Book> books = new ArrayList<>();
        List<Integer> ints = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int index = random.nextInt(0, bookList.size());
            if (!ints.contains(index)) {
                books.add(i, bookList.get(index));
                ints.add(index);
            } else {
                i--;
            }
        }
        return books;
    }

    @Override
    public Optional<Book> delete(Long id) {
        return Optional.empty();
    }
}
