package com.example.triagemfacil.dto.candidate;

import java.util.List;

public record TechnicalAbilitiesDTO(
        List<String> programmingLanguages,
        List<String> databases,
        List<String> methodologies,
        List<String> toolsAndTechnologies
) {}
