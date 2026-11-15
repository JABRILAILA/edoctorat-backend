package com.example.tp1.model;

import jakarta.persistence.*;

@Entity
@Table(name = "professeur_professeur")
public class Professeur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30)
    private String cin;

    @Column(name = "telProfesseur", length = 30)
    private String telProfesseur;

    @Column(name = "pathPhoto", length = 200)
    private String pathPhoto;

    @Column(length = 10)
    private String grade;

    @Column(name = "numSOM", length = 50)
    private String numSOM;

    @Column(name = "nombreEncadrer", nullable = false)
    private Integer nombreEncadrer = 0;

    @Column(name = "nombreProposer", nullable = false)
    private Integer nombreProposer = 0;

    @ManyToOne
    @JoinColumn(name = "etablissement_id", nullable = false)
    private Etablissement etablissement;

    @ManyToOne
    @JoinColumn(name = "labo_id")
    private ProfesseurLaboratoire labo;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private AuthUser user;

    public Professeur() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCin() { return cin; }
    public void setCin(String cin) { this.cin = cin; }
    public String getTelProfesseur() { return telProfesseur; }
    public void setTelProfesseur(String telProfesseur) { this.telProfesseur = telProfesseur; }
    public String getPathPhoto() { return pathPhoto; }
    public void setPathPhoto(String pathPhoto) { this.pathPhoto = pathPhoto; }
    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }
    public String getNumSOM() { return numSOM; }
    public void setNumSOM(String numSOM) { this.numSOM = numSOM; }
    public Integer getNombreEncadrer() { return nombreEncadrer; }
    public void setNombreEncadrer(Integer nombreEncadrer) { this.nombreEncadrer = nombreEncadrer; }
    public Integer getNombreProposer() { return nombreProposer; }
    public void setNombreProposer(Integer nombreProposer) { this.nombreProposer = nombreProposer; }
    public Etablissement getEtablissement() { return etablissement; }
    public void setEtablissement(Etablissement etablissement) { this.etablissement = etablissement; }
    public ProfesseurLaboratoire getLabo() { return labo; }
    public void setLabo(ProfesseurLaboratoire labo) { this.labo = labo; }
    public AuthUser getUser() { return user; }
    public void setUser(AuthUser user) { this.user = user; }
}