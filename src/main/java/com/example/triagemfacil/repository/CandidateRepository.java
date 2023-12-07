package com.example.triagemfacil.repository;

import com.example.triagemfacil.domain.candidate.Candidate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;


public interface CandidateRepository extends JpaRepository<Candidate, Long>, JpaSpecificationExecutor<Candidate> {
    List<Candidate> findAll(Specification<Candidate> spec);
}
