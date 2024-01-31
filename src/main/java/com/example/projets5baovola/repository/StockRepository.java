package com.example.projets5baovola.repository;

import com.example.projets5baovola.model.Materiaux;
import com.example.projets5baovola.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock,Long> {
    @Query("select s from Stock s where s.materiaux =:materiaux")
    List<Stock> getStockparmateriaux(@Param("materiaux")Materiaux materiaux);

    @Query("select SUM (s.quantite) from Stock s where s.materiaux=:materiaux")
    double quantiteStock(@Param("materiaux")Materiaux materiaux);
}
