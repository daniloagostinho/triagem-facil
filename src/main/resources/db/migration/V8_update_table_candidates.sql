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

-- Criando tabelas para armazenar listas de tecnologias usadas
CREATE TABLE candidate_experience_technologies (
    candidate_id INT,
    technology VARCHAR(255),
    PRIMARY KEY (candidate_id, technology),
    FOREIGN KEY (candidate_id) REFERENCES candidates(id)
);

CREATE TABLE candidate_project_technologies (
    candidate_id INT,
    technology VARCHAR(255),
    PRIMARY KEY (candidate_id, technology),
    FOREIGN KEY (candidate_id) REFERENCES candidates(id)
);

CREATE TABLE candidate_programming_languages (
    candidate_id INT,
    programming_language VARCHAR(255),
    PRIMARY KEY (candidate_id, programming_language),
    FOREIGN KEY (candidate_id) REFERENCES candidates(id)
);

CREATE TABLE candidate_databases (
    candidate_id INT,
    database_name VARCHAR(255),
    PRIMARY KEY (candidate_id, database_name),
    FOREIGN KEY (candidate_id) REFERENCES candidates(id)
);

CREATE TABLE candidate_methodologies (
    candidate_id INT,
    methodology VARCHAR(255),
    PRIMARY KEY (candidate_id, methodology),
    FOREIGN KEY (candidate_id) REFERENCES candidates(id)
);

CREATE TABLE candidate_tools_and_technologies (
    candidate_id INT,
    tool_technology VARCHAR(255),
    PRIMARY KEY (candidate_id, tool_technology),
    FOREIGN KEY (candidate_id) REFERENCES candidates(id)
);
