package com.example.tp1.service;

import com.example.tp1.model.Sujet;
import com.example.tp1.repository.SujetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SujetService {

    @Autowired
    private SujetRepository sujetRepository;

    public List<Sujet> getAllSujets() {
        return sujetRepository.findAll();
    }

    public Optional<Sujet> getSujetById(Long id) {
        return sujetRepository.findById(id);
    }

    public Sujet saveSujet(Sujet sujet) {
        return sujetRepository.save(sujet);
    }

    public void deleteSujet(Long id) {
        sujetRepository.deleteById(id);
    }
}