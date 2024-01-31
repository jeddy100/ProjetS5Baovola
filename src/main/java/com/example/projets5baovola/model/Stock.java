package com.example.projets5baovola.model;

import jakarta.persistence.*;

@Entity
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private int quantite;

    @ManyToOne
    @JoinColumn(name = "id_materiaux")
    private Materiaux materiaux;

    public Stock() {

    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Stock(Long id, int quantite, Materiaux materiaux) {
        this.id = id;
        this.quantite = quantite;
        this.materiaux = materiaux;
    }

    public Materiaux getMateriaux() {
        return materiaux;
    }

    public void setMateriaux(Materiaux materiaux) {
        this.materiaux = materiaux;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Stock(int quantite, Materiaux materiaux) {
        this.quantite = quantite;
        this.materiaux = materiaux;
    }
}
