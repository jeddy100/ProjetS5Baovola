package com.example.projets5baovola.repository;

import com.example.projets5baovola.model.Meuble;
import com.example.projets5baovola.model.Ouvrier;
import com.example.projets5baovola.model.OuvrierMeuble;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OuvrierMeubleRepository extends JpaRepository<OuvrierMeuble,Long> {
    @Query("SELECT om FROM OuvrierMeuble om WHERE om.meuble = :meuble")
    List<OuvrierMeuble> findByMeuble(@Param("meuble") Meuble meuble);

}
