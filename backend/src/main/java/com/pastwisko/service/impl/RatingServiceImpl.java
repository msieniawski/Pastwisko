package com.pastwisko.service.impl;

import com.pastwisko.model.Rating;
import com.pastwisko.repository.RatingRepository;
import com.pastwisko.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    private final RatingRepository ratingRepository;

    @Autowired
    public RatingServiceImpl(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Override
    public List<Rating> listAll() {
        return ratingRepository.findAll();
    }

    @Override
    public Rating getById(int id) {
        return ratingRepository.findOne(id);
    }

    @Override
    public Rating saveOrUpdate(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public void delete(int id) {
        ratingRepository.delete(id);
    }
}