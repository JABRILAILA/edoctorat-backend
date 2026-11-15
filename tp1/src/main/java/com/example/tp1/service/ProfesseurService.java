package com.example.tp1.service;

import com.example.tp1.model.CandidatPostuler;
import com.example.tp1.model.Professeur;
import com.example.tp1.model.Sujet;
import com.example.tp1.repository.CandidatPostulerRepository;
import com.example.tp1.repository.ProfesseurRepository;
import com.example.tp1.repository.SujetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesseurService {

    private final ProfesseurRepository professeurRepository;
    private final SujetRepository sujetRepository;
    private final CandidatPostulerRepository postulerRepository;

    @Autowired
    public ProfesseurService(ProfesseurRepository professeurRepository,
                             SujetRepository sujetRepository,
                             CandidatPostulerRepository postulerRepository) {
        this.professeurRepository = professeurRepository;
        this.sujetRepository = sujetRepository;
        this.postulerRepository = postulerRepository;
    }

    public Professeur createProfesseur(Professeur professeur) {
        return professeurRepository.save(professeur);
    }

    public List<Professeur> getAllProfesseurs() {
        return professeurRepository.findAll();
    }

    public Sujet proposerSujet(Long profId, Sujet sujet) {
        Professeur prof = professeurRepository.findById(profId).orElse(null);
        if (prof != null) {
            sujet.setProfesseur(prof);
            return sujetRepository.save(sujet);
        }
        return null;
    }

    public Sujet updateSujet(Long sujetId, Sujet sujetDetails) {
        return sujetRepository.findById(sujetId).map(sujet -> {
            sujet.setTitre(sujetDetails.getTitre());
            sujet.setDescription(sujetDetails.getDescription());
            return sujetRepository.save(sujet);
        }).orElse(null);
    }

    public List<CandidatPostuler> getCandidatsPourProfesseur(Long profId) {
        return postulerRepository.findBySujetProfesseurId(profId);
    }
}