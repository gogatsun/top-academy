package com.example.bookstoreapplication.rdb.service;

import com.example.bookstoreapplication.entity.Publisher;
import com.example.bookstoreapplication.rdb.repositories.PublisherRepository;
import com.example.bookstoreapplication.service.PublisherService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PublisherRdbService implements PublisherService {

    private final PublisherRepository publisherRepository;

    public PublisherRdbService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public List<Publisher> findAll() {
        return (List<Publisher>) publisherRepository.findAll();
    }

    @Override
    public Optional<Publisher> findById(Long id) {
        return publisherRepository.findById(id);
    }

    // добавление издательства
    @Override
    public Optional<Publisher> add(Publisher publisher) {
        Optional<Publisher> existing = publisherRepository.findByTitle(publisher.getTitle());
        if (existing.isPresent()) {
            return Optional.empty();
        }
        return Optional.of(publisherRepository.save(publisher));
    }

    @Override
    public Optional<Publisher> update(Publisher publisher) {
        Optional<Publisher> updated = publisherRepository.findById(publisher.getId());
        if (updated.isEmpty()) {
            return Optional.empty();
        }
        Optional<Publisher> existing = publisherRepository.findByTitle(publisher.getTitle());
        if (existing.isPresent() && !Objects.equals(publisher.getId(), existing.get().getId())) {
            return Optional.empty();
        }
        return Optional.of(publisherRepository.save(publisher));
    }

}
