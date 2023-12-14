package com.example.projets5baovola.Controller;

import com.example.projets5baovola.model.DetailsMateriauxCategorie;
import com.example.projets5baovola.model.Materiaux;
import com.example.projets5baovola.repository.DetailsMateriauxCategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class DetailsMateriauxCategorieController {
    @Autowired
    DetailsMateriauxCategorieRepository detailsMateriauxCategorieRepository;

    @GetMapping("/insertDetailsMateriauxCategorie")
    public String home(){
        return "insertDetailsMateriauxCategorie";
    }

    @PostMapping("/detailsmateriauxcategoriepost")

    // type de retour pour un insert RedirectView
    public RedirectView newEtudiant(@ModelAttribute DetailsMateriauxCategorie materiaux){

        // on definit ici ou on va rediriger la fonction
        // ici exemple on le redirige vers le controller @GetMapping("/listUsers")
        final RedirectView redirectView = new RedirectView("/listUsers", true);

        // et c est la qu on fait le traitement
        detailsMateriauxCategorieRepository.save(materiaux);

        return redirectView;
    }

}
