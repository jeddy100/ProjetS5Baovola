package com.example.projets5baovola.Controller;

import com.example.projets5baovola.model.Materiaux;
import com.example.projets5baovola.model.MouvementStock;
import com.example.projets5baovola.model.Stock;
import com.example.projets5baovola.repository.MateriauxRepository;
import com.example.projets5baovola.repository.MouvementStockRepository;
import com.example.projets5baovola.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Controller
public class MouvementStockController {
    @Autowired
    MouvementStockRepository mouvementStockRepository;

    @Autowired
    MateriauxRepository materiauxRepository;

    @GetMapping("/insertMouvementStock")
    public String home(Model model){
        model.addAttribute("listMateriaux", materiauxRepository.findAll());
        return "insertStock";
    }

    @PostMapping("/mouvementstockpost")
    public RedirectView newEtudiant(@RequestParam HashMap<String,Object> stock){


        // on definit ici ou on va rediriger la fonction
        // ici exemple on le redirige vers le controller @GetMapping("/listUsers")
        final RedirectView redirectView = new RedirectView("/listMeuble", true);
        int quantite = Integer.parseInt((String) stock.get("quantiteMateriaux")) ;
        int type=1;

        Optional<Materiaux> materiauxOptional=materiauxRepository.findById((Long.valueOf(String.valueOf(stock.get("materiaux")))));
        Materiaux materiaux=null;
        if(materiauxOptional.isPresent()) {
            materiaux=materiauxOptional.get();
        }
        MouvementStock stock1=new MouvementStock(quantite, materiaux,type);
        // et c est la qu on fait le traitement
        mouvementStockRepository.save(stock1);

        return redirectView;
    }

    @GetMapping({"/listStock"})
    public String listMeuble(Model model){
        List<Materiaux>materiauxList=materiauxRepository.findAll();
        List<Double> listenbmateriaux=new ArrayList<>();
        for (int i = 0; i <materiauxList.size() ; i++) {
            if (mouvementStockRepository.sumQuantitiesByMaterialAndMovementType(materiauxList.get(i))==0){
                listenbmateriaux.add(Double.valueOf(0));
            }
            else {
                listenbmateriaux.add(mouvementStockRepository.sumQuantitiesByMaterialAndMovementType(materiauxList.get(i)));
            }
        }


        model.addAttribute("materiauxList", materiauxList);
        model.addAttribute("listenbmateriaux", listenbmateriaux);
        return "listStocks";
    }


}
