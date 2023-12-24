SELECT worker_name, salary FROM workers
WHERE salary = (SELECT MAX(salary) FROM workers);
