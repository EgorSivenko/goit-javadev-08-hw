SELECT
    project_id,
    SUM(salary) * TIMESTAMPDIFF(MONTH, start_date, finish_date) AS project_price
FROM projects
JOIN project_workers USING (project_id)
JOIN workers USING (worker_id)
GROUP BY project_id
ORDER BY project_price DESC;
