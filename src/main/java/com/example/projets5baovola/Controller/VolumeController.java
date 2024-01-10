package com.example.projets5baovola.Controller;

import com.example.projets5baovola.model.Style;
import com.example.projets5baovola.model.Volume;
import com.example.projets5baovola.repository.VolumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class VolumeController {
    @Autowired
    VolumeRepository volumeRepository;
    @GetMapping("/insertVolume")
    public String home(){
        System.out.println(volumeRepository.findAll().get(1).getNomVolume());

        return "insertVolume";
    }

    @PostMapping("/volumepost")

    // type de retour pour un insert RedirectView
    public RedirectView newEtudiant(@ModelAttribute Volume volume){

        // on definit ici ou on va rediriger la fonction
        // ici exemple on le redirige vers le controller @GetMapping("/listUsers")
        final RedirectView redirectView = new RedirectView("/listMeuble", true);
        // et c est la qu on fait le traitement
        volumeRepository.save(volume);

        return redirectView;
    }




}
