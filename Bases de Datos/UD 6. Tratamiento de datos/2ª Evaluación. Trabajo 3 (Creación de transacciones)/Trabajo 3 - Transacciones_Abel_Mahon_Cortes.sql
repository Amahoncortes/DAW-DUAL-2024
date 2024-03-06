#En la base de datos DatosGalicia, realiza las siguientes operaciones en dos tablas:
#    • Crea una Transacción.
#    • Crea varios puntos de Restauración.
#    • Muestra todos los valores introducidos en la tabla.
#    • Restaura hacia alguno de los puntos de Restauración.
#    • Mostramos los valores que hay en la tabla.
#    • Copia los INSERT de los datos que necesites.
#    • Haz un borrado completo de los datos introducidos.
#    • Mostramos los valores que hay en la tabla.
#    • Copia los INSERT de los datos que necesites.
#    • Confirma finalmente los datos introducidos.
#    • Comprueba los valores que hay en la tabla.

-- Usar Base de datos
USE DatosGalicia;

-- Comienzo de la declaración de transacción
-- Nueva transacción
START TRANSACTION;

-- *******************************************************************************************
-- AGREGACIÓN DE DATOS A LAS TABLAS
-- *******************************************************************************************
-- TABLA Provincia
-- *******************************************************************************************

-- Establecer AUTO_INCREMENT
ALTER TABLE Provincia AUTO_INCREMENT = 10;

SAVEPOINT tablaVacia; -- Punto de guardado.

-- Insertar datos iniciales
INSERT INTO Provincia (nombre) VALUES ('A Coruña');
INSERT INTO Provincia (nombre) VALUES ('Lugo');

-- Crear punto de restauración 1
SAVEPOINT puntoRestauracion1;

-- Insertar más datos
INSERT INTO Provincia (nombre) VALUES ('Ourense');

-- Crear punto de restauración 2
SAVEPOINT puntoRestauracion2;

-- Insertar más datos
INSERT INTO Provincia (nombre) VALUES ('Pontevedra');

-- Mostrar todos los valores introducidos en la tabla
SELECT * FROM Provincia;

-- Restaurar hacia algún punto de restauración
ROLLBACK TO puntoRestauracion1;

-- Mostrar valores después de hacer el rollback
SELECT * FROM Provincia;

-- Volver a añadir datos perdidos después del rollback
INSERT INTO Provincia (nombre) VALUES ('Ourense');

-- Hacer borrado completo de los datos de la tabla
 ROLLBACK TO tablaVacia;

-- Mostrar valores después del borrado
SELECT * FROM Provincia;

-- Volver a insertar datos
INSERT INTO Provincia (nombre) VALUES ('Ourense');
SAVEPOINT puntoRestauracion2;
INSERT INTO Provincia (nombre) VALUES ('Pontevedra');

-- Confirmar finalmente los datos introducidos
COMMIT;