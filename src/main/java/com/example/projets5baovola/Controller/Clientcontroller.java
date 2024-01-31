package com.example.projets5baovola.Controller;

import com.example.projets5baovola.model.*;
import com.example.projets5baovola.repository.ClientRepository;
import com.example.projets5baovola.repository.GenreRepository;
import com.example.projets5baovola.repository.StyleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Controller
public class Clientcontroller {
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    private GenreRepository genreRepository;

    @GetMapping("/insertClient")
    public String home(Model model){
        model.addAttribute("listGenre",genreRepository.findAll());
        return "insertClient";
    }

    @PostMapping("/clientpost")
    public RedirectView newEtudiant(@RequestParam HashMap<String,Object> emp){


        // on definit ici ou on va rediriger la fonction
        // ici exemple on le redirige vers le controller @GetMapping("/listUsers")
        final RedirectView redirectView = new RedirectView("/listMeuble", true);
        String nom= (String) emp.get("nom");

        Optional<Genre> genreOptional=genreRepository.findById(Long.valueOf(String.valueOf(emp.get("genre"))));
        Genre genre=new Genre();
        if(genreOptional.isPresent()){
            genre=genreOptional.get();
        }
        Client client=new Client();
        client.setNom(nom);
        client.setGenre(genre);
        clientRepository.save(client);


        return redirectView;
    }


}
