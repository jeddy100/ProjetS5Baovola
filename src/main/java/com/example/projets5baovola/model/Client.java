package com.example.projets5baovola.model;

import jakarta.persistence.*;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    String nom;

    @ManyToOne
    @JoinColumn(name = "id_genre")
    private Genre genre;

    public Client() {

    }

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

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Client(Long id, String nom, Genre genre) {
        this.id = id;
        this.nom = nom;
        this.genre = genre;
    }

    public Client(String nom, Genre genre) {
        this.nom = nom;
        this.genre = genre;
    }
}
