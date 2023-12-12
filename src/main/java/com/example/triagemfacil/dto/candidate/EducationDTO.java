package com.example.triagemfacil.dto.candidate;

import java.util.Date;

public record EducationDTO(
        String projectName,
        String projectLink,
        Date yearConclusion
) {}