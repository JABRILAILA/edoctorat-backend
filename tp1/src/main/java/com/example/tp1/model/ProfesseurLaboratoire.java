package com.example.tp1.model;

import jakarta.persistence.*;

@Entity
@Table(name = "professeur_laboratoire")
public class ProfesseurLaboratoire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nomLaboratoire", nullable = false, length = 255)
    private String nomLaboratoire;

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String description;

    @Column(name = "pathImage", length = 100)
    private String pathImage;

    @Column(length = 255)
    private String initial;

    @ManyToOne
    @JoinColumn(name = "ced_id", nullable = false)
    private ProfesseurCed ced;

    @ManyToOne
    @JoinColumn(name = "directeur_id", nullable = false)
    private Professeur directeur;

    @ManyToOne
    @JoinColumn(name = "etablissement_id", nullable = false)
    private Etablissement etablissement;

    public ProfesseurLaboratoire() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNomLaboratoire() { return nomLaboratoire; }
    public void setNomLaboratoire(String nomLaboratoire) { this.nomLaboratoire = nomLaboratoire; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getPathImage() { return pathImage; }
    public void setPathImage(String pathImage) { this.pathImage = pathImage; }
    public String getInitial() { return initial; }
    public void setInitial(String initial) { this.initial = initial; }
    public ProfesseurCed getCed() { return ced; }
    public void setCed(ProfesseurCed ced) { this.ced = ced; }
    public Professeur getDirecteur() { return directeur; }
    public void setDirecteur(Professeur directeur) { this.directeur = directeur; }
    public Etablissement getEtablissement() { return etablissement; }
    public void setEtablissement(Etablissement etablissement) { this.etablissement = etablissement; }
}