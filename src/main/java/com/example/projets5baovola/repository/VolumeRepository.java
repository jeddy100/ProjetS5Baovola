package com.example.projets5baovola.repository;

import com.example.projets5baovola.model.Style;
import com.example.projets5baovola.model.Volume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface VolumeRepository extends JpaRepository<Volume,Long> {
}