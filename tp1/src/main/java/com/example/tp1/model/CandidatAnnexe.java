package com.example.tp1.model;

import jakarta.persistence.*;

@Entity
@Table(name = "candidat_annexe")
public class CandidatAnnexe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "typeAnnexe", nullable = false, length = 100)
    private String typeAnnexe;

    @Column(nullable = false, length = 255)
    private String titre;

    @Column(name = "pathFile", nullable = false, length = 100)
    private String pathFile;

    @ManyToOne
    @JoinColumn(name = "diplome_id", nullable = false)
    private CandidatDiplome diplome;

    public CandidatAnnexe() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTypeAnnexe() { return typeAnnexe; }
    public void setTypeAnnexe(String typeAnnexe) { this.typeAnnexe = typeAnnexe; }
    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }
    public String getPathFile() { return pathFile; }
    public void setPathFile(String pathFile) { this.pathFile = pathFile; }
    public CandidatDiplome getDiplome() { return diplome; }
    public void setDiplome(CandidatDiplome diplome) { this.diplome = diplome; }
}