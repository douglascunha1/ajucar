CREATE TABLE IF NOT EXISTS veiculo (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    ano INT NOT NULL,
    cor VARCHAR(255) NOT NULL,
    fabricante VARCHAR(255) NOT NULL,
    modelo VARCHAR(255) NOT NULL,
    preco DOUBLE NOT NULL,
    tipo_veiculo TINYINT NOT NULL
);

CREATE TABLE IF NOT EXISTS carro (
    quantidade_portas INT NOT NULL,
    tipo_combustivel VARCHAR(255) NOT NULL,
    id BIGINT NOT NULL PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES veiculo(id)
);

CREATE TABLE IF NOT EXISTS moto (
    cilindrada INT NOT NULL,
    id BIGINT NOT NULL PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES veiculo(id)
);

INSERT INTO veiculo (ano, cor, fabricante, modelo, preco, tipo_veiculo) VALUES
(2020, 'Vermelho', 'Ferrari', 'F8 Tributo', 1500000.00, 0),
(2019, 'Preto', 'Porsche', '911 GT3', 1200000.00, 0),
(2021, 'Branco', 'Tesla', 'Model S', 800000.00, 0),
(2018, 'Azul', 'BMW', 'M4', 600000.00, 0),
(2022, 'Cinza', 'Audi', 'RS7', 900000.00, 0),
(2020, 'Verde', 'Lamborghini', 'Huracán', 2500000.00, 0),
(2017, 'Amarelo', 'Chevrolet', 'Camaro', 300000.00, 0),
(2023, 'Prata', 'Mercedes-Benz', 'AMG GT', 1000000.00, 0),
(2019, 'Vermelho', 'Ford', 'Mustang', 350000.00, 0),
(2021, 'Preto', 'Toyota', 'Supra', 400000.00, 0),

(2022, 'Vermelho', 'Honda', 'CBR 1000RR', 80000.00, 1),
(2021, 'Preto', 'Yamaha', 'YZF-R1', 85000.00, 1),
(2020, 'Azul', 'Kawasaki', 'Ninja ZX-10R', 90000.00, 1),
(2019, 'Verde', 'Ducati', 'Panigale V4', 120000.00, 1),
(2023, 'Branco', 'BMW', 'S1000RR', 110000.00, 1),
(2018, 'Amarelo', 'Suzuki', 'GSX-R1000', 75000.00, 1),
(2022, 'Cinza', 'KTM', '1290 Super Duke R', 95000.00, 1),
(2021, 'Laranja', 'Aprilia', 'RSV4', 100000.00, 1),
(2020, 'Prata', 'Triumph', 'Speed Triple', 85000.00, 1),
(2019, 'Vermelho', 'Harley-Davidson', 'Sportster', 70000.00, 1);

INSERT INTO carro (quantidade_portas, tipo_combustivel, id) VALUES
    (2, 'Gasolina', 1),
    (2, 'Gasolina', 2),
    (4, 'Eletrico', 3),
    (2, 'Gasolina', 4),
    (4, 'Gasolina', 5),
    (2, 'Gasolina', 6),
    (2, 'Gasolina', 7),
    (2, 'Gasolina', 8),
    (2, 'Gasolina', 9),
    (2, 'Gasolina', 10);

INSERT INTO moto (cilindrada, id) VALUES
    (1000, 11),
    (1000, 12),
    (1000, 13),
    (1103, 14),
    (999, 15),
    (1000, 16),
    (1301, 17),
    (1099, 18),
    (1050, 19),
    (1200, 20);