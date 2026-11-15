package com.example.tp1.service;

import com.example.tp1.model.Candidat;
import com.example.tp1.model.CandidatPostuler;
import com.example.tp1.model.Sujet;
import com.example.tp1.repository.CandidatPostulerRepository;
import com.example.tp1.repository.CandidatRepository;
import com.example.tp1.repository.SujetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostulerService {

    private final CandidatPostulerRepository postulerRepository;
    private final CandidatRepository candidatRepository;
    private final SujetRepository sujetRepository;

    @Autowired
    public PostulerService(CandidatPostulerRepository postulerRepository,
                           CandidatRepository candidatRepository,
                           SujetRepository sujetRepository) {
        this.postulerRepository = postulerRepository;
        this.candidatRepository = candidatRepository;
        this.sujetRepository = sujetRepository;
    }

    // Candidater sur un sujet (maximum 3 sujets)
    public CandidatPostuler postuler(Long candidatId, Long sujetId, String pathFile) {
        if (postulerRepository.countByCandidatId(candidatId) >= 3) {
            throw new RuntimeException("Limite atteinte : 3 candidatures maximum autorisées.");
        }

        if (postulerRepository.existsByCandidatIdAndSujetId(candidatId, sujetId)) {
            throw new RuntimeException("Déjà postulé à ce sujet.");
        }

        Candidat candidat = candidatRepository.findById(candidatId).orElse(null);
        Sujet sujet = sujetRepository.findById(sujetId).orElse(null);

        if (candidat != null && sujet != null) {
            CandidatPostuler postuler = new CandidatPostuler(candidat, sujet, pathFile);
            return postulerRepository.save(postuler);
        }
        return null;
    }

    public List<CandidatPostuler> getCandidaturesParCandidat(Long candidatId) {
        return postulerRepository.findByCandidatId(candidatId);
    }

    public boolean annulerCandidature(Long id) {
        if (postulerRepository.existsById(id)) {
            postulerRepository.deleteById(id);
            return true;
        }
        return false;
    }
}