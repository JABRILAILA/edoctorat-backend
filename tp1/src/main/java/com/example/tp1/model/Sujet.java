package com.example.tp1.model;

import jakarta.persistence.*;

@Entity
@Table(name = "professeur_sujet")
public class Sujet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String titre;

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String description;

    @Column(nullable = false)
    private Boolean publier = false;

    @ManyToOne
    @JoinColumn(name = "coDirecteur_id")
    private Professeur coDirecteur;

    @ManyToOne
    @JoinColumn(name = "formationDoctorale_id", nullable = false)
    private ProfesseurFormationDoctorale formationDoctorale;

    @ManyToOne
    @JoinColumn(name = "professeur_id", nullable = false)
    private Professeur professeur;

    public Sujet() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Boolean getPublier() { return publier; }
    public void setPublier(Boolean publier) { this.publier = publier; }
    public Professeur getCoDirecteur() { return coDirecteur; }
    public void setCoDirecteur(Professeur coDirecteur) { this.coDirecteur = coDirecteur; }
    public ProfesseurFormationDoctorale getFormationDoctorale() { return formationDoctorale; }
    public void setFormationDoctorale(ProfesseurFormationDoctorale formationDoctorale) { this.formationDoctorale = formationDoctorale; }
    public Professeur getProfesseur() { return professeur; }
    public void setProfesseur(Professeur professeur) { this.professeur = professeur; }
}