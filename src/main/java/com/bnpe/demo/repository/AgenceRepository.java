package com.bnpe.demo.repository;

import com.bnpe.demo.model.Agence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AgenceRepository extends JpaRepository<Agence, Long> {
    Optional<Agence> findByCode(String code);
}
