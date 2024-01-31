package com.example.projets5baovola.Controller;

import com.example.projets5baovola.model.*;
import com.example.projets5baovola.repository.MateriauxRepository;
import com.example.projets5baovola.repository.StockRepository;
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
public class StockController {
    @Autowired
    StockRepository stockRepository;

    @Autowired
    MateriauxRepository materiauxRepository;

    @GetMapping("/insertStock")
    public String home(Model model){
        model.addAttribute("listMateriaux", materiauxRepository.findAll());
        return "insertStock";
    }

    @PostMapping("/stockpost")

    // type de retour pour un insert RedirectView
    public RedirectView newEtudiant(@RequestParam HashMap<String,Object> stock){


        // on definit ici ou on va rediriger la fonction
        // ici exemple on le redirige vers le controller @GetMapping("/listUsers")
        final RedirectView redirectView = new RedirectView("/listMeuble", true);
        int quantite = Integer.parseInt((String) stock.get("quantiteMateriaux")) ;

        Optional<Materiaux> materiauxOptional=materiauxRepository.findById((Long.valueOf(String.valueOf(stock.get("materiaux")))));
        Materiaux materiaux=null;
        if(materiauxOptional.isPresent()) {
            materiaux=materiauxOptional.get();
        }
        Stock stock1=new Stock(quantite, materiaux);
        // et c est la qu on fait le traitement
        stockRepository.save(stock1);

        return redirectView;
    }


}
