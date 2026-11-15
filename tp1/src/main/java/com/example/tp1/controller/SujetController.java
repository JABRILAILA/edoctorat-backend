package com.example.tp1.controller;

import com.example.tp1.model.Sujet;
import com.example.tp1.service.SujetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sujets")
public class SujetController {

    @Autowired
    private SujetService sujetService;

    @GetMapping
    public List<Sujet> getAllSujets() {
        return sujetService.getAllSujets();
    }

    @GetMapping("/{id}")
    public Optional<Sujet> getSujetById(@PathVariable Long id) {
        return sujetService.getSujetById(id);
    }

    @PostMapping
    public Sujet createSujet(@RequestBody Sujet sujet) {
        return sujetService.saveSujet(sujet);
    }

    @DeleteMapping("/{id}")
    public void deleteSujet(@PathVariable Long id) {
        sujetService.deleteSujet(id);
    }
}