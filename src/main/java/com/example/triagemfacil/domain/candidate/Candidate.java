package com.example.triagemfacil.domain.candidate;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "candidates_dev")
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String linkedinProfile;
    private String githubProfile;

    @Column(length = 1000)
    private String descriptionProfessional;

    private String companyName;
    private String jobTitle;

    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Temporal(TemporalType.DATE)
    private Date endDate;

    private String projectName;
    private String projectDescription;
    private String projectLink;

    @Temporal(TemporalType.DATE)
    private Date yearConclusion;

    @ElementCollection
    @CollectionTable(name = "candidate_dev_technologies_used", joinColumns = @JoinColumn(name = "candidate_id"))
    @Column(name = "technology")
    private List<String> technologiesUsed;

    @ElementCollection
    @CollectionTable(name = "candidate_dev_programming_languages", joinColumns = @JoinColumn(name = "candidate_id"))
    @Column(name = "programming_language")
    private List<String> languagensPrograming;

    @ElementCollection
    @CollectionTable(name = "candidate_dev_databases", joinColumns = @JoinColumn(name = "candidate_id"))
    @Column(name = "database_name")
    private List<String> databases;

    @ElementCollection
    @CollectionTable(name = "candidate_dev_methodologies", joinColumns = @JoinColumn(name = "candidate_id"))
    @Column(name = "methodology")
    private List<String> metologys;

    @ElementCollection
    @CollectionTable(name = "candidate_dev_tools_technologies", joinColumns = @JoinColumn(name = "candidate_id"))
    @Column(name = "tool_technology")
    private List<String> toolsTeconolog;
}
