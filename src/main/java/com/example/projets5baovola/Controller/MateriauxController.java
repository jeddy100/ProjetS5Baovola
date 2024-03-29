package com.example.projets5baovola.Controller;

import com.example.projets5baovola.model.Materiaux;
import com.example.projets5baovola.model.Users;
import com.example.projets5baovola.repository.MateriauxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class MateriauxController {
    @Autowired
    MateriauxRepository materiauxRepository;

    @GetMapping("/insertMateriaux")
    public String home(){
        return "insertMateriaux";
    }

    @PostMapping("/materiauxpost")

    // type de retour pour un insert RedirectView
    public RedirectView newEtudiant(@ModelAttribute Materiaux materiaux){

        // on definit ici ou on va rediriger la fonction
        // ici exemple on le redirige vers le controller @GetMapping("/listUsers")
        final RedirectView redirectView = new RedirectView("/listMeuble", true);

        // et c est la qu on fait le traitement
        materiauxRepository.save(materiaux);

        return redirectView;
    }

}
