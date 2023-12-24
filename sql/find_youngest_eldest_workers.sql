SELECT
    'Youngest' AS type,
    worker_name,
    birthday
FROM workers
WHERE TIMESTAMPDIFF(YEAR, birthday, CURDATE()) = (
    SELECT MIN(TIMESTAMPDIFF(YEAR, birthday, CURDATE()))
    FROM workers
)
UNION
SELECT
    'Eldest' AS type,
    worker_name,
    birthday
FROM workers
WHERE TIMESTAMPDIFF(YEAR, birthday, CURDATE()) = (
    SELECT MAX(TIMESTAMPDIFF(YEAR, birthday, CURDATE()))
    FROM workers
);
