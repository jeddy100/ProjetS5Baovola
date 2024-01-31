package com.example.projets5baovola.model;

import jakarta.persistence.*;

@Entity
public class Ouvrier {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    String fonction;
    double paieHoraire;


    public Ouvrier() {

    }


    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public double getPaieHoraire() {
        return paieHoraire;
    }

    public void setPaieHoraire(double paieHoraire) {
        this.paieHoraire = paieHoraire;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ouvrier(Long id, String fonction, double paieHoraire) {
        this.id = id;
        this.fonction = fonction;
        this.paieHoraire = paieHoraire;
    }

    public Ouvrier(String fonction, double paieHoraire) {
        this.fonction = fonction;
        this.paieHoraire = paieHoraire;
    }
}
