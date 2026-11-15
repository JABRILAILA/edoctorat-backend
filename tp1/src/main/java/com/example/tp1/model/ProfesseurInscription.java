package com.example.tp1.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "professeur_inscription")
public class ProfesseurInscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dateDiposeDossier")
    private LocalDate dateDiposeDossier;

    @Column(length = 255)
    private String remarque;

    @Column(nullable = false)
    private Boolean valider = false;

    @ManyToOne
    @JoinColumn(name = "candidat_id", nullable = false)
    private Candidat candidat;

    @ManyToOne
    @JoinColumn(name = "sujet_id", nullable = false)
    private Sujet sujet;

    public ProfesseurInscription() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDate getDateDiposeDossier() { return dateDiposeDossier; }
    public void setDateDiposeDossier(LocalDate dateDiposeDossier) { this.dateDiposeDossier = dateDiposeDossier; }
    public String getRemarque() { return remarque; }
    public void setRemarque(String remarque) { this.remarque = remarque; }
    public Boolean getValider() { return valider; }
    public void setValider(Boolean valider) { this.valider = valider; }
    public Candidat getCandidat() { return candidat; }
    public void setCandidat(Candidat candidat) { this.candidat = candidat; }
    public Sujet getSujet() { return sujet; }
    public void setSujet(Sujet sujet) { this.sujet = sujet; }
}