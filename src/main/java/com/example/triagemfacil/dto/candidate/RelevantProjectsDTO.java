package com.example.triagemfacil.dto.candidate;

import java.util.List;

public record RelevantProjectsDTO(
        String projectName,
        String projectDescription,
        String projectLink,
        List<String> technologiesUsed
) {}
