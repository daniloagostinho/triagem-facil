package com.example.triagemfacil.dto.candidate;

import java.util.Date;
import java.util.List;

public record CandidateDTO(
        ContactInformationDTO contactInformation,
        ResumeProfessionalDTO resumeProfessional,
        ExperienceProfessionalDTO experienceProfessional,
        RelevantProjectsDTO relevantProjects,
        EducationDTO education,
        TechnicalAbilitiesDTO technicalAbilities
) {
}
