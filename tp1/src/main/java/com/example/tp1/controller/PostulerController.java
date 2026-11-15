package com.example.tp1.controller;

import com.example.tp1.model.CandidatPostuler;
import com.example.tp1.service.PostulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/postuler")
public class PostulerController {

    private final PostulerService postulerService;

    @Autowired
    public PostulerController(PostulerService postulerService) {
        this.postulerService = postulerService;
    }

    @PostMapping("/candidat/{candidatId}/sujet/{sujetId}")
    public ResponseEntity<?> postuler(@PathVariable Long candidatId,
                                      @PathVariable Long sujetId,
                                      @RequestParam(required = false) String pathFile) {
        try {
            CandidatPostuler postuler = postulerService.postuler(candidatId, sujetId, pathFile);
            return new ResponseEntity<>(postuler, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/candidat/{candidatId}")
    public ResponseEntity<List<CandidatPostuler>> getCandidatures(@PathVariable Long candidatId) {
        return ResponseEntity.ok(postulerService.getCandidaturesParCandidat(candidatId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> annulerCandidature(@PathVariable Long id) {
        if (postulerService.annulerCandidature(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}