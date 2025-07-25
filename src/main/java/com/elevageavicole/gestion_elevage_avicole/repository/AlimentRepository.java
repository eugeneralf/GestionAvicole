package com.elevageavicole.gestion_elevage_avicole.repository;

import com.elevageavicole.gestion_elevage_avicole.model.Aliment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlimentRepository extends JpaRepository<Aliment, Long> {
}