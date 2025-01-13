CREATE TABLE IF NOT EXISTS users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS gasto (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(255) NOT NULL,
    valor DECIMAL(10, 2) NOT NULL,
    data DATE NOT NULL,
    user_id BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

INSERT INTO users (nome, email, password) VALUES 
('User1', 'user1@example.com', 'password1'),
('User3', 'user3@example.com', 'password3'),
('User4', 'user4@example.com', 'password4'),
('User5', 'user5@example.com', 'password5'),
('User6', 'user6@example.com', 'password6'),
('User7', 'user7@example.com', 'password7'),
('User8', 'user8@example.com', 'password8'),
('User9', 'user9@example.com', 'password9'),
('User10', 'user10@example.com', 'password10'),
('User11', 'user11@example.com', 'password11'),
('User12', 'user12@example.com', 'password12'),
('User13', 'user13@example.com', 'password13'),
('User14', 'user14@example.com', 'password14'),
('User15', 'user15@example.com', 'password15');

INSERT INTO gasto (descricao, valor, data, user_id) VALUES
('Gasto1', 100.00, '2023-01-01', 1),
('Gasto2', 200.00, '2023-01-02', 2),
('Gasto3', 300.00, '2023-01-03', 3),
('Gasto4', 400.00, '2023-01-04', 4),
('Gasto5', 500.00, '2023-01-05', 5),
('Gasto6', 600.00, '2023-01-06', 6),
('Gasto7', 700.00, '2023-01-07', 7),
('Gasto8', 800.00, '2023-01-08', 8),
('Gasto9', 900.00, '2023-01-09', 9),
('Gasto10', 1000.00, '2023-01-10', 10),
('Gasto11', 1100.00, '2023-01-11', 11),
('Gasto12', 1200.00, '2023-01-12', 12),
('Gasto13', 1300.00, '2023-01-13', 13),
('Gasto14', 1400.00, '2023-01-14', 14),
('Gasto15', 1500.00, '2023-01-15', 15);
