package com.example.triagemfacil.especifications;

import com.example.triagemfacil.domain.candidate.Candidate;
import org.springframework.data.jpa.domain.Specification;

public class CandidateEspecifications {

    public static Specification<Candidate> nameContains(String name) {
        return (root, query, criteriaBuilder) -> {
            if (name == null || name.isEmpty()) return null;
            return criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + name.toLowerCase() + "%");
        };
    }

    public static Specification<Candidate> ageEquals(int age) {
        return (root, query, criteriaBuilder) -> {
            if (age == 0) return null;
            return criteriaBuilder.equal(root.get("age"), age);
        };
    }

    public static Specification<Candidate> timeExperienceEquals(int timeExperience) {
        return (root, query, criteriaBuilder) -> {
            if (timeExperience == 0) return null;
            return criteriaBuilder.equal(root.get("timeExperience"), timeExperience);
        };
    }
}
