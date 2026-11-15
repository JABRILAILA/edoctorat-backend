package com.example.tp1.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "professeur_commission")
public class ProfesseurCommission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dateCommission", nullable = false)
    private LocalDate dateCommission;

    @Column(nullable = false, length = 255)
    private String lieu;

    @Column(nullable = false)
    private LocalTime heure;

    @ManyToOne
    @JoinColumn(name = "labo_id", nullable = false)
    private ProfesseurLaboratoire labo;

    public ProfesseurCommission() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDate getDateCommission() { return dateCommission; }
    public void setDateCommission(LocalDate dateCommission) { this.dateCommission = dateCommission; }
    public String getLieu() { return lieu; }
    public void setLieu(String lieu) { this.lieu = lieu; }
    public LocalTime getHeure() { return heure; }
    public void setHeure(LocalTime heure) { this.heure = heure; }
    public ProfesseurLaboratoire getLabo() { return labo; }
    public void setLabo(ProfesseurLaboratoire labo) { this.labo = labo; }
}