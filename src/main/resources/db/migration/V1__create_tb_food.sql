CREATE TABLE tb_food (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         expiration_date DATE NOT NULL,
                         quantity INT NOT NULL
);
INSERT INTO tb_food (name, expiration_date, quantity) VALUES
                                                          ('Leite Integral', '2026-02-10', 2),
                                                          ('Ovos Caipira', '2026-01-30', 12),
                                                          ('Queijo Mussarela', '2026-02-05', 1),
                                                          ('Iogurte Natural', '2026-01-25', 4),
                                                          ('Manteiga com Sal', '2026-03-01', 3),
                                                          ('Suco de Laranja', '2026-01-28', 1),
                                                          ('Pão Integral', '2026-01-20', 2);