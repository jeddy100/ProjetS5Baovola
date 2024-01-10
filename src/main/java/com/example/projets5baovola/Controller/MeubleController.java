package com.example.projets5baovola.Controller;

import com.example.projets5baovola.model.*;
import com.example.projets5baovola.repository.CategorieRepository;
import com.example.projets5baovola.repository.MeubleRepository;
import com.example.projets5baovola.repository.StyleRepository;
import com.example.projets5baovola.repository.VolumeRepository;
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
        Meuble meuble=new Meuble(style, categorie, volume, nom, prixVente);
        // et c est la qu on fait le traitement
        meubleRepository.save(meuble);

        return redirectView;
    }

    @GetMapping("/listMeuble")
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
        System.out.println("prix unitaire:"+ prixunitaire);
        model.addAttribute("PU",prixunitaire);

        return "detailmeuble";

    }

    @PostMapping("/prixbasepost")
    public String prix(Model model, @RequestParam("prix1") double prix1,@RequestParam("prix2") double prix2){
        List<Meuble> meubleList=meubleRepository.findAll();
        List<Meuble>meubleListRep=new ArrayList<>();
        for (int i = 0; i <meubleList.size() ; i++) {
            double rep=meubleRepository.getprixDeBaseMeuble(meubleList.get(i).getId(),meubleList.get(i).getVolume().getId());
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


}
