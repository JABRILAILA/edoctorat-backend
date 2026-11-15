package com.example.tp1.model;

import jakarta.persistence.*;

@Entity
@Table(name = "candidat_notification")
public class CandidatNotification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String type;

    @ManyToOne
    @JoinColumn(name = "candidat_id", nullable = false)
    private Candidat candidat;

    @ManyToOne
    @JoinColumn(name = "commission_id")
    private ProfesseurCommission commission;

    @ManyToOne
    @JoinColumn(name = "sujet_id")
    private Sujet sujet;

    public CandidatNotification() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public Candidat getCandidat() { return candidat; }
    public void setCandidat(Candidat candidat) { this.candidat = candidat; }
    public ProfesseurCommission getCommission() { return commission; }
    public void setCommission(ProfesseurCommission commission) { this.commission = commission; }
    public Sujet getSujet() { return sujet; }
    public void setSujet(Sujet sujet) { this.sujet = sujet; }
}