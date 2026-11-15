package com.example.tp1.model;

import jakarta.persistence.*;

@Entity
@Table(name = "professeur_ced")
public class ProfesseurCed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String description;

    @Column(name = "pathImage", length = 100)
    private String pathImage;

    @Column(length = 255)
    private String initiale;

    @Column(nullable = false, length = 255)
    private String titre;

    @ManyToOne
    @JoinColumn(name = "directeur_id")
    private Professeur directeur;

    public ProfesseurCed() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getPathImage() { return pathImage; }
    public void setPathImage(String pathImage) { this.pathImage = pathImage; }
    public String getInitiale() { return initiale; }
    public void setInitiale(String initiale) { this.initiale = initiale; }
    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }
    public Professeur getDirecteur() { return directeur; }
    public void setDirecteur(Professeur directeur) { this.directeur = directeur; }
}