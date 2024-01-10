package com.example.projets5baovola.model;

import jakarta.persistence.*;

@Entity
public class DetailsMateriauxStyle {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_materiaux")
    private Materiaux materiaux;

    @ManyToOne
    @JoinColumn(name = "id_style")
    private Style style;

    @ManyToOne
    @JoinColumn(name = "id_volume")
    private Volume volume;

    private double quantiteMateriaux;

    public DetailsMateriauxStyle() {

    }

    public double getQuantiteMateriaux() {
        return quantiteMateriaux;
    }

    public void setQuantiteMateriaux(double quantiteMateriaux) {
        this.quantiteMateriaux = quantiteMateriaux;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Materiaux getMateriaux() {
        return materiaux;
    }

    public void setMateriaux(Materiaux materiaux) {
        this.materiaux = materiaux;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public Volume getVolume() {
        return volume;
    }

    public void setVolume(Volume volume) {
        this.volume = volume;
    }

    public DetailsMateriauxStyle(Long id, Materiaux materiaux, Style style, Volume volume) {
        this.id = id;
        this.materiaux = materiaux;
        this.style = style;
        this.volume = volume;
    }

    public DetailsMateriauxStyle(Materiaux materiaux, Style style, Volume volume) {
        this.materiaux = materiaux;
        this.style = style;
        this.volume = volume;
    }

    public DetailsMateriauxStyle(Long id, Materiaux materiaux, Style style, Volume volume, double quantiteMateriaux) {
        this.id = id;
        this.materiaux = materiaux;
        this.style = style;
        this.volume = volume;
        this.quantiteMateriaux = quantiteMateriaux;
    }

    public DetailsMateriauxStyle(Materiaux materiaux, Style style, Volume volume, double quantiteMateriaux) {
        this.materiaux = materiaux;
        this.style = style;
        this.volume = volume;
        this.quantiteMateriaux = quantiteMateriaux;
    }
}
