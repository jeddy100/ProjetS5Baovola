package com.example.projets5baovola.repository;

import com.example.projets5baovola.model.DetailsMateriauxStyle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailsMateriauxStyleRepository extends JpaRepository<DetailsMateriauxStyle,Long> {
}
