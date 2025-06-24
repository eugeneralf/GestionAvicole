package com.elevageavicole.gestion_elevage_avicole.service;

import com.elevageavicole.gestion_elevage_avicole.model.LotPoulet;
import com.elevageavicole.gestion_elevage_avicole.repository.LotPouletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LotPouletService {

    @Autowired
    private LotPouletRepository lotPouletRepository;

    public List<LotPoulet> findAllLots() {
        return lotPouletRepository.findAll();
    }

    public Optional<LotPoulet> findLotById(Long id) {
        return lotPouletRepository.findById(id);
    }

    public LotPoulet saveLot(LotPoulet lotPoulet) {
        return lotPouletRepository.save(lotPoulet);
    }

    public void deleteLot(Long id) {
        lotPouletRepository.deleteById(id);
    }
}