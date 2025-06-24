package com.elevageavicole.gestion_elevage_avicole.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
public class Aliment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String type;
    private double quantiteStockKg;
    private LocalDate dateAchat;
    private double prixAchatKg;

    public Aliment() {
    }

    public Aliment(String nom, String type, double quantiteStockKg, LocalDate dateAchat, double prixAchatKg) {
        this.nom = nom;
        this.type = type;
        this.quantiteStockKg = quantiteStockKg;
        this.dateAchat = dateAchat;
        this.prixAchatKg = prixAchatKg;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getQuantiteStockKg() {
        return quantiteStockKg;
    }

    public void setQuantiteStockKg(double quantiteStockKg) {
        this.quantiteStockKg = quantiteStockKg;
    }

    public LocalDate getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(LocalDate dateAchat) {
        this.dateAchat = dateAchat;
    }

    public double getPrixAchatKg() {
        return prixAchatKg;
    }

    public void setPrixAchatKg(double prixAchatKg) {
        this.prixAchatKg = prixAchatKg;
    }

    @Override
    public String toString() {
        return "Aliment{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", type='" + type + '\'' +
                ", quantiteStockKg=" + quantiteStockKg +
                ", dateAchat=" + dateAchat +
                ", prixAchatKg=" + prixAchatKg +
                '}';
    }
}