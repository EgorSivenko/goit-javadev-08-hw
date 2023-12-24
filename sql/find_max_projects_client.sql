SELECT
    client_name,
    COUNT(client_id) AS project_count
FROM projects
JOIN clients USING (client_id)
GROUP BY client_name
HAVING project_count = (
    SELECT 
        COUNT(client_id) AS project_count
    FROM projects
    GROUP BY client_id
    ORDER BY project_count DESC
    LIMIT 1
);
