package com.example.tp1.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "professeur_formationdoctorale")
public class ProfesseurFormationDoctorale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pathImage", length = 100)
    private String pathImage;

    @Column(length = 255)
    private String initiale;

    @Column(nullable = false, length = 255)
    private String titre;

    @Lob
    @Column(name = "axeDeRecherche", columnDefinition = "LONGTEXT")
    private String axeDeRecherche;

    @Column(name = "dateAccreditation")
    private LocalDate dateAccreditation;

    @ManyToOne
    @JoinColumn(name = "ced_id", nullable = false)
    private ProfesseurCed ced;

    @ManyToOne
    @JoinColumn(name = "etablissement_id", nullable = false)
    private Etablissement etablissement;

    public ProfesseurFormationDoctorale() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getPathImage() { return pathImage; }
    public void setPathImage(String pathImage) { this.pathImage = pathImage; }
    public String getInitiale() { return initiale; }
    public void setInitiale(String initiale) { this.initiale = initiale; }
    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }
    public String getAxeDeRecherche() { return axeDeRecherche; }
    public void setAxeDeRecherche(String axeDeRecherche) { this.axeDeRecherche = axeDeRecherche; }
    public LocalDate getDateAccreditation() { return dateAccreditation; }
    public void setDateAccreditation(LocalDate dateAccreditation) { this.dateAccreditation = dateAccreditation; }
    public ProfesseurCed getCed() { return ced; }
    public void setCed(ProfesseurCed ced) { this.ced = ced; }
    public Etablissement getEtablissement() { return etablissement; }
    public void setEtablissement(Etablissement etablissement) { this.etablissement = etablissement; }
}