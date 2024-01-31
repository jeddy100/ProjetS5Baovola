package com.example.projets5baovola.model;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_ouvrier")
    private Ouvrier ouvrier;

    String nom;
     double paiehoraire;

    public double getPaiehoraire() {
        return paiehoraire;
    }

    public void setPaiehoraire(double paiehoraire) {
        this.paiehoraire = paiehoraire;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    LocalDate dateEmbauche;

    String rang;

    public Employe() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ouvrier getOuvrier() {
        return ouvrier;
    }

    public void setOuvrier(Ouvrier ouvrier) {
        this.ouvrier = ouvrier;
    }

    public LocalDate getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(LocalDate dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public String getRang() {
        return rang;
    }

    public void setRang(String rang) {
        this.rang = rang;
    }

    public Employe(Long id, Ouvrier ouvrier, LocalDate dateEmbauche, String rang,String nom,double paiehoraire) {
        this.setId(id);
        this.setOuvrier(ouvrier);
        this.setDateEmbauche(dateEmbauche);
        this.setRang(rang);
        this.setNom(nom);
        this.setPaiehoraire(paiehoraire);
    }
    public Employe(Ouvrier ouvrier, LocalDate dateEmbauche, String rang,String nom,double paiehoraire) {
        this.setOuvrier(ouvrier);
        this.setDateEmbauche(dateEmbauche);
        this.setRang(rang);
        this.setNom(nom);
        this.setPaiehoraire(paiehoraire);

    }
}
