package com.example.projets5baovola.Controller;

import com.example.projets5baovola.model.*;
import com.example.projets5baovola.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Controller
public class Ventecontroller {
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    private GenreRepository genreRepository;
    @Autowired
    private MeubleRepository meubleRepository;
    @Autowired
    private VenteRepository venteRepository;
    @Autowired
    private MouvementStockRepository mouvementStockRepository;
    @Autowired MateriauxRepository materiauxRepository;

    @GetMapping("/insertVente")
    public String home(Model model){
        model.addAttribute("listClient",clientRepository.findAll());
        model.addAttribute("listMeuble",meubleRepository.findAll());
        return "insertVente";
    }

    @PostMapping("/ventepost")
    public String newEtudiant(@RequestParam HashMap<String,Object> emp,Model model){
        Vente vente=new Vente();


        // on definit ici ou on va rediriger la fonction
        // ici exemple on le redirige vers le controller @GetMapping("/listUsers")
        int nombre=  Integer.valueOf(String.valueOf(emp.get("nombre")));
        Optional<Client> clientOptional=clientRepository.findById(Long.valueOf(String.valueOf(emp.get("client"))));
        Optional<Meuble> meubleOptional=meubleRepository.findById(Long.valueOf(String.valueOf(emp.get("meuble"))));
        Client client=new Client();
        Meuble meuble=new Meuble();
        if(clientOptional.isPresent() && meubleOptional.isPresent()){
            client=clientOptional.get();
            meuble=meubleOptional.get();
        }

        ///////////////////////////////////////////////ADAPTATION//////////////////////////////
        int nombreMeublePossible=0;
        List<Object[]> combinedResults = new ArrayList<>();

        combinedResults=meuble.getCombinedResult(combinedResults,materiauxRepository);

        List<Materiaux>materiauxList=new ArrayList<>();
        List<Double>quantiteList=new ArrayList<>();
        for (Object[] result : combinedResults) {
            Materiaux materiaux = (Materiaux) result[0];
            Double quantite = (Double) result[1];
            materiauxList.add(materiaux);
            quantiteList.add(quantite);

        }
        boolean stockSuffisant = true;

        nombreMeublePossible = Integer.MAX_VALUE;

        for (int i = 0; i < materiauxList.size(); i++) {
            Materiaux materiaux = materiauxList.get(i);
            double quantiteRequise = quantiteList.get(i) * nombre;
            double stock=0;
            try {
                // Obtenir le stock pour le matériau actuel
                stock = mouvementStockRepository.sumQuantitiesByMaterialAndMovementType(materiaux);
            }
            catch (Exception e){
                System.out.println("pas de meteriaux pour ce meuble");
            }

            System.out.println(materiaux.getNom() + " - Stock disponible : " + stock + ", Quantité requise : " + quantiteRequise);

            int nombrePossibleAvecStock=0;
            if (stock < quantiteRequise) {
                stockSuffisant = false;
                // Calculer le nombre maximum de meubles possibles en fonction du stock
                nombrePossibleAvecStock = (int) (stock / quantiteList.get(i));
                nombreMeublePossible = Math.min(nombreMeublePossible, nombrePossibleAvecStock);
                MouvementStock mouvementStock=new MouvementStock();
                double quantiteEnleve=nombreMeublePossible*quantiteList.get(i);
                System.out.println("materiaux suffisants retires du stock");
                mouvementStock.setTypeMouvement(2);
                mouvementStock.setMateriaux(materiaux);
                mouvementStock.setQuantite((int) quantiteEnleve);
                mouvementStockRepository.save(mouvementStock);


            } else if (stockSuffisant) {
                MouvementStock mouvementStock=new MouvementStock();
                double quantiteEnleve=nombre*quantiteList.get(i);
                System.out.println("tous les materiaux retires du stock ");
                mouvementStock.setTypeMouvement(2);
                mouvementStock.setMateriaux(materiaux);
                mouvementStock.setQuantite((int) quantiteEnleve);
                mouvementStockRepository.save(mouvementStock);

            }
        }

        if (stockSuffisant) {
            System.out.println("Stock suffisant pour créer " + nombre + " meubles");
            model.addAttribute("nombreMeublePossible",(int)nombre);
            vente.setNombre(nombre);


        } else {
            System.out.println("Stock insuffisant. Vous pouvez créer au maximum " + nombreMeublePossible + " meubles");
            model.addAttribute("nombreMeublePossible",nombreMeublePossible);
            vente.setNombre(nombreMeublePossible);

        }
        double test=mouvementStockRepository.sumQuantitiesByMaterialAndMovementType(materiauxList.get(0));
        System.out.println("------------------------------"+ test+materiauxList.get(0).getNom());


        /////////////////////////////////////////FIN/////////////////////////////////////////
        vente.setClient(client);
        vente.setMeuble(meuble);
        venteRepository.save(vente);


        return "meubledispo";    }






}
