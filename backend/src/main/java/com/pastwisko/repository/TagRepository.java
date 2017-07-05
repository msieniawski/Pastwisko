package com.pastwisko.repository;

import com.pastwisko.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface TagRepository extends JpaRepository<Tag, Integer> {
}
