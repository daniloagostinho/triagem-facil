package com.example.triagemfacil.dto.candidate;

import java.util.Date;
import java.util.List;

public record ExperienceProfessionalDTO(
        String companyName,
        String jobTitle,
        Date startDate,
        Date endDate,
        List<String> technologiesUsed
) {}