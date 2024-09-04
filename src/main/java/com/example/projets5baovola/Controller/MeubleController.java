package com.example.projets5baovola.Controller;

import com.example.projets5baovola.model.*;
import com.example.projets5baovola.repository.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Controller
public class MeubleController {
    @Autowired
    CategorieRepository categorieRepository;
    @Autowired
    StyleRepository styleRepository;
    @Autowired
    VolumeRepository volumeRepository;
    @Autowired
    private MeubleRepository meubleRepository;
    @Autowired
    private MateriauxRepository materiauxRepository;
    @Autowired
    OuvrierMeubleRepository ouvrierMeubleRepository;
    @Autowired
    private MouvementStockRepository mouvementStockRepository;
    @Autowired
    private VenteRepository venteRepository;
    @Autowired
    private GenreRepository genreRepository;

    @GetMapping("/insertMeuble")
    public String home(Model model){
        model.addAttribute("listCategorie", categorieRepository.findAll());
        model.addAttribute("listVolume", volumeRepository.findAll());
        model.addAttribute("listStyle",styleRepository.findAll());


        return "insertMeuble";
    }

    @PostMapping("/meublepost")
    public RedirectView newEtudiant(@RequestParam HashMap<String,Object> materiauxCategorie){


        // on definit ici ou on va rediriger la fonction
        // ici exemple on le redirige vers le controller @GetMapping("/listUsers")
        final RedirectView redirectView = new RedirectView("/listMeuble", true);
        double prixVente = Double.parseDouble((String) materiauxCategorie.get("prix_vente")) ;
        double tempsConfection=Double.parseDouble((String) materiauxCategorie.get("tempsConfection")) ;
        String nom=(String) materiauxCategorie.get("nom");
//        Categorie categorie= (Categorie) materiauxCategorie.get("categorie");
        System.out.println("categorie:"+materiauxCategorie.get("categorie"));
        System.out.println("style:"+materiauxCategorie.get("style"));

        System.out.println("volume:"+materiauxCategorie.get("volume"));

        Optional<Categorie> categorieopt=categorieRepository.findById(( Long.valueOf(String.valueOf(materiauxCategorie.get("categorie")))));
        Optional<Style> styleopt=styleRepository.findById((Long.valueOf(String.valueOf(materiauxCategorie.get("style")))));
        Optional<Volume>volumeOptional=volumeRepository.findById(( Long.valueOf(String.valueOf(materiauxCategorie.get("volume")))));
        Categorie categorie=null;
        Style style=null;
        Volume volume=null;
        if(categorieopt.isPresent() && styleopt.isPresent() && volumeOptional.isPresent()) {
            categorie = categorieopt.get();
            style=styleopt.get();
            volume=volumeOptional.get();
        }
        Meuble meuble=new Meuble(style, categorie, volume, nom, prixVente,tempsConfection);
        // et c est la qu on fait le traitement
        meubleRepository.save(meuble);

        return redirectView;
    }

    @GetMapping({"/listMeuble","/"})
    public String listMeuble(Model model){
        model.addAttribute("listMeuble", meubleRepository.findAll());
        return "listMeubles";
    }

    @GetMapping("/detailMeuble/{id}")
    public String detailMeuble(@PathVariable Long id, Model model){
        Optional<Meuble> meubleOptional =meubleRepository.findById(id);
        Meuble meuble=null;
        if(meubleOptional.isPresent()){
            meuble=meubleOptional.get();
        }
        double prixunitaire=meubleRepository.getprixDeBaseMeuble(meuble.getId(), meuble.getVolume().getId());
//        System.out.println("prix unitaire:"+ prixunitaire);
//        model.addAttribute("PU",prixunitaire);

        ///////////
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
        model.addAttribute("materiauxList", materiauxList);
        model.addAttribute("quantiteList", quantiteList);
        model.addAttribute("idmeuble",id);

        double prixDeBase=meuble.getPrixDeBase(materiauxList,quantiteList);
        System.out.println("prix de base= "+prixDeBase);
        model.addAttribute("PU",prixDeBase);
        double prixDeProduction=meuble.calculerCoutProduction(meuble,ouvrierMeubleRepository);
        model.addAttribute("prixDeProduction",prixDeProduction);
        System.out.println("prixDeProduction:"+prixDeProduction);
        double benefices=meuble.getPrix_vente()-(prixDeProduction+prixDeBase);
        model.addAttribute("benefices",benefices);




        return "detailmeuble";

    }

    @PostMapping("/prixbasepost")
    public String prix(Model model, @RequestParam("prix1") double prix1,@RequestParam("prix2") double prix2){
        List<Meuble> meubleList=meubleRepository.findAll();
        List<Meuble>meubleListRep=new ArrayList<>();
        for (int i = 0; i <meubleList.size() ; i++) {
            List<Object[]> combinedResults = new ArrayList<>();
            combinedResults= meubleList.get(i).getCombinedResult(combinedResults,materiauxRepository);

            List<Materiaux>materiauxList=new ArrayList<>();
            List<Double>quantiteList=new ArrayList<>();
            for (Object[] result : combinedResults) {
                Materiaux materiaux = (Materiaux) result[0];
                Double quantite = (Double) result[1];
                materiauxList.add(materiaux);
                quantiteList.add(quantite);

            }
            double rep=meubleList.get(i).getPrixDeBase(materiauxList,quantiteList);
            System.out.println("prix1:"+prix1);
            System.out.println("prix2:"+prix2);
            System.out.println("rep:"+rep);
            if (prix1<=rep && prix2>=rep)
            {
                System.out.println("prix1:"+prix1);
                System.out.println("prix2:"+prix2);
                System.out.println("rep:"+rep);
                meubleListRep.add(meubleList.get(i));
            }
            meubleListRep.forEach(System.out::println);
        }
        model.addAttribute("listemeuble",meubleListRep);

        return "meubleparprix";
    }

    @GetMapping("/prixbase")
    public String prixbase(Model model){
        return "prixbase";
    }

    @PostMapping("/nombremeublepost")
    public String newEtudian(Model model, @RequestParam("quantite") double nombreMeuble,@RequestParam("idmeuble") Long idmeuble) {
        Optional<Meuble> meubleOptional =meubleRepository.findById(idmeuble);
        int nombreMeublePossible=0;
        Meuble meuble=null;
        if(meubleOptional.isPresent()){
            meuble=meubleOptional.get();
        }
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
            double quantiteRequise = quantiteList.get(i) * nombreMeuble;
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
                double quantiteEnleve=nombreMeuble*quantiteList.get(i);
                System.out.println("tous les materiaux retires du stock ");
                mouvementStock.setTypeMouvement(2);
                mouvementStock.setMateriaux(materiaux);
                mouvementStock.setQuantite((int) quantiteEnleve);
                mouvementStockRepository.save(mouvementStock);

            }
        }

        if (stockSuffisant) {
            System.out.println("Stock suffisant pour créer " + nombreMeuble + " meubles");
            model.addAttribute("nombreMeublePossible",(int)nombreMeuble);

        } else {
            System.out.println("Stock insuffisant. Vous pouvez créer au maximum " + nombreMeublePossible + " meubles");
            model.addAttribute("nombreMeublePossible",nombreMeublePossible);
        }
        double test=mouvementStockRepository.sumQuantitiesByMaterialAndMovementType(materiauxList.get(0));
        System.out.println("------------------------------"+ test+materiauxList.get(0).getNom());

        return "meubledispo";
    }

    @GetMapping("/benefice")
    public String benefice(Model model){
        return "benefice";
    }

    @PostMapping("/beneficepost")
    public String benef(Model model, @RequestParam("prix1") double prix1,@RequestParam("prix2") double prix2){
        List<Meuble> meubleList=meubleRepository.findAll();
        List<Meuble>meubleListRep=new ArrayList<>();
        for (int i = 0; i <meubleList.size() ; i++) {
            List<Object[]> combinedResults = new ArrayList<>();
            combinedResults= meubleList.get(i).getCombinedResult(combinedResults,materiauxRepository);

            List<Materiaux>materiauxList=new ArrayList<>();
            List<Double>quantiteList=new ArrayList<>();
            for (Object[] result : combinedResults) {
                Materiaux materiaux = (Materiaux) result[0];
                Double quantite = (Double) result[1];
                materiauxList.add(materiaux);
                quantiteList.add(quantite);

            }
            double prixDeBase=meubleList.get(i).getPrixDeBase(materiauxList,quantiteList);
            double prixDeProduction=meubleList.get(i).calculerCoutProduction(meubleList.get(i),ouvrierMeubleRepository);
            double rep=meubleList.get(i).getPrix_vente()-(prixDeProduction+prixDeBase);


            System.out.println("prix1:"+prix1);
            System.out.println("prix2:"+prix2);
            System.out.println("rep:"+rep);
            if (prix1<=rep && prix2>=rep)
            {
                System.out.println("prix1:"+prix1);
                System.out.println("prix2:"+prix2);
                System.out.println("rep:"+rep);
                meubleListRep.add(meubleList.get(i));
            }
            meubleListRep.forEach(System.out::println);
        }
        model.addAttribute("listemeuble",meubleListRep);

        return "meubleparbenefice";
    }

    @GetMapping("/statMeuble/{id}")
    public String dtatMeuble(@PathVariable Long id, Model model){
        Optional<Meuble> meubleOptional =meubleRepository.findById(id);
        Meuble meuble=null;
        if(meubleOptional.isPresent()){
            meuble=meubleOptional.get();
        }
        int ventetotalmeuble=venteRepository.getTotalVentesByMeubleId(meuble.getId());
        List<Genre>genreList=genreRepository.findAll();
        for (int i = 0; i <genreList.size() ; i++) {
            System.out.println(genreList.get(i).getGenre()+ i);
        }
        Integer ventehomme=0;
        Integer ventefemme=0;
        if (venteRepository.getTotalVentesByMeubleAndGenre(meuble.getId(),genreList.get(0).getId())==0)
        {
             ventehomme=0;
        }
        else {
             ventehomme = venteRepository.getTotalVentesByMeubleAndGenre(meuble.getId(), genreList.get(0).getId());
        }
        if (venteRepository.getTotalVentesByMeubleAndGenre(meuble.getId(),genreList.get(1).getId())==0)
        {
            ventefemme=0;
        }
        else {
            ventefemme = venteRepository.getTotalVentesByMeubleAndGenre(meuble.getId(), genreList.get(1).getId());
        }

        model.addAttribute("ventetotalmeuble",ventetotalmeuble);
        model.addAttribute("ventehomme",ventehomme);
        model.addAttribute("ventefemme",ventefemme);

        System.out.println("vente totale="+ventetotalmeuble+"  ventehomme:"+ventehomme+"  ventefemme:"+ventefemme);
        return "statmeuble";
    }

    @GetMapping("/statotal")
    public String tatMeuble( Model model){

        int ventetotalmeuble=venteRepository.getTotalVentesByMeubleIdtsisy();
        List<Genre>genreList=genreRepository.findAll();
        for (int i = 0; i <genreList.size() ; i++) {
            System.out.println(genreList.get(i).getGenre()+ i);
        }
        Integer ventehomme=venteRepository.getTotalVentesByMeubleAndGenretsisy(genreList.get(0).getId());
        Integer ventefemme=venteRepository.getTotalVentesByMeubleAndGenretsisy(genreList.get(1).getId());

        model.addAttribute("ventetotalmeuble",ventetotalmeuble);
        model.addAttribute("ventehomme",ventehomme);
        model.addAttribute("ventefemme",ventefemme);

        System.out.println("vente totale="+ventetotalmeuble+"  ventehomme:"+ventehomme+"  ventefemme:"+ventefemme);
        return "stattotal";
    }
}
