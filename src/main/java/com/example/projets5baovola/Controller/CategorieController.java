package com.example.projets5baovola.Controller;

import com.example.projets5baovola.model.Categorie;
import com.example.projets5baovola.model.Materiaux;
import com.example.projets5baovola.repository.CategorieRepository;
import com.example.projets5baovola.repository.MateriauxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class CategorieController {
    @Autowired
    CategorieRepository categorieRepository;

    @Autowired
    MateriauxRepository materiauxRepository;

    @GetMapping("/insertCategorie")
    public String home(){
        return "insertCategorie";
    }

    @PostMapping("/categoriepost")

    // type de retour pour un insert RedirectView
    public RedirectView newEtudiant(@ModelAttribute Categorie categorie){

        // on definit ici ou on va rediriger la fonction
        // ici exemple on le redirige vers le controller @GetMapping("/listUsers")
        final RedirectView redirectView = new RedirectView("/listMeuble", true);

        // et c est la qu on fait le traitement
        categorieRepository.save(categorie);

        return redirectView;
    }

    @GetMapping("/insertCategorieMateriaux")
    public String listUsers(Model model){
        model.addAttribute("listCategorie", categorieRepository.findAll());
        model.addAttribute("listMateriaux", materiauxRepository.findAll());
        return "insertDetailsMateriauxCategorie";
    }
}
