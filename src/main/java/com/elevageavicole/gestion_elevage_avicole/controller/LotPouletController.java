package com.elevageavicole.gestion_elevage_avicole.controller;

import com.elevageavicole.gestion_elevage_avicole.model.LotPoulet;
import com.elevageavicole.gestion_elevage_avicole.service.LotPouletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/lots")
public class LotPouletController {

    @Autowired
    private LotPouletService lotPouletService;

    @GetMapping
    public String listerLots(Model model) {
        List<LotPoulet> lots = lotPouletService.findAllLots();
        model.addAttribute("lots", lots);
        return "lots/liste";
    }

    @GetMapping("/ajouter")
    public String afficherFormulaireAjout(Model model) {
        model.addAttribute("lotPoulet", new LotPoulet());
        return "lots/formulaire";
    }

    @PostMapping("/sauvegarder")
    public String sauvegarderLot(@ModelAttribute LotPoulet lotPoulet) {
        lotPouletService.saveLot(lotPoulet);
        return "redirect:/lots";
    }

    @GetMapping("/modifier/{id}")
    public String afficherFormulaireModification(@PathVariable Long id, Model model) {
        Optional<LotPoulet> lotPoulet = lotPouletService.findLotById(id);
        if (lotPoulet.isPresent()) {
            model.addAttribute("lotPoulet", lotPoulet.get());
            return "lots/formulaire";
        }
        return "redirect:/lots";
    }

    @GetMapping("/supprimer/{id}")
    public String supprimerLot(@PathVariable Long id) {
        lotPouletService.deleteLot(id);
        return "redirect:/lots";
    }
}