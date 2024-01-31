package com.example.projets5baovola.Controller;

import com.example.projets5baovola.model.*;
import com.example.projets5baovola.repository.EmployeRepository;
import com.example.projets5baovola.repository.OuvrierRepository;
import com.example.projets5baovola.repository.RangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
public class EmployeController {

    @Autowired
    private  OuvrierRepository ouvrierRepository;
    @Autowired
    private  EmployeRepository employeRepository;
    @Autowired
    private RangRepository rangRepository;


    @GetMapping("/insertEmploye")
    public String home(Model model){
        model.addAttribute("listOuvrier", ouvrierRepository.findAll());


        return "insertEmploye";
    }

    @PostMapping("/employepost")
    public RedirectView newEtudiant(@RequestParam HashMap<String,Object> emp){


        // on definit ici ou on va rediriger la fonction
        // ici exemple on le redirige vers le controller @GetMapping("/listUsers")
        final RedirectView redirectView = new RedirectView("/listEmploye", true);
        String nom= (String) emp.get("nom");
        String date= (String) emp.get("dateEmbauche");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate dateEmbauche=LocalDate.parse(date, formatter);

        Optional<Ouvrier> ouvrierOptional=ouvrierRepository.findById(Long.valueOf(String.valueOf(emp.get("ouvrier"))));
        Ouvrier ouvrier=new Ouvrier();
        if(ouvrierOptional.isPresent()){
            ouvrier=ouvrierOptional.get();
        }

        /////////////fonction difference de date
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(dateEmbauche, currentDate);
        int annees=period.getYears();
        System.out.println("annees de travail:"+annees);
        Employe employe=new Employe();
        employe.setNom(nom);
        employe.setDateEmbauche(dateEmbauche);
        employe.setOuvrier(ouvrier);
        List<Rang>rangList=rangRepository.findAll();
        for (int i = 0; i < rangList.size(); i++) {
            if(annees>=rangList.get(i).getDebut() && annees<=rangList.get(i).getFin())
            {
                employe.setPaiehoraire(ouvrier.getPaieHoraire()*rangList.get(i).getMultiplicateur());
                employe.setRang(rangList.get(i).getNomrang());
                employeRepository.save(employe);


            }

        }

        return redirectView;
    }

    @GetMapping({"/listEmploye"})
    public String listMeuble(Model model){
        model.addAttribute("listEmploye", employeRepository.findAll());
        return "listEmployes";
    }

    @PostMapping("/employesearchpost")
    public String listEmp(@RequestParam HashMap<String,Object> emp,Model model) {


        // on definit ici ou on va rediriger la fonction
        // ici exemple on le redirige vers le controller @GetMapping("/listUsers")
        String recherche = (String) emp.get("recherche");
        List<Employe>employeList=employeRepository.searchByTerm(recherche);
        model.addAttribute("listEmploye",employeList);


        return "listEmployessearch";    }
}
