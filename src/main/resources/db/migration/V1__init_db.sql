CREATE TABLE IF NOT EXISTS workers (
    worker_id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    worker_name VARCHAR(1000) CHECK (length(worker_name) >= 2) NOT NULL,
    birthday DATE CHECK (birthday >= '1901-01-01') NOT NULL,
    level ENUM('Trainee', 'Junior', 'Middle', 'Senior') NOT NULL DEFAULT 'Trainee',
    salary INT CHECK (salary BETWEEN 100 AND 100000) NOT NULL DEFAULT 0
);

CREATE TABLE IF NOT EXISTS clients (
    client_id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    client_name VARCHAR(1000) CHECK (length(client_name) >= 2) NOT NULL
);

CREATE TABLE IF NOT EXISTS projects (
    project_id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    client_id INT NOT NULL,
    start_date DATE NOT NULL,
    finish_date DATE NOT NULL,
    FOREIGN KEY (client_id) REFERENCES clients(client_id)
);

CREATE TABLE IF NOT EXISTS project_workers (
    project_id INT AUTO_INCREMENT NOT NULL,
    worker_id INT NOT NULL,
    PRIMARY KEY (project_id, worker_id),
    FOREIGN KEY (project_id) REFERENCES projects(project_id),
    FOREIGN KEY (worker_id) REFERENCES workers(worker_id)
);
