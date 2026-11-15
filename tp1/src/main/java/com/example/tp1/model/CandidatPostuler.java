package com.example.tp1.model;

import jakarta.persistence.*;

@Entity
@Table(name = "candidat_postuler")
public class CandidatPostuler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String pathFile;

    @ManyToOne
    @JoinColumn(name = "candidat_id", nullable = false)
    private Candidat candidat;

    @ManyToOne
    @JoinColumn(name = "sujet_id", nullable = false)
    private Sujet sujet;

    public CandidatPostuler() {}

    public CandidatPostuler(Candidat candidat, Sujet sujet, String pathFile) {
        this.candidat = candidat;
        this.sujet = sujet;
        this.pathFile = pathFile;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getPathFile() { return pathFile; }
    public void setPathFile(String pathFile) { this.pathFile = pathFile; }
    public Candidat getCandidat() { return candidat; }
    public void setCandidat(Candidat candidat) { this.candidat = candidat; }
    public Sujet getSujet() { return sujet; }
    public void setSujet(Sujet sujet) { this.sujet = sujet; }
}