package com.elevageavicole.gestion_elevage_avicole.controller;

import com.elevageavicole.gestion_elevage_avicole.model.LotPoulet;
import com.elevageavicole.gestion_elevage_avicole.service.LotPouletService;
import com.elevageavicole.gestion_elevage_avicole.service.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/statistiques")
public class StatistiqueController {

    @Autowired
    private LotPouletService lotPouletService;

    @Autowired
    private VenteService venteService;

    @GetMapping
    public String afficherStatistiques(Model model) {
        List<LotPoulet> lots = lotPouletService.findAllLots();

        int totalPouletsVivants = lots.stream()
                .mapToInt(LotPoulet::getNombrePouletsInitial)
                .sum();

        double poidsMoyenGlobal = lots.stream()
                .mapToDouble(LotPoulet::getPoidsMoyenPouletKg)
                .average()
                .orElse(0.0);

        double revenuTotalVentes = venteService.getTotalRevenuVentes();
        int totalPouletsVendus = venteService.getTotalPouletsVendus();

        model.addAttribute("totalPouletsVivants", totalPouletsVivants);
        model.addAttribute("poidsMoyenGlobal", poidsMoyenGlobal);
        model.addAttribute("revenuTotalVentes", revenuTotalVentes);
        model.addAttribute("totalPouletsVendus", totalPouletsVendus);

        return "statistiques/liste";
    }
}