package com.example.triagemfacil.service;

import com.example.triagemfacil.domain.candidate.Candidate;
import com.example.triagemfacil.especifications.CandidateEspecifications;
import com.example.triagemfacil.filters.FilterCandidate;
import com.example.triagemfacil.repository.CandidateRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @PersistenceContext
    private EntityManager entityManager;

    public List<Candidate> filtrarCandidatos(FilterCandidate filtro) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Candidate> query = cb.createQuery(Candidate.class);
        Root<Candidate> candidate = query.from(Candidate.class);

        List<Predicate> predicates = new ArrayList<>();

        if (filtro.getEmpresas() != null && !filtro.getEmpresas().isEmpty()) {
            predicates.add(candidate.get("companyName").in(filtro.getEmpresas()));
        }

        if (filtro.getCargos() != null && !filtro.getCargos().isEmpty()) {
            predicates.add(candidate.get("jobTitle").in(filtro.getCargos()));
        }

        // Adicione mais condições com base nos outros campos do filtro

        query.select(candidate).where(cb.and(predicates.toArray(new Predicate[0])));
        return entityManager.createQuery(query).getResultList();
    }
}
