package com.example.tp1.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "candidat_candidat")
public class Candidat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String cne;

    @Column(nullable = false, length = 30)
    private String cin;

    @Column(name = "nomCandidatAr", length = 255)
    private String nomCandidatAr;

    @Column(name = "prenomCandidatAr", length = 255)
    private String prenomCandidatAr;

    @Lob
    @Column(nullable = false, columnDefinition = "LONGTEXT")
    private String adresse;

    @Lob
    @Column(name = "adresseAr", columnDefinition = "LONGTEXT")
    private String adresseAr;

    @Column(length = 20)
    private String sexe;

    @Column(name = "villeDeNaissance", nullable = false, length = 255)
    private String villeDeNaissance;

    @Column(name = "villeDeNaissanceAr", length = 255)
    private String villeDeNaissanceAr;

    @Column(nullable = false, length = 255)
    private String ville;

    @Column(name = "dateDeNaissance", nullable = false)
    private LocalDate dateDeNaissance;

    @Column(name = "typeDeHandiCape", length = 30)
    private String typeDeHandiCape;

    @Column(length = 255)
    private String academie;

    @Column(name = "telCandidat", length = 30)
    private String telCandidat;

    @Column(name = "pathCv", length = 100)
    private String pathCv;

    @Column(name = "pathPhoto", length = 100)
    private String pathPhoto;

    @Column(name = "etatDossier")
    private Integer etatDossier;

    @Column(name = "situation_familiale", length = 50)
    private String situationFamiliale;

    @ManyToOne
    @JoinColumn(name = "pays_id", nullable = false)
    private Pays pays;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private AuthUser user;

    @Column(nullable = false)
    private Boolean fonctionaire = false;

    public Candidat() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCne() { return cne; }
    public void setCne(String cne) { this.cne = cne; }
    public String getCin() { return cin; }
    public void setCin(String cin) { this.cin = cin; }
    public String getNomCandidatAr() { return nomCandidatAr; }
    public void setNomCandidatAr(String nomCandidatAr) { this.nomCandidatAr = nomCandidatAr; }
    public String getPrenomCandidatAr() { return prenomCandidatAr; }
    public void setPrenomCandidatAr(String prenomCandidatAr) { this.prenomCandidatAr = prenomCandidatAr; }
    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }
    public String getAdresseAr() { return adresseAr; }
    public void setAdresseAr(String adresseAr) { this.adresseAr = adresseAr; }
    public String getSexe() { return sexe; }
    public void setSexe(String sexe) { this.sexe = sexe; }
    public String getVilleDeNaissance() { return villeDeNaissance; }
    public void setVilleDeNaissance(String villeDeNaissance) { this.villeDeNaissance = villeDeNaissance; }
    public String getVilleDeNaissanceAr() { return villeDeNaissanceAr; }
    public void setVilleDeNaissanceAr(String villeDeNaissanceAr) { this.villeDeNaissanceAr = villeDeNaissanceAr; }
    public String getVille() { return ville; }
    public void setVille(String ville) { this.ville = ville; }
    public LocalDate getDateDeNaissance() { return dateDeNaissance; }
    public void setDateDeNaissance(LocalDate dateDeNaissance) { this.dateDeNaissance = dateDeNaissance; }
    public String getTypeDeHandiCape() { return typeDeHandiCape; }
    public void setTypeDeHandiCape(String typeDeHandiCape) { this.typeDeHandiCape = typeDeHandiCape; }
    public String getAcademie() { return academie; }
    public void setAcademie(String academie) { this.academie = academie; }
    public String getTelCandidat() { return telCandidat; }
    public void setTelCandidat(String telCandidat) { this.telCandidat = telCandidat; }
    public String getPathCv() { return pathCv; }
    public void setPathCv(String pathCv) { this.pathCv = pathCv; }
    public String getPathPhoto() { return pathPhoto; }
    public void setPathPhoto(String pathPhoto) { this.pathPhoto = pathPhoto; }
    public Integer getEtatDossier() { return etatDossier; }
    public void setEtatDossier(Integer etatDossier) { this.etatDossier = etatDossier; }
    public String getSituationFamiliale() { return situationFamiliale; }
    public void setSituationFamiliale(String situationFamiliale) { this.situationFamiliale = situationFamiliale; }
    public Pays getPays() { return pays; }
    public void setPays(Pays pays) { this.pays = pays; }
    public AuthUser getUser() { return user; }
    public void setUser(AuthUser user) { this.user = user; }
    public Boolean getFonctionaire() { return fonctionaire; }
    public void setFonctionaire(Boolean fonctionaire) { this.fonctionaire = fonctionaire; }
}