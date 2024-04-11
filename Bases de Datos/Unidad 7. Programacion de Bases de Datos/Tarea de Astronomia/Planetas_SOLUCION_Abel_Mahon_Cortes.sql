-- Borrar la vista DatosPlanetas si existe
DROP VIEW IF EXISTS DatosPlanetas;

-- Borrar las funciones si existen
DROP FUNCTION IF EXISTS calcularGravedad;
DROP FUNCTION IF EXISTS calcularVelocidadEscape;
DROP FUNCTION IF EXISTS calcularVelocidadOrbital;

-- Borrar los datos de la tabla PLANETA
DELETE FROM PLANETA;

-- Borrar la tabla PLANETA si existe
DROP TABLE IF EXISTS PLANETA;

-- Borrar la base de datos PLANETAS si existe
DROP DATABASE IF EXISTS PLANETAS;

-- Crear la base de datos PLANETAS
CREATE DATABASE PLANETAS;

-- Utilizar la base de datos PLANETAS
USE PLANETAS;

-- Crear la tabla PLANETA
CREATE TABLE PLANETA (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    distancia DOUBLE NOT NULL,
    masa DOUBLE NOT NULL,
    radio DOUBLE NOT NULL
);

-- Agregar los datos del Sol y de los ocho Planetas
INSERT INTO PLANETA (nombre, distancia, masa, radio) VALUES
    ('Sol', 0, 1.989 * POW(10,30), 696340e3),
    ('Mercurio', 57909050000, 3.285 * POW(10,23), 2439700),
    ('Venus', 108208930000, 4.867 * POW(10,24), 6051800),
    ('Tierra', 149597870700, 5.972 * POW(10,24), 6371000),
    ('Marte', 227936637200, 6.39 * POW(10,23), 3389500),
    ('Júpiter', 778412010000, 1.898 * POW(10,27), 69911000),
    ('Saturno', 1426725400000, 5.683 * POW(10,26), 58232000),
    ('Urano', 2870972200000, 8.681 * POW(10,25), 25362000),
    ('Neptuno', 4498252900000, 1.024 * POW(10,26), 24622000);

-- Crear la función para calcular la gravedad
DELIMITER //
CREATE FUNCTION calcularGravedad(masa DOUBLE, radio DOUBLE) RETURNS DOUBLE
BEGIN
    DECLARE g DOUBLE;
    SET g = (6.67430e-11 * masa) / POW(radio, 2);
    RETURN g;
END //
DELIMITER ;

-- Crear la función para calcular la velocidad de escape
DELIMITER //
CREATE FUNCTION calcularVelocidadEscape(masa DOUBLE, radio DOUBLE) RETURNS DOUBLE
BEGIN
    DECLARE v_escape DOUBLE;
    SET v_escape = SQRT((2 * 6.67430e-11 * masa) / radio);
    RETURN v_escape;
END //
DELIMITER ;

-- Crear la función para calcular la velocidad orbital
DELIMITER //
CREATE FUNCTION calcularVelocidadOrbital(masa DOUBLE, radio DOUBLE) RETURNS DOUBLE
BEGIN
    DECLARE v_orbital DOUBLE;
    SET v_orbital = SQRT((6.67430e-11 * masa) / radio);
    RETURN v_orbital;
END //
DELIMITER ;

-- Crear la vista para mostrar los datos de los planetas
CREATE VIEW DatosPlanetas AS 
SELECT 
    nombre AS 'Planeta',
    distancia AS 'Distancia al sol (m)',
    masa AS 'Masa (kg)',
    radio AS 'Radio (m)',
    calcularGravedad(masa, radio) AS 'Gravedad ecuatorial',
    calcularVelocidadEscape(masa, radio) AS 'Velocidad de escape (m/s)',
    calcularVelocidadOrbital(masa, radio) AS 'Velocidad Orbital'
FROM PLANETA;

-- Mostrar los datos de la Tierra como ejemplo
SET @masa = (SELECT masa FROM PLANETA WHERE nombre = 'Tierra');
SET @radio = (SELECT radio FROM PLANETA WHERE nombre = 'Tierra');
SET @distancia = (SELECT distancia FROM PLANETA WHERE nombre = 'Tierra');
SELECT calcularGravedad(@masa, @radio);
SELECT calcularVelocidadEscape(@masa, @radio);
SELECT * FROM DatosPlanetas;
