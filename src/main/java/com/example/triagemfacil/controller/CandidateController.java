package com.example.triagemfacil.controller;

import com.example.triagemfacil.domain.Candidate;
import com.example.triagemfacil.especifications.CandidateEspecifications;
import com.example.triagemfacil.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @GetMapping("/candidates")
    public ResponseEntity<List<Candidate>> search(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer age,
            @RequestParam(required = false) Integer timeExperience) {
        return ResponseEntity.ok(candidateService.searchEmployees(name, age, timeExperience));
    }

    @PostMapping("/create")
    public Candidate addProduct(@RequestBody Candidate candidate) {
        return candidateService.saveCandidate(candidate);
    }
}
