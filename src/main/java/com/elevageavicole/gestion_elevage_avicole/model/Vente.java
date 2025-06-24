package com.elevageavicole.gestion_elevage_avicole.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "vente")
public class Vente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lot_poulet_id", nullable = false)
    private LotPoulet lotPoulet;

    @Column(name = "date_vente", nullable = false)
    private LocalDate dateVente;

    @Column(name = "nombre_poulets_vendus", nullable = false)
    private int nombrePouletsVendus;

    @Column(name = "poids_total_vendu_kg", nullable = false)
    private double poidsTotalVenduKg;

    @Column(name = "prix_unitaire_kg", nullable = false)
    private double prixUnitaireKg;

    @Column(name = "montant_total", nullable = false)
    private double montantTotal;



    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LotPoulet getLotPoulet() { return lotPoulet; }
    public void setLotPoulet(LotPoulet lotPoulet) { this.lotPoulet = lotPoulet; }
    public LocalDate getDateVente() { return dateVente; }
    public void setDateVente(LocalDate dateVente) { this.dateVente = dateVente; }
    public int getNombrePouletsVendus() { return nombrePouletsVendus; }
    public void setNombrePouletsVendus(int nombrePouletsVendus) { this.nombrePouletsVendus = nombrePouletsVendus; }
    public double getPoidsTotalVenduKg() { return poidsTotalVenduKg; }
    public void setPoidsTotalVenduKg(double poidsTotalVenduKg) { this.poidsTotalVenduKg = poidsTotalVenduKg; }
    public double getPrixUnitaireKg() { return prixUnitaireKg; }
    public void setPrixUnitaireKg(double prixUnitaireKg) { this.prixUnitaireKg = prixUnitaireKg; }
    public double getMontantTotal() { return montantTotal; }
    public void setMontantTotal(double montantTotal) { this.montantTotal = montantTotal; }
}