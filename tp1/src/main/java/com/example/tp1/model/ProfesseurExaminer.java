package com.example.tp1.model;

import jakarta.persistence.*;

@Entity
@Table(name = "professeur_examiner")
public class ProfesseurExaminer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255)
    private String decision;

    @Column(name = "noteDossier", nullable = false)
    private Float noteDossier;

    @Column(name = "noteEntretien", nullable = false)
    private Integer noteEntretien;

    @Column(nullable = false)
    private Boolean publier = false;

    @ManyToOne
    @JoinColumn(name = "commission_id", nullable = false)
    private ProfesseurCommission commission;

    @ManyToOne
    @JoinColumn(name = "sujet_id", nullable = false)
    private Sujet sujet;

    @ManyToOne
    @JoinColumn(name = "candidat_id", nullable = false)
    private Candidat candidat;

    @Column(nullable = false)
    private Boolean valider = false;

    public ProfesseurExaminer() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getDecision() { return decision; }
    public void setDecision(String decision) { this.decision = decision; }
    public Float getNoteDossier() { return noteDossier; }
    public void setNoteDossier(Float noteDossier) { this.noteDossier = noteDossier; }
    public Integer getNoteEntretien() { return noteEntretien; }
    public void setNoteEntretien(Integer noteEntretien) { this.noteEntretien = noteEntretien; }
    public Boolean getPublier() { return publier; }
    public void setPublier(Boolean publier) { this.publier = publier; }
    public ProfesseurCommission getCommission() { return commission; }
    public void setCommission(ProfesseurCommission commission) { this.commission = commission; }
    public Sujet getSujet() { return sujet; }
    public void setSujet(Sujet sujet) { this.sujet = sujet; }
    public Candidat getCandidat() { return candidat; }
    public void setCandidat(Candidat candidat) { this.candidat = candidat; }
    public Boolean getValider() { return valider; }
    public void setValider(Boolean valider) { this.valider = valider; }
}