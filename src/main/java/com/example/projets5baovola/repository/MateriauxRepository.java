package com.example.projets5baovola.repository;

import com.example.projets5baovola.model.Materiaux;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MateriauxRepository extends JpaRepository<Materiaux,Long> {
}
