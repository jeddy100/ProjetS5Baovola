package com.example.projets5baovola.Controller;

import com.example.projets5baovola.model.Categorie;
import com.example.projets5baovola.model.DetailsMateriauxCategorie;
import com.example.projets5baovola.model.Materiaux;
import com.example.projets5baovola.model.Volume;
import com.example.projets5baovola.repository.CategorieRepository;
import com.example.projets5baovola.repository.DetailsMateriauxCategorieRepository;
import com.example.projets5baovola.repository.MateriauxRepository;
import com.example.projets5baovola.repository.VolumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.swing.text.html.Option;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Controller
public class DetailsMateriauxCategorieController {

    @Autowired
    VolumeRepository volumeRepository;
    @Autowired
    DetailsMateriauxCategorieRepository detailsMateriauxCategorieRepository;
    @Autowired
    private CategorieRepository categorieRepository;
    @Autowired
    private MateriauxRepository materiauxRepository;


    @GetMapping("/insertDetailsMateriauxCategorie")
    public String home(Model model){
        model.addAttribute("listCategorie", categorieRepository.findAll());
        model.addAttribute("listMateriaux", materiauxRepository.findAll());
        model.addAttribute("listvolume", volumeRepository.findAll());


        return "insertDetailsMateriauxCategorie";
    }

    @PostMapping("/detailsmateriauxcategoriepost")

    // type de retour pour un insert RedirectView
    public RedirectView newEtudiant(@RequestParam HashMap<String,Object> materiauxCategorie){


        // on definit ici ou on va rediriger la fonction
        // ici exemple on le redirige vers le controller @GetMapping("/listUsers")
        final RedirectView redirectView = new RedirectView("/listMeuble", true);
        int quantite = Integer.parseInt((String) materiauxCategorie.get("quantiteMateriaux")) ;
//        Categorie categorie= (Categorie) materiauxCategorie.get("categorie");
        System.out.println("categorie:"+materiauxCategorie.get("categorie"));
        System.out.println("materiaux:"+materiauxCategorie.get("materiaux"));

        System.out.println("volume:"+materiauxCategorie.get("volume"));

        Optional<Categorie> categorieopt=categorieRepository.findById(( Long.valueOf(String.valueOf(materiauxCategorie.get("categorie")))));
        Optional<Materiaux> materiauxOptional=materiauxRepository.findById((Long.valueOf(String.valueOf(materiauxCategorie.get("materiaux")))));
        Optional<Volume>volumeOptional=volumeRepository.findById(( Long.valueOf(String.valueOf(materiauxCategorie.get("volume")))));
        Categorie categorie=null;
        Materiaux materiaux=null;
        Volume volume=null;
        if(categorieopt.isPresent() && materiauxOptional.isPresent() && volumeOptional.isPresent()) {
            categorie = categorieopt.get();
            materiaux=materiauxOptional.get();
            volume=volumeOptional.get();
        }
        DetailsMateriauxCategorie detailsMateriauxCategorie=new DetailsMateriauxCategorie(materiaux, categorie, volume, quantite);
        // et c est la qu on fait le traitement
        detailsMateriauxCategorieRepository.save(detailsMateriauxCategorie);

        return redirectView;
    }

}
