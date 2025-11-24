INSERT INTO categoria (descricao, valor_diaria, imagem_path)
VALUES ('Econômico', 89.90, '/uploads/categorias/placeholder.webp'),
       ('Sedan', 129.90, '/uploads/categorias/placeholder.webp'),
       ('SUV Compacto', 159.90, '/uploads/categorias/placeholder.webp'),
       ('SUV Premium', 229.90, '/uploads/categorias/placeholder.webp'),
       ('Picape', 199.90, '/uploads/categorias/placeholder.webp'),
       ('Hatchback', 109.90, '/uploads/categorias/placeholder.webp'),
       ('Luxo', 399.90, '/uploads/categorias/placeholder.webp');
GO

INSERT INTO carro
(placa, marca, modelo, cor, ano, tipo_combustivel, quilometragem, tipo_cambio, imagem_path, categoria_ID)
VALUES
-- Categoria 1
('ABC1A11', 'Fiat', 'Mobi', 'Branco', 2020, 'Gasolina', 32000, 'Manual', '/uploads/carros/placeholder.webp', 1),
('ABC1A12', 'VW', 'Up', 'Prata', 2019, 'Flex', 41000, 'Manual', '/uploads/carros/placeholder.webp', 1),
('ABC1A13', 'Chevrolet', 'Onix', 'Branco', 2021, 'Flex', 28000, 'Automático', '/uploads/carros/placeholder.webp', 1),
('ABC1A14', 'Hyundai', 'HB20', 'Preto', 2018, 'Flex', 52000, 'Manual', '/uploads/carros/placeholder.webp', 1),
('ABC1A15', 'Renault', 'Kwid', 'Vermelho', 2020, 'Gasolina', 25000, 'Manual', '/uploads/carros/placeholder.webp', 1),
('ABC1A16', 'Fiat', 'Uno', 'Prata', 2017, 'Flex', 64000, 'Manual', '/uploads/carros/placeholder.webp', 1),
('ABC1A17', 'Toyota', 'Etios', 'Branco', 2019, 'Flex', 47000, 'Manual', '/uploads/carros/placeholder.webp', 1),
('ABC1A18', 'VW', 'Gol', 'Cinza', 2021, 'Flex', 19000, 'Manual', '/uploads/carros/placeholder.webp', 1),
('ABC1A19', 'Chevrolet', 'Celta', 'Preto', 2016, 'Gasolina', 72000, 'Manual', '/uploads/carros/placeholder.webp', 1),
('ABC1A20', 'Fiat', 'Palio', 'Prata', 2015, 'Flex', 83000, 'Manual', '/uploads/carros/placeholder.webp', 1),

-- Categoria 2
('DEF2B11', 'VW', 'Voyage', 'Prata', 2020, 'Flex', 36000, 'Manual', '/uploads/carros/placeholder.webp', 2),
('DEF2B12', 'Hyundai', 'HB20S', 'Branco', 2021, 'Flex', 23000, 'Automático', '/uploads/carros/placeholder.webp', 2),
('DEF2B13', 'Fiat', 'Cronos', 'Preto', 2019, 'Flex', 42000, 'Manual', '/uploads/carros/placeholder.webp', 2),
('DEF2B14', 'Toyota', 'Yaris Sedan', 'Cinza', 2022, 'Flex', 15000, 'Automático', '/uploads/carros/placeholder.webp', 2),
('DEF2B15', 'Honda', 'City', 'Branco', 2020, 'Flex', 33000, 'Automático', '/uploads/carros/placeholder.webp', 2),
('DEF2B16', 'Chevrolet', 'Prisma', 'Preto', 2018, 'Flex', 56000, 'Manual', '/uploads/carros/placeholder.webp', 2),
('DEF2B17', 'VW', 'Virtus', 'Prata', 2022, 'Flex', 12000, 'Automático', '/uploads/carros/placeholder.webp', 2),
('DEF2B18', 'Nissan', 'Versa', 'Branco', 2019, 'Flex', 41000, 'Automático', '/uploads/carros/placeholder.webp', 2),
('DEF2B19', 'Renault', 'Logan', 'Cinza', 2017, 'Flex', 67000, 'Manual', '/uploads/carros/placeholder.webp', 2),
('DEF2B20', 'Toyota', 'Corolla XEi', 'Prata', 2016, 'Flex', 88000, 'Automático', '/uploads/carros/placeholder.webp', 2),

-- Categoria 3
('GHI3C11', 'Jeep', 'Renegade', 'Branco', 2022, 'Flex', 14000, 'Automático', '/uploads/carros/placeholder.webp', 3),
('GHI3C12', 'Hyundai', 'Creta', 'Preto', 2020, 'Flex', 35000, 'Automático', '/uploads/carros/placeholder.webp', 3),
('GHI3C13', 'Nissan', 'Kicks', 'Cinza', 2021, 'Flex', 26000, 'Automático', '/uploads/carros/placeholder.webp', 3),
('GHI3C14', 'VW', 'T-Cross', 'Prata', 2022, 'Flex', 18000, 'Automático', '/uploads/carros/placeholder.webp', 3),
('GHI3C15', 'Honda', 'HR-V', 'Vermelho', 2019, 'Gasolina', 39000, 'Automático', '/uploads/carros/placeholder.webp', 3),
('GHI3C16', 'Chevrolet', 'Tracker', 'Preto', 2022, 'Flex', 11000, 'Automático', '/uploads/carros/placeholder.webp', 3),
('GHI3C17', 'Renault', 'Duster', 'Branco', 2018, 'Flex', 62000, 'Manual', '/uploads/carros/placeholder.webp', 3),
('GHI3C18', 'Fiat', 'Pulse', 'Cinza', 2022, 'Flex', 8000, 'Automático', '/uploads/carros/placeholder.webp', 3),
('GHI3C19', 'Peugeot', '2008', 'Preto', 2020, 'Flex', 30000, 'Automático', '/uploads/carros/placeholder.webp', 3),
('GHI3C20', 'Hyundai', 'IX35', 'Prata', 2017, 'Gasolina', 69000, 'Automático', '/uploads/carros/placeholder.webp', 3),

-- Categoria 4
('JKL4D11', 'BMW', 'X1', 'Branco', 2021, 'Gasolina', 28000, 'Automático', '/uploads/carros/placeholder.webp', 4),
('JKL4D12', 'Audi', 'Q3', 'Preto', 2019, 'Gasolina', 33000, 'Automático', '/uploads/carros/placeholder.webp', 4),
('JKL4D13', 'Mercedes', 'GLA', 'Prata', 2020, 'Gasolina', 24000, 'Automático', '/uploads/carros/placeholder.webp', 4),
('JKL4D14', 'Volvo', 'XC40', 'Cinza', 2022, 'Híbrido', 9000, 'Automático', '/uploads/carros/placeholder.webp', 4),
('JKL4D15', 'Land Rover', 'Evoque', 'Branco', 2018, 'Gasolina', 47000, 'Automático', '/uploads/carros/placeholder.webp', 4),
('JKL4D16', 'BMW', 'X3', 'Preto', 2020, 'Gasolina', 35000, 'Automático', '/uploads/carros/placeholder.webp', 4),
('JKL4D17', 'Audi', 'Q5', 'Cinza', 2019, 'Gasolina', 41000, 'Automático', '/uploads/carros/placeholder.webp', 4),
('JKL4D18', 'Volvo', 'XC60', 'Prata', 2017, 'Híbrido', 52000, 'Automático', '/uploads/carros/placeholder.webp', 4),
('JKL4D19', 'BMW', 'X2', 'Azul', 2022, 'Gasolina', 7000, 'Automático', '/uploads/carros/placeholder.webp', 4),
('JKL4D20', 'Audi', 'SQ5', 'Preto', 2018, 'Gasolina', 60000, 'Automático', '/uploads/carros/placeholder.webp', 4),

-- Categoria 5
('MNO5E11', 'Fiat', 'Toro', 'Branco', 2021, 'Flex', 31000, 'Automático', '/uploads/carros/placeholder.webp', 5),
('MNO5E12', 'VW', 'Amarok', 'Preto', 2019, 'Diesel', 54000, 'Automático', '/uploads/carros/placeholder.webp', 5),
('MNO5E13', 'Toyota', 'Hilux', 'Prata', 2020, 'Diesel', 40000, 'Automático', '/uploads/carros/placeholder.webp', 5),
('MNO5E14', 'Chevrolet', 'S10', 'Branco', 2018, 'Diesel', 69000, 'Automático', '/uploads/carros/placeholder.webp', 5),
('MNO5E15', 'Ford', 'Ranger', 'Azul', 2021, 'Diesel', 35000, 'Automático', '/uploads/carros/placeholder.webp', 5),
('MNO5E16', 'Renault', 'Oroch', 'Cinza', 2017, 'Flex', 72000, 'Manual', '/uploads/carros/placeholder.webp', 5),
('MNO5E17', 'Nissan', 'Frontier', 'Preto', 2022, 'Diesel', 12000, 'Automático', '/uploads/carros/placeholder.webp', 5),
('MNO5E18', 'Fiat', 'Strada', 'Vermelho', 2020, 'Flex', 44000, 'Manual', '/uploads/carros/placeholder.webp', 5),
('MNO5E19', 'Chevrolet', 'Montana', 'Prata', 2019, 'Flex', 53000, 'Manual', '/uploads/carros/placeholder.webp', 5),
('MNO5E20', 'VW', 'Saveiro', 'Branco', 2021, 'Flex', 27000, 'Manual', '/uploads/carros/placeholder.webp', 5),

-- Categoria 6
('PQR6F11', 'BMW', '530i', 'Preto', 2021, 'Gasolina', 28000, 'Automático', '/uploads/carros/placeholder.webp', 6),
('PQR6F12', 'Mercedes', 'C300', 'Prata', 2020, 'Gasolina', 33000, 'Automático', '/uploads/carros/placeholder.webp', 6),
('PQR6F13', 'Audi', 'A6', 'Branco', 2022, 'Gasolina', 12000, 'Automático', '/uploads/carros/placeholder.webp', 6),
('PQR6F14', 'Volvo', 'S60', 'Cinza', 2019, 'Híbrido', 41000, 'Automático', '/uploads/carros/placeholder.webp', 6),
('PQR6F15', 'Porsche', 'Macan', 'Preto', 2018, 'Gasolina', 59000, 'Automático', '/uploads/carros/placeholder.webp', 6),
('PQR6F16', 'Jaguar', 'XE', 'Vermelho', 2020, 'Gasolina', 26000, 'Automático', '/uploads/carros/placeholder.webp', 6),
('PQR6F17', 'BMW', '740i', 'Branco', 2022, 'Gasolina', 9000, 'Automático', '/uploads/carros/placeholder.webp', 6),
('PQR6F18', 'Mercedes', 'E300', 'Azul', 2019, 'Gasolina', 50000, 'Automático', '/uploads/carros/placeholder.webp', 6),
('PQR6F19', 'Audi', 'A4', 'Prata', 2021, 'Gasolina', 23000, 'Automático', '/uploads/carros/placeholder.webp', 6),
('PQR6F20', 'BMW', 'M340i', 'Preto', 2022, 'Gasolina', 7000, 'Automático', '/uploads/carros/placeholder.webp', 6);
GO

INSERT INTO carro
(placa, marca, modelo, cor, ano, tipo_combustivel, quilometragem, tipo_cambio, imagem_path, categoria_ID)
VALUES ('HAT7G11', 'Fiat', 'Argo', 'Prata', 2021, 'Flex', 28000, 'Manual', '/uploads/carros/placeholder.webp', 7),
       ('HAT7G12', 'Hyundai', 'HB20', 'Branco', 2022, 'Flex', 15000, 'Automático', '/uploads/carros/placeholder.webp', 7),
       ('HAT7G13', 'VW', 'Polo', 'Cinza', 2019, 'Flex', 42000, 'Automático', '/uploads/carros/placeholder.webp', 7),
       ('HAT7G14', 'Chevrolet', 'Onix', 'Vermelho', 2020, 'Flex', 31000, 'Manual', '/uploads/carros/placeholder.webp', 7),
       ('HAT7G15', 'Renault', 'Sandero', 'Branco', 2018, 'Flex', 56000, 'Manual', '/uploads/carros/placeholder.webp', 7),
       ('HAT7G16', 'Toyota', 'Yaris', 'Preto', 2021, 'Flex', 23000, 'Automático', '/uploads/carros/placeholder.webp', 7),
       ('HAT7G17', 'Honda', 'Fit', 'Prata', 2017, 'Gasolina', 72000, 'Automático', '/uploads/carros/placeholder.webp', 7),
       ('HAT7G18', 'Peugeot', '208', 'Azul', 2020, 'Flex', 34000, 'Automático', '/uploads/carros/placeholder.webp', 7),
       ('HAT7G19', 'Citroen', 'C3', 'Amarelo', 2019, 'Flex', 47000, 'Manual', '/uploads/carros/placeholder.webp', 7),
       ('HAT7G20', 'Ford', 'Ka', 'Cinza', 2018, 'Flex', 53000, 'Manual', '/uploads/carros/placeholder.webp', 7);
GO

INSERT INTO locatario (CPF, nome, habilitacao, nascimento, logradouro, CEP, numero, cidade)
VALUES ('11111111111', 'Mariana Alves', '123456789', '1998-05-10', 'Rua das Flores', '04012000', '101', 'São Paulo'),
       ('22222222222', 'Rafael Torres', '987654321', '1995-08-22', 'Av Central', '21045000', '500', 'Rio de Janeiro'),
       ('33333333333', 'Luana Costa', '564738291', '1988-12-01', 'Rua Aroeiras', '69050000', '210', 'Manaus'),
       ('44444444444', 'Carlos Henrique', '837261945', '1992-03-15', 'Rua Primavera', '88020000', '85', 'Florianópolis'),
       ('55555555555', 'Juliana Rocha', '192837465', '1997-07-30', 'Av Brasil', '40015000', '132', 'Salvador'),
       ('66666666666', 'Pedro Martins', '948372615', '1985-11-09', 'Rua Bela Vista', '30120000', '42', 'Belo Horizonte'),
       ('77777777777', 'André Souza', '675849302', '1990-09-19', 'Rua Aurora', '69945000', '74', 'Rio Branco'),
       ('88888888888', 'Fernanda Silva', '564738920', '1999-02-28', 'Rua Imperial', '72035000', '300', 'Brasília'),
       ('99999999999', 'Larissa Mendes', '564738197', '2000-01-25', 'Rua dos Lírios', '64020000', '27', 'Teresina'),
       ('10101010101', 'Ricardo Braga', '765849302', '1984-06-12', 'Av dos Paineiros', '65050000', '122', 'São Luís'),
       ('12121212121', 'Daniela Prado', '918273645', '1993-10-03', 'Rua Azul', '78090000', '15', 'Cuiabá'),
       ('13131313131', 'Gabriel Lima', '283746501', '1996-04-14', 'Trav. Aurora', '68925000', '67', 'Macapá');
GO

INSERT INTO locacao (carro_placa, locatario_CPF, data_retirada, dias_locacao, data_devolucao, valor_total, valor_extra)
VALUES ('ABC1A11', '11111111111', '2025-01-05', 5, '2025-01-10', 449.50, 0.0),
       ('DEF2B12', '22222222222', '2025-01-12', 3, '2025-01-15', 389.70, 20.0),
       ('GHI3C13', '33333333333', '2025-02-01', 7, '2025-02-08', 1129.30, 0.0),
       ('JKL4D14', '44444444444', '2025-02-10', 4, '2025-02-14', 916.00, 50.0),
       ('MNO5E15', '55555555555', '2025-02-22', 2, '2025-02-24', 399.80, 0.0),
       ('PQR6F11', '66666666666', '2025-03-01', 6, '2025-03-07', 2399.40, 0.0),
       ('ABC1A12', '77777777777', '2025-03-05', 5, '2025-03-10', 449.50, 15.0),
       ('DEF2B19', '88888888888', '2025-03-10', 3, '2025-03-13', 389.70, 0.0),
       ('GHI3C18', '99999999999', '2025-03-18', 4, '2025-03-22', 636.00, 30.0),
       ('JKL4D12', '10101010101', '2025-03-20', 8, '2025-03-28', 1839.20, 0.0),
       ('MNO5E18', '12121212121', '2025-03-22', 2, '2025-03-24', 399.80, 0.0),
       ('PQR6F19', '13131313131', '2025-03-25', 1, '2025-03-26', 399.00, 0.0),
       ('ABC1A13', '11111111111', '2025-03-28', 3, '2025-03-31', 299.70, 10.0),
       ('DEF2B16', '22222222222', '2025-04-01', 6, '2025-04-07', 779.40, 0.0),
       ('GHI3C11', '33333333333', '2025-04-03', 4, '2025-04-07', 636.00, 25.0),
       ('JKL4D19', '44444444444', '2025-04-05', 5, '2025-04-10', 1149.50, 0.0),
       ('MNO5E19', '55555555555', '2025-04-09', 3, '2025-04-12', 599.70, 0.0),
       ('PQR6F14', '66666666666', '2025-04-12', 7, '2025-04-19', 2793.00, 120.0),
       ('ABC1A17', '77777777777', '2025-04-15', 4, '2025-04-19', 359.60, 0.0),
       ('DEF2B20', '88888888888', '2025-04-18', 6, '2025-04-24', 779.40, 0.0);
GO

INSERT INTO reparo (entrada, dias_reparo, diagnostico, valor_reparo, carro_placa)
VALUES ('2025-01-10', 3, 'Troca de pastilhas de freio', 350.00, 'ABC1A11'),
       ('2025-01-15', 5, 'Problema elétrico', 780.00, 'DEF2B12'),
       ('2025-02-01', 7, 'Troca de amortecedores', 1200.00, 'GHI3C13'),
       ('2025-02-05', 2, 'Alinhamento e balanceamento', 150.00, 'JKL4D14'),
       ('2025-02-08', 4, 'Troca de embreagem', 1900.00, 'MNO5E15'),
       ('2025-02-20', 6, 'Defeito na bomba de combustível', 890.00, 'PQR6F11'),
       ('2025-03-01', 3, 'Substituição da bateria', 450.00, 'ABC1A12'),
       ('2025-03-04', 5, 'Reparo no ar-condicionado', 600.00, 'DEF2B19'),
       ('2025-03-10', 2, 'Troca de óleo e filtros', 200.00, 'GHI3C18'),
       ('2025-03-15', 7, 'Problema na injeção eletrônica', 1300.00, 'JKL4D12'),
       ('2025-03-18', 3, 'Barulho na suspensão', 350.00, 'MNO5E18'),
       ('2025-03-22', 8, 'Reparo no câmbio', 2800.00, 'PQR6F19'),
       ('2025-03-26', 4, 'Troca de velas', 220.00, 'ABC1A13'),
       ('2025-04-02', 6, 'Reparo no motor', 3500.00, 'DEF2B16'),
       ('2025-04-05', 2, 'Troca de pneus', 1600.00, 'GHI3C11');
GO