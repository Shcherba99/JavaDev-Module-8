INSERT INTO megasoft.worker (NAME, BIRTHDAY, LEVEL, SALARY)
VALUES
    ('Pavlo', '1985-01-02', 'Trainee', 900),
    ('Ihor', '1986-02-03', 'Junior', 1500),
    ('Ivan', '1987-03-04', 'Senior', 3000),
    ('Oksana', '1988-04-05', 'Middle', 2200),
    ('Olga', '1989-05-06', 'Trainee', 1050),
    ('Serhiy', '1990-06-07', 'Junior', 1700),
    ('Natalia', '1991-07-08', 'Middle', 2500),
    ('Mykola', '1992-08-09', 'Senior', 3500),
    ('Yulia', '1993-09-10', 'Trainee', 1100),
    ('Viktor', '1994-10-11', 'Senior', 5500);

INSERT INTO megasoft.client (NAME)
VALUES
    ('Oleksandr'),
    ('Dmytro'),
    ('Andriy'),
    ('Kateryna'),
    ('Svetlana'),
    ('Vasyl'),
    ('Tetiana'),
    ('Mykhailo'),
    ('Yevhen'),
    ('Lilia');

INSERT INTO megasoft.project (ID, CLIENT_ID, START_DATE, FINISH_DATE)
VALUES
    (1, 10, '2024-08-01', '2024-09-25'),
    (2, 9, '2024-08-02', '2024-10-25'),
    (3, 9, '2024-08-03', '2024-11-25'),
    (4, 9, '2024-08-04', '2024-12-25'),
    (5, 6, '2024-08-05', '2025-01-25'),
    (6, 5, '2024-08-06', '2025-02-25'),
    (7, 4, '2024-08-07', '2025-03-25'),
    (8, 3, '2024-08-08', '2025-04-25'),
    (9, 2, '2024-08-09', '2025-05-25'),
    (10, 1, '2024-08-10', '2025-06-25');

INSERT INTO megasoft.project_worker (PROJECT_ID, WORKER_ID)
VALUES 
    (1, 1),
    (1, 2),
    (1, 3),
    (2, 4),
    (2, 5),
    (3, 6),
    (4, 7),
    (4, 8),
    (5, 9),
    (6, 10),
    (7, 5),
    (8, 6),
    (9, 7),
    (10, 8);