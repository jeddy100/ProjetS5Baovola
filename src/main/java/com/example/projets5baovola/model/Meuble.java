package com.example.projets5baovola.model;

import com.example.projets5baovola.repository.MateriauxRepository;
import com.example.projets5baovola.repository.OuvrierMeubleRepository;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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

    private double tempsConfection;

    public Meuble() {

    }

    public double getTempsConfection() {
        return tempsConfection;
    }

    public void setTempsConfection(double tempsConfection) {
        this.tempsConfection = tempsConfection;
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
    public Meuble(Long id, Style style, Categorie categorie, Volume volume, String nom, double prix_vente, double tempsConfection) {
        this.id = id;
        this.style = style;
        this.categorie = categorie;
        this.volume = volume;
        this.nom = nom;
        this.prix_vente = prix_vente;
        this.tempsConfection = tempsConfection;
    }

    public Meuble(Style style, Categorie categorie, Volume volume, String nom, double prix_vente, double tempsConfection) {
        this.style = style;
        this.categorie = categorie;
        this.volume = volume;
        this.nom = nom;
        this.prix_vente = prix_vente;
        this.tempsConfection = tempsConfection;
    }

    public List<Object[]> getCombinedResult(List<Object[]> combinedResults,MateriauxRepository materiauxRepository){
        List<Object[]> materialsFromStyle =  materiauxRepository.getMaterialsForFurniture(this.getStyle(), this.getVolume());
        combinedResults.addAll(materialsFromStyle);


        List<Object[]> materialsFromCategory = materiauxRepository.getMaterialsForFurnitureByCategory(this.getCategorie(), this.getVolume());

        for (Object[] materialFromCategory : materialsFromCategory) {
            boolean exists = false;
            for (Object[] existingMaterial : combinedResults) {
                Materiaux material = (Materiaux) existingMaterial[0];
                if (material.equals(materialFromCategory[0])) {
                    // Si le matériau existe déjà, ajoutez les quantités
                    existingMaterial[1] = (Double) existingMaterial[1] + (Double) materialFromCategory[1];
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                // Si le matériau n'existe pas encore, ajoutez-le à la liste
                combinedResults.add(materialFromCategory);
            }
        }
        return combinedResults;
    }


    public double getPrixDeBase(List<Materiaux>materiauxList,List<Double>quantiteList){
        double prixbase=0;
        for (int i = 0; i <materiauxList.size() ; i++) {
            prixbase=prixbase+(materiauxList.get(i).getPrix()*quantiteList.get(i));
        }

        return prixbase;
    }

    public double calculerCoutProduction(Meuble meuble, OuvrierMeubleRepository ouvrierMeubleRepository) {
        // Récupérer le temps de construction du meuble
        double tempsConstruction = meuble.getTempsConfection();

        // Récupérer tous les ouvriers associés au meuble
        List<OuvrierMeuble> ouvrierMeubles = ouvrierMeubleRepository.findByMeuble(meuble);

        // Calculer le coût total de la main-d'œuvre
        double coutTotal = 0.0;
        for (OuvrierMeuble ouvrierMeuble : ouvrierMeubles) {
            double paieHoraire = ouvrierMeuble.getOuvrier().getPaieHoraire();
            int nombreOuvriers = ouvrierMeuble.getNombreOuvrier();
            double coutOuvrier = paieHoraire * tempsConstruction * nombreOuvriers;
            coutTotal += coutOuvrier;

            System.out.println("nom meuble:"+ meuble.getNom());
            System.out.println("fonctionOUvrier:"+ ouvrierMeuble.getOuvrier().getFonction());
            System.out.println("nombreOuvriers:"+ nombreOuvriers);
            System.out.println("paieHoraire:"+ paieHoraire);
            System.out.println("tempsConstruction:"+ tempsConstruction);

            System.out.println("/////////////////////////////////////////////");
        }

        return coutTotal;
    }


}
