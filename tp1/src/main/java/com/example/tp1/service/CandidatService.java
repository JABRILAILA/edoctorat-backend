package com.example.tp1.service;

import com.example.tp1.model.Candidat;
import com.example.tp1.repository.CandidatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidatService {

    private final CandidatRepository candidatRepository;

    @Autowired
    public CandidatService(CandidatRepository candidatRepository) {
        this.candidatRepository = candidatRepository;
    }

    public List<Candidat> getAllCandidats() {
        return candidatRepository.findAll();
    }

    public Optional<Candidat> getCandidatById(Long id) {
        return candidatRepository.findById(id);
    }

    public Candidat saveCandidat(Candidat candidat) {
        return candidatRepository.save(candidat);
    }

    public Candidat updateCandidat(Long id, Candidat candidatDetails) {
        return candidatRepository.findById(id).map(candidat -> {
            candidat.setCne(candidatDetails.getCne());
            candidat.setCin(candidatDetails.getCin());
            candidat.setNomCandidatAr(candidatDetails.getNomCandidatAr());
            candidat.setPrenomCandidatAr(candidatDetails.getPrenomCandidatAr());
            candidat.setAdresse(candidatDetails.getAdresse());
            candidat.setSexe(candidatDetails.getSexe());
            candidat.setVilleDeNaissance(candidatDetails.getVilleDeNaissance());
            candidat.setDateDeNaissance(candidatDetails.getDateDeNaissance());
            candidat.setTelCandidat(candidatDetails.getTelCandidat());
            candidat.setPathCv(candidatDetails.getPathCv());
            candidat.setPathPhoto(candidatDetails.getPathPhoto());
            candidat.setEtatDossier(candidatDetails.getEtatDossier());
            candidat.setFonctionaire(candidatDetails.getFonctionaire());
            candidat.setPays(candidatDetails.getPays());
            return candidatRepository.save(candidat);
        }).orElse(null);
    }

    public boolean deleteCandidat(Long id) {
        if (candidatRepository.existsById(id)) {
            candidatRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Candidat> searchByCin(String cin) {
        return candidatRepository.findByCinContainingIgnoreCase(cin);
    }
}