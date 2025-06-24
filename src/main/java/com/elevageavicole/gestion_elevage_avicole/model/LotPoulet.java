package com.elevageavicole.gestion_elevage_avicole.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "lot_poulets")
public class LotPoulet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int nombrePouletsInitial;
    private double poidsMoyenPouletKg;


    @Column(name = "date_entree")
    private LocalDate dateEntree;

    public LotPoulet() {
    }

    public LotPoulet(int nombrePouletsInitial, double poidsMoyenPouletKg, LocalDate dateEntree) {
        this.nombrePouletsInitial = nombrePouletsInitial;
        this.poidsMoyenPouletKg = poidsMoyenPouletKg;
        this.dateEntree = dateEntree;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNombrePouletsInitial() {
        return nombrePouletsInitial;
    }

    public void setNombrePouletsInitial(int nombrePouletsInitial) {
        this.nombrePouletsInitial = nombrePouletsInitial;
    }

    public double getPoidsMoyenPouletKg() {
        return poidsMoyenPouletKg;
    }

    public void setPoidsMoyenPouletKg(double poidsMoyenPouletKg) {
        this.poidsMoyenPouletKg = poidsMoyenPouletKg;
    }

    public LocalDate getDateEntree() {
        return dateEntree;
    }

    public void setDateEntree(LocalDate dateEntree) {
        this.dateEntree = dateEntree;
    }

    @Override
    public String toString() {
        return "LotPoulet{" +
                "id=" + id +
                ", nombrePouletsInitial=" + nombrePouletsInitial +
                ", poidsMoyenPouletKg=" + poidsMoyenPouletKg +
                ", dateEntree=" + dateEntree +
                '}';
    }
}