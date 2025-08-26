package com.gyorgy.teendofinal2.repository;

import com.gyorgy.teendofinal2.model.Teendo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeendoRepository extends JpaRepository<Teendo, Long> {
}