package com.example.tp1.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "candidat_diplome")
public class CandidatDiplome {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String intitule;

    @Column(length = 500)
    private String type;

    @Column(name = "dateCommission", nullable = false)
    private LocalDate dateCommission;

    @Column(nullable = false, length = 50)
    private String mention;

    @Column(nullable = false, length = 255)
    private String pays;

    @Column(nullable = false, length = 255)
    private String etablissement;

    @Column(length = 255)
    private String specialite;

    @Column(nullable = false, length = 255)
    private String ville;

    @Column(nullable = false, length = 255)
    private String province;

    @Column(name = "moyen_generale", nullable = false)
    private Double moyenGenerale;

    @ManyToOne
    @JoinColumn(name = "candidat_id", nullable = false)
    private Candidat candidat;

    public CandidatDiplome() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getIntitule() { return intitule; }
    public void setIntitule(String intitule) { this.intitule = intitule; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public LocalDate getDateCommission() { return dateCommission; }
    public void setDateCommission(LocalDate dateCommission) { this.dateCommission = dateCommission; }
    public String getMention() { return mention; }
    public void setMention(String mention) { this.mention = mention; }
    public String getPays() { return pays; }
    public void setPays(String pays) { this.pays = pays; }
    public String getEtablissement() { return etablissement; }
    public void setEtablissement(String etablissement) { this.etablissement = etablissement; }
    public String getSpecialite() { return specialite; }
    public void setSpecialite(String specialite) { this.specialite = specialite; }
    public String getVille() { return ville; }
    public void setVille(String ville) { this.ville = ville; }
    public String getProvince() { return province; }
    public void setProvince(String province) { this.province = province; }
    public Double getMoyenGenerale() { return moyenGenerale; }
    public void setMoyenGenerale(Double moyenGenerale) { this.moyenGenerale = moyenGenerale; }
    public Candidat getCandidat() { return candidat; }
    public void setCandidat(Candidat candidat) { this.candidat = candidat; }
}