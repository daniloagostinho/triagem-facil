CREATE TABLE candidates (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255),
    linkedin_profile VARCHAR(255),
    github_profile VARCHAR(255),
    description_professional TEXT,
    company_name VARCHAR(255),
    job_title VARCHAR(255),
    start_date DATE,
    end_date DATE,
    project_name VARCHAR(255),
    project_description TEXT,
    project_link VARCHAR(255),
    education_name VARCHAR(255),
    education_link VARCHAR(255),
    year_conclusion DATE
);


CREATE TABLE candidate_technologies_used (
    candidate_id INT REFERENCES candidates(id),
    technology VARCHAR(255)
);

CREATE TABLE candidate_programming_languages (
    candidate_id INT REFERENCES candidates(id),
    programming_language VARCHAR(255)
);

CREATE TABLE candidate_databases (
    candidate_id INT REFERENCES candidates(id),
    database VARCHAR(255)
);

CREATE TABLE candidate_methodologies (
    candidate_id INT REFERENCES candidates(id),
    methodology VARCHAR(255)
);

CREATE TABLE candidate_tools_and_technologies (
    candidate_id INT REFERENCES candidates(id),
    tool_or_technology VARCHAR(255)
);
