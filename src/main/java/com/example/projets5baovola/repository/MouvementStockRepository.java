package com.example.projets5baovola.repository;

import com.example.projets5baovola.model.Materiaux;
import com.example.projets5baovola.model.MouvementStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MouvementStockRepository extends JpaRepository<MouvementStock,Long> {


        @Query("SELECT SUM(CASE WHEN m.typeMouvement = 1 THEN m.quantite ELSE 0 END) - SUM(CASE WHEN m.typeMouvement = 2 THEN m.quantite ELSE 0 END) FROM MouvementStock m WHERE m.materiaux = :materiaux")
        Double sumQuantitiesByMaterialAndMovementType(@Param("materiaux") Materiaux materiaux);


}
