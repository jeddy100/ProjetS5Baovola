package com.example.projets5baovola.Controller;

import com.example.projets5baovola.model.Users;
import com.example.projets5baovola.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserRepository userRepository;



    @GetMapping("/listUsers")
    public String listUsers(Model model){
        model.addAttribute("listUsers", userRepository.findAll());
        return "listUsers";
    }

    @PostMapping("/userpost")

    // type de retour pour un insert RedirectView
    public RedirectView newEtudiant(@ModelAttribute Users users){

        // on definit ici ou on va rediriger la fonction
        // ici exemple on le redirige vers le controller @GetMapping("/listUsers")
        final RedirectView redirectView = new RedirectView("/listUsers", true);

        // et c est la qu on fait le traitement
        userRepository.save(users);

        return redirectView;
    }
    @GetMapping("/insertUser")
    public String home(){
        return "insertUser";
    }

}
