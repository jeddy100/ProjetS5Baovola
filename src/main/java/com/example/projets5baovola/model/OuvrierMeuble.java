package com.example.projets5baovola.model;

import com.example.projets5baovola.Controller.OuvrierController;
import jakarta.persistence.*;

@Entity
public class OuvrierMeuble {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_meuble")
    private Meuble meuble;

    @ManyToOne
    @JoinColumn(name = "id_ouvrier")
    private Ouvrier ouvrier;

    int nombreOuvrier;

    public OuvrierMeuble() {

    }

    public Meuble getMeuble() {
        return meuble;
    }

    public void setMeuble(Meuble meuble) {
        this.meuble = meuble;
    }

    public Ouvrier getOuvrier() {
        return ouvrier;
    }

    public void setOuvrier(Ouvrier ouvrier) {
        this.ouvrier = ouvrier;
    }

    public int getNombreOuvrier() {
        return nombreOuvrier;
    }

    public void setNombreOuvrier(int nombreOuvrier) {
        this.nombreOuvrier = nombreOuvrier;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OuvrierMeuble(Long id, Meuble meuble, Ouvrier ouvrier, int nombreOuvrier) {
        this.id = id;
        this.meuble = meuble;
        this.ouvrier = ouvrier;
        this.nombreOuvrier = nombreOuvrier;
    }

    public OuvrierMeuble(Meuble meuble, Ouvrier ouvrier, int nombreOuvrier) {
        this.meuble = meuble;
        this.ouvrier = ouvrier;
        this.nombreOuvrier = nombreOuvrier;
    }
}
