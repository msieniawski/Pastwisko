package com.pastwisko.service.impl;

import com.pastwisko.model.RatingValue;
import com.pastwisko.repository.RatingValueRepository;
import com.pastwisko.service.RatingValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingValueServiceImpl implements RatingValueService {

    private final RatingValueRepository ratingValueRepository;

    @Autowired
    public RatingValueServiceImpl(RatingValueRepository ratingValueRepository) {
        this.ratingValueRepository = ratingValueRepository;
    }

    @Override
    public List<RatingValue> listAll() {
        return ratingValueRepository.findAll();
    }

    @Override
    public RatingValue getById(int id) {
        return ratingValueRepository.findOne(id);
    }

    @Override
    public RatingValue saveOrUpdate(RatingValue ratingValue) {
        return ratingValueRepository.save(ratingValue);
    }

    @Override
    public void delete(int id) {
        ratingValueRepository.delete(id);
    }
}
