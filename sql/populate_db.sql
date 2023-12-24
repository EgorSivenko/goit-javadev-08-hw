INSERT INTO workers (worker_name, birthday, level, salary)
VALUES  ('Kent Beatty', '1986-09-15', 'Junior', 1234), 
        ('Holly Dooley', '1984-01-17', 'Middle', 4572),
        ('Andres Champlin', '1997-12-22', 'Senior', 6129),
        ('Dale Gerlach', '1993-10-14', 'Senior', 8380),
        ('Winston Hane', '1987-01-13', 'Middle', 3862),
        ('Dana Romaguera', '1974-03-16', 'Middle', 3129),
        ('Lindsay Ullrich', '1997-12-22', 'Trainee', 778),
        ('Camille Kling', '1991-07-08', 'Senior', 7120),
        ('Cristina Boyle', '1984-11-22', 'Senior', 8380),
        ('Lionel Carroll', '1992-11-21', 'Junior', 1718);
        
INSERT INTO clients (client_name)
VALUES  ('Bessie Connelly'),
        ('Dianna Kiehn'),
        ('Curtis Dach'),
        ('Ryan King'),
        ('Elena Monahan-Mueller'),
        ('Dixie Schulist'),
        ('George Hills'),
        ('Noel Haag'),
        ('Nettie Lebsack'),
        ('Shawn Beier');
        
INSERT INTO projects (client_id, start_date, finish_date)
VALUES  (3, '2017-02-16', '2021-10-02'),
        (2, '2018-06-07', '2021-11-21'),
        (6, '2017-06-22', '2021-02-04'),
        (4, '2018-10-02', '2020-11-28'),
        (5, '2017-08-04', '2022-09-02'),
        (7, '2018-02-03', '2020-11-10'),
        (10, '2019-09-02', '2022-11-09'),
        (3, '2017-01-28', '2021-04-20'),
        (6, '2018-02-12', '2020-11-17'),
        (5, '2017-05-19', '2022-06-01');
        
INSERT INTO project_workers (project_id, worker_id)
VALUES  (1, 3), (1, 5), (1, 6),
        (2, 2), (2, 4),
        (3, 1),
        (4, 6), (4, 8),
        (5, 1), (5, 2),
        (6, 3), (6, 9), (6, 10),
        (7, 3),
        (8, 2), (8, 4), (8, 7), (8, 10),
        (9, 8), (9, 9),
        (10, 2), (10, 5);
