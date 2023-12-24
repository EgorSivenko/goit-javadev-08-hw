SELECT
    project_id,
    TIMESTAMPDIFF(MONTH, start_date, finish_date) AS month_count
FROM projects
HAVING month_count = (
    SELECT
        TIMESTAMPDIFF(MONTH, start_date, finish_date) AS month_count
    FROM projects
    ORDER BY month_count DESC
    LIMIT 1
);
