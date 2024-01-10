package com.example.projets5baovola.model;

import jakarta.persistence.*;

@Entity
public class Meuble {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_style")
    private Style style;

    @ManyToOne
    @JoinColumn(name = "id_categorie")
    private Categorie categorie;

    @ManyToOne
    @JoinColumn(name = "id_volume")
    private Volume volume;

    private String nom;

    private double prix_vente;

    public Meuble() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Volume getVolume() {
        return volume;
    }

    public void setVolume(Volume volume) {
        this.volume = volume;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix_vente() {
        return prix_vente;
    }

    public void setPrix_vente(double prix_vente) {
        this.prix_vente = prix_vente;
    }

    public Meuble(Long id, Style style, Categorie categorie, Volume volume, String nom, double prix_vente) {
        this.id = id;
        this.style = style;
        this.categorie = categorie;
        this.volume = volume;
        this.nom = nom;
        this.prix_vente = prix_vente;
    }

    public Meuble(Style style, Categorie categorie, Volume volume, String nom, double prix_vente) {
        this.style = style;
        this.categorie = categorie;
        this.volume = volume;
        this.nom = nom;
        this.prix_vente = prix_vente;
    }
}
