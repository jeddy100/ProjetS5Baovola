package com.example.projets5baovola.model;

import jakarta.persistence.*;

@Entity
public class Rang {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String nomrang;

    private int debut;
    private int fin;
     private int multiplicateur;

    public Rang() {

    }

    public String getNomrang() {
        return nomrang;
    }

    public void setNomrang(String nomrang) {
        this.nomrang = nomrang;
    }

    public int getDebut() {
        return debut;
    }

    public void setDebut(int debut) {
        this.debut = debut;
    }

    public int getFin() {
        return fin;
    }

    public void setFin(int fin) {
        this.fin = fin;
    }

    public int getMultiplicateur() {
        return multiplicateur;
    }

    public void setMultiplicateur(int multiplicateur) {
        this.multiplicateur = multiplicateur;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Rang(String nomrang, int debut, int fin, int multiplicateur) {
        this.nomrang = nomrang;
        this.debut = debut;
        this.fin = fin;
        this.multiplicateur = multiplicateur;
    }

    public Rang(Long id, String nomrang, int debut, int fin, int multiplicateur) {
        this.id = id;
        this.nomrang = nomrang;
        this.debut = debut;
        this.fin = fin;
        this.multiplicateur = multiplicateur;
    }
}
