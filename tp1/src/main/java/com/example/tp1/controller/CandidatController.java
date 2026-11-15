package com.example.tp1.controller;

import com.example.tp1.model.Candidat;
import com.example.tp1.service.CandidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/candidats")
public class CandidatController {

    private final CandidatService candidatService;

    @Autowired
    public CandidatController(CandidatService candidatService) {
        this.candidatService = candidatService;
    }

    @GetMapping
    public ResponseEntity<List<Candidat>> getAllCandidats() {
        return ResponseEntity.ok(candidatService.getAllCandidats());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Candidat> getCandidatById(@PathVariable Long id) {
        Optional<Candidat> candidat = candidatService.getCandidatById(id);
        return candidat.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Candidat> createCandidat(@RequestBody Candidat candidat) {
        Candidat created = candidatService.saveCandidat(candidat);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Candidat> updateCandidat(@PathVariable Long id, @RequestBody Candidat candidat) {
        Candidat updated = candidatService.updateCandidat(id, candidat);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCandidat(@PathVariable Long id) {
        if (candidatService.deleteCandidat(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Candidat>> searchCandidats(@RequestParam("cin") String cin) {
        return ResponseEntity.ok(candidatService.searchByCin(cin));
    }
}