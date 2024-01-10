package com.example.projets5baovola.model;

import jakarta.persistence.*;

@Entity
public class Volume {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String nomVolume;

    public Volume(String nomVolume) {
        this.nomVolume = nomVolume;
    }

    public Volume(Long id, String nomVolume) {
        this.id = id;
        this.nomVolume = nomVolume;
    }

    public String getNomVolume() {
        return nomVolume;
    }

    public void setNomVolume(String nomVolume) {
        this.nomVolume = nomVolume;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Volume(){}
}
