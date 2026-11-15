package com.example.tp1.repository;

import com.example.tp1.model.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidatRepository extends JpaRepository<Candidat, Long> {
    List<Candidat> findByCinContainingIgnoreCase(String cin);
}