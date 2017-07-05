package com.pastwisko.repository;

import com.pastwisko.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
