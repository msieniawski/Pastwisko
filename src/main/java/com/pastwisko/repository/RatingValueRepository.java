package com.pastwisko.repository;

import com.pastwisko.model.RatingValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingValueRepository extends JpaRepository<RatingValue, Integer> {
}
