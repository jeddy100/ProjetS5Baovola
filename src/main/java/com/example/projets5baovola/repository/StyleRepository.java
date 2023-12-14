package com.example.projets5baovola.repository;

import com.example.projets5baovola.model.Style;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface StyleRepository extends JpaRepository<Style,Long> {
}
