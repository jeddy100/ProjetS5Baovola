package com.example.projets5baovola.repository;

import com.example.projets5baovola.model.Vente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VenteRepository extends JpaRepository<Vente,Long> {
    @Query("SELECT SUM(v.nombre) FROM Vente v WHERE v.meuble.id = :meubleId")
    Integer getTotalVentesByMeubleId(@Param("meubleId") Long meubleId);

    @Query("SELECT SUM(v.nombre) " +
            "FROM Vente v " +
            "WHERE v.meuble.id = :idMeuble AND v.client.genre.id = :idGenre")
    Integer getTotalVentesByMeubleAndGenre(@Param("idMeuble") Long idMeuble, @Param("idGenre") Long idGenre);

    @Query("SELECT SUM(v.nombre) FROM Vente v ")
    Integer getTotalVentesByMeubleIdtsisy();

    @Query("SELECT SUM(v.nombre) " +
            "FROM Vente v " +
            "WHERE v.client.genre.id = :idGenre")
    Integer getTotalVentesByMeubleAndGenretsisy(@Param("idGenre") Long idGenre);

}
