CREATE TABLE candidates_dev (
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
    year_conclusion DATE
);

CREATE TABLE candidate_dev_technologies_used (
    candidate_id INT,
    technology VARCHAR(255),
    PRIMARY KEY (candidate_id, technology),
    FOREIGN KEY (candidate_id) REFERENCES candidates_dev(id)
);

CREATE TABLE candidate_dev_programming_languages (
    candidate_id INT,
    programming_language VARCHAR(255),
    PRIMARY KEY (candidate_id, programming_language),
    FOREIGN KEY (candidate_id) REFERENCES candidates_dev(id)
);

CREATE TABLE candidate_dev_databases (
    candidate_id INT,
    database_name VARCHAR(255),
    PRIMARY KEY (candidate_id, database_name),
    FOREIGN KEY (candidate_id) REFERENCES candidates_dev(id)
);

CREATE TABLE candidate_dev_methodologies (
    candidate_id INT,
    methodology VARCHAR(255),
    PRIMARY KEY (candidate_id, methodology),
    FOREIGN KEY (candidate_id) REFERENCES candidates_dev(id)
);

CREATE TABLE candidate_dev_tools_technologies (
    candidate_id INT,
    tool_technology VARCHAR(255),
    PRIMARY KEY (candidate_id, tool_technology),
    FOREIGN KEY (candidate_id) REFERENCES candidates_dev(id)
);
