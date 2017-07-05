package com.pastwisko.repository;

import com.pastwisko.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByUserName(String userName);

}
