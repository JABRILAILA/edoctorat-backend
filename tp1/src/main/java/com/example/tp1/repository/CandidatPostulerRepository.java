package com.example.tp1.repository;

import com.example.tp1.model.CandidatPostuler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidatPostulerRepository extends JpaRepository<CandidatPostuler, Long> {
    List<CandidatPostuler> findByCandidatId(Long candidatId);
    List<CandidatPostuler> findBySujetProfesseurId(Long professeurId);
    long countByCandidatId(Long candidatId);
    boolean existsByCandidatIdAndSujetId(Long candidatId, Long sujetId);
}