package com.elevageavicole.gestion_elevage_avicole.service;

import com.elevageavicole.gestion_elevage_avicole.model.Aliment;
import com.elevageavicole.gestion_elevage_avicole.repository.AlimentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlimentService {

    @Autowired
    private AlimentRepository alimentRepository;

    public List<Aliment> findAllAliments() {
        return alimentRepository.findAll();
    }

    public Optional<Aliment> findAlimentById(Long id) {
        return alimentRepository.findById(id);
    }

    public Aliment saveAliment(Aliment aliment) {
        return alimentRepository.save(aliment);
    }

    public void deleteAliment(Long id) {
        alimentRepository.deleteById(id);
    }

    public double getTotalQuantiteAlimentStock() {
        return findAllAliments().stream().mapToDouble(Aliment::getQuantiteStockKg).sum();
    }
}