package com.example.projets5baovola.Controller;

import com.example.projets5baovola.model.*;
import com.example.projets5baovola.repository.MeubleRepository;
import com.example.projets5baovola.repository.OuvrierMeubleRepository;
import com.example.projets5baovola.repository.OuvrierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Controller
public class OuvrierMeubleController {
    @Autowired
    OuvrierMeubleRepository ouvrierMeubleRepository;
    @Autowired
    private MeubleRepository meubleRepository;
    @Autowired
    private OuvrierRepository ouvrierRepository;

    @GetMapping("/insertOuvrierMeuble/{id}")
    public String detailMeuble(@PathVariable Long id, Model model){
        model.addAttribute("idmeuble",id);
        List<Ouvrier>ouvrierList=ouvrierRepository.findAll();
        model.addAttribute("ouvrierList",ouvrierList);

        return "insertOuvrierMeuble";

    }

    @PostMapping("/materiauxOuvrierpost")

    // type de retour pour un insert RedirectView
    public RedirectView newEtudiant(@RequestParam HashMap<String,Object> materiauxCategorie){


        // on definit ici ou on va rediriger la fonction
        // ici exemple on le redirige vers le controller @GetMapping("/listUsers")
        final RedirectView redirectView = new RedirectView("/listMeuble", true);
        int quantite = Integer.parseInt((String) materiauxCategorie.get("nombreOuvrier")) ;
        Long idmeuble= Long.valueOf((String) materiauxCategorie.get("idmeuble"));
//        Categorie categorie= (Categorie) materiauxCategorie.get("categorie");
        Optional<Ouvrier>ouvrierOptional=ouvrierRepository.findById(( Long.valueOf(String.valueOf(materiauxCategorie.get("ouvrier")))));
        Optional<Meuble>meubleOptional=meubleRepository.findById(idmeuble);
       Ouvrier ouvrier=null;
       Meuble meuble=null;
        if(ouvrierOptional.isPresent() && meubleOptional.isPresent()) {
           ouvrier=ouvrierOptional.get();
           meuble=meubleOptional.get();
        }
        // et c est la qu on fait le traitement
        OuvrierMeuble ouvrierMeuble=new OuvrierMeuble(meuble, ouvrier,quantite);
        ouvrierMeubleRepository.save(ouvrierMeuble);
        return redirectView;
    }
}
