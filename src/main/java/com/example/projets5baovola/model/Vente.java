package com.example.projets5baovola.model;

import jakarta.persistence.*;

@Entity
public class Vente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "id_meuble")
    private Meuble meuble;

    int nombre;

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public Vente() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Meuble getMeuble() {
        return meuble;
    }

    public void setMeuble(Meuble meuble) {
        this.meuble = meuble;
    }

    public Vente(Long id, Client client, Meuble meuble) {
        this.id = id;
        this.client = client;
        this.meuble = meuble;
    }

    public Vente(Client client, Meuble meuble) {
        this.client = client;
        this.meuble = meuble;
    }

    public Vente(Long id, Client client, Meuble meuble, int nombre) {
        this.id = id;
        this.client = client;
        this.meuble = meuble;
        this.nombre = nombre;
    }

    public Vente(Client client, Meuble meuble, int nombre) {
        this.client = client;
        this.meuble = meuble;
        this.nombre = nombre;
    }
}
