package com.example.projets5baovola.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Materiaux {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String nom;
    private String unite;

    private double prix;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Materiaux(String nom, String unite, double prix) {
        this.nom = nom;
        this.unite = unite;
        this.prix = prix;
    }

    public Materiaux(Long id, String nom, String unite, double prix) {
        this.id = id;
        this.nom = nom;
        this.unite = unite;
        this.prix = prix;
    }

    public Materiaux(){

    }
}
