package com.example.projets5baovola.repository;

import com.example.projets5baovola.model.DetailsMateriauxCategorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailsMateriauxCategorieRepository extends JpaRepository<DetailsMateriauxCategorie,Long> {

}
