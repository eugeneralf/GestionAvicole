package com.elevageavicole.gestion_elevage_avicole.controller;

import com.elevageavicole.gestion_elevage_avicole.model.LotPoulet;
import com.elevageavicole.gestion_elevage_avicole.model.Vente;
import com.elevageavicole.gestion_elevage_avicole.service.LotPouletService;
import com.elevageavicole.gestion_elevage_avicole.service.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private LotPouletService lotPouletService;

    @Autowired
    private VenteService venteService;

    @GetMapping("/")
    public String dashboard(Model model) {
        List<LotPoulet> tousLesLots = lotPouletService.findAllLots();
        List<Vente> toutesLesVentes = venteService.findAllVentes();

        int totalPouletsInitiaux = tousLesLots.stream()
                .mapToInt(LotPoulet::getNombrePouletsInitial)
                .sum();

        long nombreTotalLots = tousLesLots.size();

        int totalPouletsVendus = toutesLesVentes.stream()
                .mapToInt(Vente::getNombrePouletsVendus)
                .sum();
        double totalMontantVentes = toutesLesVentes.stream()
                .mapToDouble(Vente::getMontantTotal)
                .sum();

        model.addAttribute("totalPouletsInitiaux", totalPouletsInitiaux);
        model.addAttribute("nombreTotalLots", nombreTotalLots);
        model.addAttribute("totalPouletsVendus", totalPouletsVendus);
        model.addAttribute("totalMontantVentes", totalMontantVentes);

        return "index";
    }
}