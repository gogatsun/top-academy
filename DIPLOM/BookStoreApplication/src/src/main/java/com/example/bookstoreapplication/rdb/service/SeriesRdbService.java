package com.example.bookstoreapplication.rdb.service;

import com.example.bookstoreapplication.entity.Series;
import com.example.bookstoreapplication.rdb.repositories.SeriesRepository;
import com.example.bookstoreapplication.service.SeriesService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeriesRdbService implements SeriesService {

    private final SeriesRepository seriesRepository;

    public SeriesRdbService(SeriesRepository seriesRepository) {
        this.seriesRepository = seriesRepository;
    }

    @Override
    public Optional<Series> add(Series series) {
        Optional<Series> existing = seriesRepository.findByTitle(series.getTitle());
        if (existing.isPresent()) {
            return Optional.empty();
        }
        return Optional.of(seriesRepository.save(series));
    }

    @Override
    public Optional<Series> update(Series series) {
        Optional<Series> existing = seriesRepository.findById(series.getId());
        if (existing.isEmpty()) {
            return Optional.empty();
        }
        Optional<Series> updated = seriesRepository.findByTitle(series.getTitle());
        if (updated.isPresent()) {
            return Optional.empty();
        }
        return Optional.of(seriesRepository.save(series));
    }

    @Override
    public Optional<Series> findById(Long id) {
        return seriesRepository.findById(id);
    }

    @Override
    public List<Series> findAll() {
        return (List<Series>) seriesRepository.findAll();
    }
}
