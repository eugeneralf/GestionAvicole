package com.elevageavicole.gestion_elevage_avicole.controller;

import com.elevageavicole.gestion_elevage_avicole.model.Aliment;
import com.elevageavicole.gestion_elevage_avicole.repository.AlimentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/aliments")
public class AlimentController {

    @Autowired
    private AlimentRepository alimentRepository;

    @GetMapping
    public String listerAliments(Model model) {
        List<Aliment> aliments = alimentRepository.findAll();
        model.addAttribute("aliments", aliments);
        return "aliments/liste";
    }

    @GetMapping("/ajouter")
    public String afficherFormulaireAjout(Model model) {
        model.addAttribute("aliment", new Aliment());
        return "aliments/formulaire";
    }

    @GetMapping("/modifier/{id}")
    public String afficherFormulaireModification(@PathVariable Long id, Model model) {
        Optional<Aliment> aliment = alimentRepository.findById(id);
        if (aliment.isPresent()) {
            model.addAttribute("aliment", aliment.get());
            return "aliments/formulaire";
        }
        return "redirect:/aliments";
    }

    @PostMapping("/sauvegarder")
    public String sauvegarderAliment(@ModelAttribute Aliment aliment) {
        alimentRepository.save(aliment);
        return "redirect:/aliments";
    }

    @GetMapping("/supprimer/{id}")
    public String supprimerAliment(@PathVariable Long id) {
        alimentRepository.deleteById(id);
        return "redirect:/aliments";
    }
}