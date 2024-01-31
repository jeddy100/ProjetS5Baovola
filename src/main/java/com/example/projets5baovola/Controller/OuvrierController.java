package com.example.projets5baovola.Controller;

import com.example.projets5baovola.model.Ouvrier;
import com.example.projets5baovola.model.Style;
import com.example.projets5baovola.repository.OuvrierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class OuvrierController {
    @Autowired
    OuvrierRepository ouvrierRepository;

    @GetMapping("/insertOuvrier")
    public String home(){
        return "insertOuvrier";
    }

    @PostMapping("/ouvrierpost")

    // type de retour pour un insert RedirectView
    public RedirectView newEtudiant(@ModelAttribute Ouvrier ouvrier){

        // on definit ici ou on va rediriger la fonction
        // ici exemple on le redirige vers le controller @GetMapping("/listUsers")
        final RedirectView redirectView = new RedirectView("/listMeuble", true);

        // et c est la qu on fait le traitement
        ouvrierRepository.save(ouvrier);

        return redirectView;
    }
}
