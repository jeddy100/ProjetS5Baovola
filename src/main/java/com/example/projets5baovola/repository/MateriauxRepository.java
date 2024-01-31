package com.example.projets5baovola.repository;

import com.example.projets5baovola.model.Categorie;
import com.example.projets5baovola.model.Materiaux;
import com.example.projets5baovola.model.Style;
import com.example.projets5baovola.model.Volume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MateriauxRepository extends JpaRepository<Materiaux,Long> {
    @Query("SELECT dms.materiaux AS materiaux, SUM(dms.quantiteMateriaux) AS quantite " +
            "FROM DetailsMateriauxStyle dms " +
            "WHERE dms.style = :style AND dms.volume = :volume " +
            "GROUP BY dms.materiaux")
    List<Object[]> getMaterialsForFurniture(@Param("style") Style style, @Param("volume") Volume volume);

    @Query("SELECT dmc.materiaux AS materiaux, SUM(dmc.quantiteMateriaux) AS quantite " +
            "FROM DetailsMateriauxCategorie dmc " +
            "WHERE dmc.categorie = :categorie AND dmc.volume = :volume " +
            "GROUP BY dmc.materiaux")
    List<Object[]> getMaterialsForFurnitureByCategory(@Param("categorie") Categorie categorie, @Param("volume") Volume volume);

}
