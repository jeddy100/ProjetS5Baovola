package com.example.projets5baovola.repository;

import com.example.projets5baovola.model.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeRepository extends JpaRepository<Employe,Long> {
    @Query("SELECT e FROM Employe e WHERE e.nom LIKE %:searchTerm% OR e.ouvrier.fonction LIKE %:searchTerm%  or e.rang like  %:searchTerm% ")
    List<Employe> searchByTerm(@Param("searchTerm") String searchTerm);

}
