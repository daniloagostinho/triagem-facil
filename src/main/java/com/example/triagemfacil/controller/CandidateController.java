package com.example.triagemfacil.controller;

import com.example.triagemfacil.domain.candidate.Candidate;
import com.example.triagemfacil.dto.CandidateDTO;
import com.example.triagemfacil.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @GetMapping("/candidates")
    public ResponseEntity<List<CandidateDTO>> search(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer age,
            @RequestParam(required = false) Integer timeExperience) {
        List<Candidate> candidates = candidateService.searchEmployees(name, age, timeExperience);
        List<CandidateDTO> candidateDTOs = candidates.stream()
                .map(candidate -> new CandidateDTO(candidate.getId(), candidate.getName(), candidate.getAge(), candidate.getTimeExperience()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(candidateDTOs);
    }

    @GetMapping("/hi")
    public String search() {
        return "Ola mundo!";
    }


    @PostMapping("/create")
    public ResponseEntity<CandidateDTO> addProduct(@RequestBody CandidateDTO candidateDTO) {
        Candidate candidate = new Candidate();
        candidate.setName(candidateDTO.name());
        candidate.setAge(candidateDTO.age());
        candidate.setTimeExperience(candidateDTO.timeExperience());

        Candidate savedCandidate = candidateService.saveCandidate(candidate);

        CandidateDTO savedCandidateDTO = new CandidateDTO(savedCandidate.getId(), savedCandidate.getName(), savedCandidate.getAge(), savedCandidate.getTimeExperience());
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCandidateDTO);
    }
}
