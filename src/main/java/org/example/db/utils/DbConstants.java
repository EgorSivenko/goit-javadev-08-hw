package org.example.db.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class DbConstants {
    public static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/mega_soft";
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "strong_password";

    public static final String INIT_DB_FILE_PATH = "sql/init_db.sql";
    public static final String POPULATE_DB_FILE_PATH = "sql/populate_db.sql";

    public static final String FIND_MAX_SALARY_WORKER_FILE_PATH = "sql/find_max_salary_worker.sql";
    public static final String FIND_MAX_PROJECTS_CLIENT_FILE_PATH = "sql/find_max_projects_client.sql";
    public static final String FIND_LONGEST_PROJECT_FILE_PATH = "sql/find_longest_project.sql";
    public static final String FIND_YOUNGEST_ELDEST_WORKERS_FILE_PATH = "sql/find_youngest_eldest_workers.sql";
    public static final String PRINT_PROJECT_PRICES_FILE_PATH = "sql/print_project_prices.sql";
}
