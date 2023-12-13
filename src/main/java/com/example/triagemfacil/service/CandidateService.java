package com.example.triagemfacil.service;

import com.example.triagemfacil.domain.candidate.Candidate;
import com.example.triagemfacil.especifications.CandidateEspecifications;
import com.example.triagemfacil.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateService {
    @Autowired
    private CandidateRepository candidateRepo;

    public List<Candidate> searchEmployees(String name, Integer age, Integer timeExperience) {
        Specification<Candidate> spec = Specification.where(null);

        if (name != null && !name.isEmpty()) {
            spec = spec.and(CandidateEspecifications.nameContains(name));
        }
        if (age != null && age > 0) {
            spec = spec.and(CandidateEspecifications.ageEquals(age));
        }
        if (timeExperience != null && timeExperience > 0) {
            spec = spec.and(CandidateEspecifications.timeExperienceEquals(timeExperience));
        }

        return candidateRepo.findAll(spec);
    }

    public List<Candidate> searchCandidates() {
        return candidateRepo.findAll();
    }
    public Candidate saveCandidate(Candidate candidate) {
        return candidateRepo.save(candidate);
    }

    public Candidate findCandidateById(Long id) {
        return candidateRepo.findById(id).orElse(null);
    }
}
