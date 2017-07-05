package com.pastwisko.repository;

import com.pastwisko.model.CopyPasta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "pasta", path = "pasta")
public interface CopyPastaRepository extends JpaRepository<CopyPasta, Integer> {
}
