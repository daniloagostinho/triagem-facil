package com.example.triagemfacil.controller;

import com.example.triagemfacil.domain.candidate.Candidate;
import com.example.triagemfacil.dto.candidate.*;
import com.example.triagemfacil.filters.FilterCandidate;
import com.example.triagemfacil.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @GetMapping("/candidates")
    public ResponseEntity<List<Candidate>> search(@RequestParam(required = false) String name) {
        List<Candidate> candidates = candidateService.searchCandidates(); // Assumindo que este método busca os candidatos
        return ResponseEntity.ok(candidates);
    }

    @GetMapping("/candidate")
    public ResponseEntity<Candidate> searchById(@RequestParam Long id) {
        Candidate candidate = candidateService.findCandidateById(id);
        if (candidate != null) {
            return ResponseEntity.ok(candidate);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/filtrar")
    public ResponseEntity<List<Candidate>> filtrarCandidatos(@RequestBody FilterCandidate filtro) {
        List<Candidate> candidatosFiltrados = candidateService.filtrarCandidatos(filtro);
        return ResponseEntity.ok(candidatosFiltrados);
    }
    @GetMapping("/hi")
    public String search() {
        return "Ola mundo!";
    }


    @PostMapping("/create")
    public ResponseEntity<Candidate> createCandidate(@RequestBody Candidate candidate) {
        Candidate savedCandidate = candidateService.saveCandidate(candidate);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCandidate);
    }
}
