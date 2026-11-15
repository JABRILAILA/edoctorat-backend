package com.example.tp1.controller;

import com.example.tp1.model.CandidatPostuler;
import com.example.tp1.model.Professeur;
import com.example.tp1.model.Sujet;
import com.example.tp1.service.ProfesseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professeurs")
public class ProfesseurController {

    private final ProfesseurService professeurService;

    @Autowired
    public ProfesseurController(ProfesseurService professeurService) {
        this.professeurService = professeurService;
    }

    @PostMapping
    public ResponseEntity<Professeur> createProfesseur(@RequestBody Professeur professeur) {
        return new ResponseEntity<>(professeurService.createProfesseur(professeur), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Professeur>> getAllProfesseurs() {
        return ResponseEntity.ok(professeurService.getAllProfesseurs());
    }

    // Proposition de sujet par un professeur
    @PostMapping("/{profId}/sujets")
    public ResponseEntity<Sujet> proposerSujet(@PathVariable Long profId, @RequestBody Sujet sujet) {
        Sujet created = professeurService.proposerSujet(profId, sujet);
        if (created != null) {
            return new ResponseEntity<>(created, HttpStatus.CREATED);
        }
        return ResponseEntity.notFound().build();
    }

    // Mise à jour de la proposition de sujet
    @PutMapping("/sujets/{sujetId}")
    public ResponseEntity<Sujet> updateSujet(@PathVariable Long sujetId, @RequestBody Sujet sujet) {
        Sujet updated = professeurService.updateSujet(sujetId, sujet);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    // Consulter les candidats à ses sujets (aligné sur CandidatPostuler)
    @GetMapping("/{profId}/candidats")
    public ResponseEntity<List<CandidatPostuler>> getCandidatsPourProfesseur(@PathVariable Long profId) {
        return ResponseEntity.ok(professeurService.getCandidatsPourProfesseur(profId));
    }
}