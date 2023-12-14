package com.example.projets5baovola.Controller;

import com.example.projets5baovola.model.Materiaux;
import com.example.projets5baovola.model.Style;
import com.example.projets5baovola.repository.StyleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class StyleController {
    @Autowired
    StyleRepository styleRepository;

    @GetMapping("/insertStyle")
    public String home(){
        return "insertStyle";
    }

    @PostMapping("/stylepost")

    // type de retour pour un insert RedirectView
    public RedirectView newEtudiant(@ModelAttribute Style style){

        // on definit ici ou on va rediriger la fonction
        // ici exemple on le redirige vers le controller @GetMapping("/listUsers")
        final RedirectView redirectView = new RedirectView("/listUsers", true);

        // et c est la qu on fait le traitement
        styleRepository.save(style);

        return redirectView;
    }
}
