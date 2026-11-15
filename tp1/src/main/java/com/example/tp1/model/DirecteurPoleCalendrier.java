package com.example.tp1.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "directeur_pole_calendrier")
public class DirecteurPoleCalendrier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 500)
    private String action;

    @Column(name = "dateDebut", nullable = false)
    private LocalDate dateDebut;

    @Column(name = "dateFin", nullable = false)
    private LocalDate dateFin;

    @Column(nullable = false, length = 50)
    private String pour;

    public DirecteurPoleCalendrier() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getAction() { return action; }
    public void setAction(String action) { this.action = action; }
    public LocalDate getDateDebut() { return dateDebut; }
    public void setDateDebut(LocalDate dateDebut) { this.dateDebut = dateDebut; }
    public LocalDate getDateFin() { return dateFin; }
    public void setDateFin(LocalDate dateFin) { this.dateFin = dateFin; }
    public String getPour() { return pour; }
    public void setPour(String pour) { this.pour = pour; }
}