package com.elevageavicole.gestion_elevage_avicole.controller;

import com.elevageavicole.gestion_elevage_avicole.model.Vente;
import com.elevageavicole.gestion_elevage_avicole.model.LotPoulet;
import com.elevageavicole.gestion_elevage_avicole.service.VenteService;
import com.elevageavicole.gestion_elevage_avicole.service.LotPouletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter; // Pour formater les dates si besoin, bien que Thymeleaf le fasse
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/ventes")
public class VenteController {

    @Autowired
    private VenteService venteService;

    @Autowired
    private LotPouletService lotPouletService;

    @GetMapping
    public String listerVentes(Model model) {
        List<Vente> ventes = venteService.findAllVentes();
        model.addAttribute("ventes", ventes);
        return "ventes/liste";
    }

    @GetMapping("/ajouter")
    public String afficherFormulaireAjout(Model model) {
        model.addAttribute("vente", new Vente());
        model.addAttribute("lots", lotPouletService.findAllLots());
        return "ventes/formulaire";
    }

    @PostMapping("/sauvegarder")
    public String sauvegarderVente(@ModelAttribute Vente vente) {
        if (vente.getLotPoulet() != null && vente.getLotPoulet().getId() != null) {
            Optional<LotPoulet> lotOptional = lotPouletService.findLotById(vente.getLotPoulet().getId());
            lotOptional.ifPresent(vente::setLotPoulet);
        } else {
            System.out.println("Erreur: Un lot de poulet doit être sélectionné pour la vente.");
            return "redirect:/ventes/ajouter?error=lotMissing";
        }

        venteService.saveVente(vente);
        return "redirect:/ventes";
    }

    @GetMapping("/modifier/{id}")
    public String afficherFormulaireModification(@PathVariable Long id, Model model) {
        Optional<Vente> vente = venteService.findVenteById(id);
        if (vente.isPresent()) {
            model.addAttribute("vente", vente.get());
            model.addAttribute("lots", lotPouletService.findAllLots());
            return "ventes/formulaire";
        }
        return "redirect:/ventes";
    }

    @GetMapping("/supprimer/{id}")
    public String supprimerVente(@PathVariable Long id) {
        venteService.deleteVente(id);
        return "redirect:/ventes";
    }
}