package com.example.teendo.repository;

import com.example.teendo.model.Teendo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeendoRepository extends JpaRepository<Teendo, Long> {
}