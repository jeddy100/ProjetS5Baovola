package com.example.projets5baovola.model;

import jakarta.persistence.*;

@Entity
public class MouvementStock {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private int quantite;

    @ManyToOne
    @JoinColumn(name = "id_materiaux")
    private Materiaux materiaux;

    private int typeMouvement;

    public MouvementStock() {

    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Materiaux getMateriaux() {
        return materiaux;
    }

    public void setMateriaux(Materiaux materiaux) {
        this.materiaux = materiaux;
    }

    public int getTypeMouvement() {
        return typeMouvement;
    }

    public void setTypeMouvement(int typeMouvement) {
        this.typeMouvement = typeMouvement;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MouvementStock(Long id, int quantite, Materiaux materiaux, int typeMouvement) {
        this.id = id;
        this.quantite = quantite;
        this.materiaux = materiaux;
        this.typeMouvement = typeMouvement;
    }

    public MouvementStock(int quantite, Materiaux materiaux, int typeMouvement) {
        this.quantite = quantite;
        this.materiaux = materiaux;
        this.typeMouvement = typeMouvement;
    }


}
