package com.example.projets5baovola.repository;

import com.example.projets5baovola.model.Ouvrier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OuvrierRepository extends JpaRepository<Ouvrier,Long> {
}
