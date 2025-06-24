package com.elevageavicole.gestion_elevage_avicole.service;

import com.elevageavicole.gestion_elevage_avicole.model.Vente;
import com.elevageavicole.gestion_elevage_avicole.repository.VenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VenteService {

    @Autowired
    private VenteRepository venteRepository;

    public List<Vente> findAllVentes() {
        return venteRepository.findAll();
    }

    public Optional<Vente> findVenteById(Long id) {
        return venteRepository.findById(id);
    }

    public Vente saveVente(Vente vente) {

        if (vente.getPoidsTotalVenduKg() != 0 && vente.getPrixUnitaireKg() != 0) {
            vente.setMontantTotal(vente.getPoidsTotalVenduKg() * vente.getPrixUnitaireKg());
        }
        return venteRepository.save(vente);
    }

    public void deleteVente(Long id) {
        venteRepository.deleteById(id);
    }



    public double getTotalRevenuVentes() {
        return venteRepository.findAll().stream()
                .mapToDouble(Vente::getMontantTotal)
                .sum();
    }

    public int getTotalPouletsVendus() {
        return venteRepository.findAll().stream()
                .mapToInt(Vente::getNombrePouletsVendus)
                .sum();
    }


}