-- EMPEZAMOS LA TRANSACCION DESPUES DE CREAR LA TABLA PROVINCIA
-- Preludio. Borrar todos los datos de la tabla para volver a empezar sin duplicados
DELETE FROM Provincia;

-- Ejercicio 1.Comienzo de la declaración de transacción
START TRANSACTION;

-- *******************************************************************************************
-- AGREGACIÓN DE DATOS A LAS TABLAS
-- *******************************************************************************************
-- TABLA Provincia
-- *******************************************************************************************
-- Hacer borrado completo de los datos de la tabla

-- Ejercicio 2. Insertar datos iniciales
INSERT INTO Provincia (nombre) VALUES ('A Coruña');
INSERT INTO Provincia (nombre) VALUES ('Lugo');


-- Ejercicio 3.Crear punto de restauración 1
SAVEPOINT puntoRestauracion1;

-- Ejercicio 4.Insertar más datos iniciales
INSERT INTO Provincia (nombre) VALUES ('Ourense');
INSERT INTO Provincia (nombre) VALUES ('Pontevedra');

-- Ejercicio 5.Crear punto de restauración 2
SAVEPOINT puntoRestauracion2;

-- Ejercicio 6.Mostrar todos los valores introducidos en la tabla
SELECT * FROM Provincia;

-- Ejercicio 7.Restaurar hacia algún punto de restauración
ROLLBACK TO puntoRestauracion1;


-- Ejercicio 8.Mostrar los valores que hay en la tabla
-- Solo tenemos A Coruña y Lugo
SELECT * FROM Provincia;


-- Ejercicio 9.Copia los INSERT de los datos que necesites.
INSERT INTO Provincia (nombre) VALUES ('Ourense');
INSERT INTO Provincia (nombre) VALUES ('Pontevedra');

-- Ejercicio 10.Haz un borrado de los datos introducidos.
DELETE FROM Provincia;

-- Ejercicio 11.Mostramos los valores que hay en la tabla.
-- Debería estar vacía.
SELECT * FROM Provincia;

-- Ejercicio 12.Copia los INSERT de los datos que necesites.
INSERT INTO Provincia (nombre) VALUES ('A Coruña');
INSERT INTO Provincia (nombre) VALUES ('Lugo');
INSERT INTO Provincia (nombre) VALUES ('Ourense');
INSERT INTO Provincia (nombre) VALUES ('Pontevedra');

-- Ejercicio 13.Confirma finalmente los datos introducidos.
COMMIT;

-- Ejercicio 14.Comprobar los valores que hay en la tabla
SELECT * FROM Provincia;