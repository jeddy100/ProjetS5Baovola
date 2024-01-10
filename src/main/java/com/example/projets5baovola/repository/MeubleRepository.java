package com.example.projets5baovola.repository;

import com.example.projets5baovola.model.Materiaux;
import com.example.projets5baovola.model.Meuble;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeubleRepository extends JpaRepository<Meuble,Long> {
    @Query("select m from Meuble m  ")
    List<Materiaux>getMateriauxParMeubles();

    @Query(value = "SELECT " +
            "    SUM(0.5*(dmc.quantite_materiaux * m.prix) + 0.5*(dms.quantite_materiaux * m2.prix)) AS prixbase " +
            "FROM " +
            "    meuble " +
            "        JOIN " +
            "    public.categorie c ON c.id = meuble.id_categorie " +
            "        JOIN " +
            "    public.style s ON s.id = meuble.id_style " +
            "        JOIN " +
            "    public.details_materiaux_categorie dmc ON c.id = dmc.id_categorie " +
            "        JOIN " +
            "    public.details_materiaux_style dms ON s.id = dms.id_style  " +
            "        JOIN " +
            "    public.materiaux m ON dmc.id_materiaux = m.id " +
            "        JOIN " +
            "    public.materiaux m2 ON dms.id_materiaux = m2.id " +
            "WHERE " +
            "    meuble.id = :idmeuble and dmc.id_volume = :volume and dms.id_volume = :volume", nativeQuery = true)
    double getprixDeBaseMeuble(@Param("idmeuble") Long idmeuble, @Param("volume") Long volume);






}
