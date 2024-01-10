package com.example.projets5baovola.Controller;

import com.example.projets5baovola.model.*;
import com.example.projets5baovola.repository.DetailsMateriauxStyleRepository;
import com.example.projets5baovola.repository.MateriauxRepository;
import com.example.projets5baovola.repository.StyleRepository;
import com.example.projets5baovola.repository.VolumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.HashMap;
import java.util.Optional;

@Controller
public class DetailsMateriauxStyleController {

    @Autowired
    StyleRepository styleRepository;
    @Autowired
    MateriauxRepository materiauxRepository;
    @Autowired
    VolumeRepository volumeRepository;
    @Autowired
    DetailsMateriauxStyleRepository
    detailsMateriauxStyleRepository;

    @GetMapping("/insertDetailsMateriauxStyle")
    public String home(Model model){
        model.addAttribute("listStyle", styleRepository.findAll());
        model.addAttribute("listMateriaux", materiauxRepository.findAll());
        model.addAttribute("listvolume", volumeRepository.findAll());


        return "insertDetailsMateriauxStyle";
    }

    @PostMapping("/detailsmateriauxstylepost")

    // type de retour pour un insert RedirectView
    public RedirectView newEtudiant(@RequestParam HashMap<String,Object> materiauxCategorie){


        // on definit ici ou on va rediriger la fonction
        // ici exemple on le redirige vers le controller @GetMapping("/listUsers")
        final RedirectView redirectView = new RedirectView("/listMeuble", true);
        int quantite = Integer.parseInt((String) materiauxCategorie.get("quantiteMateriaux")) ;
//        Categorie categorie= (Categorie) materiauxCategorie.get("categorie");
        System.out.println("categorie:"+materiauxCategorie.get("style"));
        System.out.println("materiaux:"+materiauxCategorie.get("materiaux"));

        System.out.println("volume:"+materiauxCategorie.get("volume"));

        Optional<Style> styleopt=styleRepository.findById((Long.valueOf(String.valueOf(materiauxCategorie.get("style")))));
        Optional<Materiaux> materiauxOptional=materiauxRepository.findById((Long.valueOf(String.valueOf(materiauxCategorie.get("materiaux")))));
        Optional<Volume>volumeOptional=volumeRepository.findById(( Long.valueOf(String.valueOf(materiauxCategorie.get("volume")))));
        Style style=null;
        Materiaux materiaux=null;
        Volume volume=null;
        if(styleopt.isPresent() && materiauxOptional.isPresent() && volumeOptional.isPresent()) {
            style = styleopt.get();
            materiaux=materiauxOptional.get();
            volume=volumeOptional.get();
        }
        DetailsMateriauxStyle detailsMateriauxstyle=new DetailsMateriauxStyle(materiaux, style, volume, quantite);
        // et c est la qu on fait le traitement
        detailsMateriauxStyleRepository.save(detailsMateriauxstyle);

        return redirectView;
    }
}
