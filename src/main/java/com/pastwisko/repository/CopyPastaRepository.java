package com.pastwisko.repository;

import com.pastwisko.model.CopyPasta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CopyPastaRepository extends JpaRepository<CopyPasta, Integer> {
}
