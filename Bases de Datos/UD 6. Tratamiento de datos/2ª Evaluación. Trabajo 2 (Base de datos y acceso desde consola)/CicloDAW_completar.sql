#*******************************************************************************************
#	1.	CREACIÓN Y USO DE LA BASE DE DATOS 'CicloDAW'
#*******************************************************************************************
-- DROP de la base de datos si existe
DROP DATABASE IF EXISTS CicloDAW;

-- Crear la base de datos
CREATE DATABASE CicloDAW;

-- Utilizar la base de datos recién creada
USE CicloDAW;
#*******************************************************************************************
#	2.	CREACIÓN DE LA TABLA DE LA BASE DE DATOS
#*******************************************************************************************
#		TABLA Modulo
#*******************************************************************************************
#		ID		int				auto_increment
#		Siglas	varchar(5)
#		Codigo	varchar(6)
#		Nombre	text
#		Horas	int
#
#		Llave primaria 					->	ID empieza desde el valor 100
#		Valor único    					->	Siglas, Codigo
#		Comprobación de Valor no nulo	->	Siglas, Codigo, Nombre, Horas
#		Comprobación de Valor no vacío	->	Siglas, Codigo, Nombre
#		Comprobación de Valor positivo	->	Horas
#		Índice							->	Horas
#*******************************************************************************************
-- DROP de la tabla si existe
DROP TABLE IF EXISTS modulo;

-- Crear la tabla módulo
CREATE TABLE modulo (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Siglas VARCHAR(5) UNIQUE NOT NULL 
    CHECK (Siglas IS NOT NULL AND Siglas <> ''),
    Codigo VARCHAR(6) UNIQUE NOT NULL 
    CHECK (Codigo IS NOT NULL AND Codigo <> ''),
    Nombre TEXT NOT NULL 
    CHECK (Nombre IS NOT NULL AND Nombre <> ''),
    Horas INT CHECK (Horas IS NOT NULL AND Horas > 0)
);

-- Establecer el valor inicial para ID
ALTER TABLE modulo AUTO_INCREMENT = 100;

-- Crear el índice en la columna Horas
CREATE INDEX idx_horas ON modulo (Horas);
    
#*******************************************************************************************
#	3.	AÑADIMOS LOS DATOS SIGLAS, CÓDIGO, NOMBRE Y HORAS DE CADA MÓDULO DENTRO DE UNA MISMA SENTENCIA
#*******************************************************************************************
-- Insertar datos en la tabla modulo
INSERT INTO modulo (ID, Siglas, Codigo, Nombre, Horas) VALUES
    (100, 'LMARC', 'MP0373', 'Linguaxes de marcas e sistemas de xestion empresarial', 133),
    (101, 'SI', 'MP0483', 'Sistemas Informáticos', 186),
    (102, 'BD', 'MP0484', 'Bases de Datos', 187),
    (103, 'Prog', 'MP0485', 'Programación', 240), 
	(104, 'CD', 'MP0487', 'Contornos de Desenvolvemento', 107), 
	(105, 'DWEBC', 'MP0612', 'Desenvolvemento Web en Contorno Cliente', 157), 
	(106, 'DWEBS', 'MP0613', 'Desenvolvemento Web en Contorno Servidor', 175), 
	(107, 'DAW', 'MP0614', 'Despregamento de Aplicacións Web', 88), 
	(108, 'DIM', 'MP0615', 'Deseño de Interfaces Web', 157),
	(109, 'Prox', 'MP0616', 'Proxecto de Desenvolvemento de Aplicacións Web', 26), 
	(110, 'FOL', 'MP0617', 'Formación e Orientación Laboral', 107), 
	(111, 'EIE', 'MP0618', 'Empresa e Iniciativa emprendedora', 53),
	(112, 'FCT', 'MP0619', 'Formación en Centros de traballo', 384);
	
#*******************************************************************************************
#	4.	CREAMOS 10 ALUMNOS Y 5 PROFESORES CON FORMATO Alumn_01, Alumn_02, ...Y Prof_1, Prof_2, ...
#*******************************************************************************************
-- Crear usuarios para alumnos
-- DROP de usuarios si existen
DROP USER IF EXISTS 'Alumn_01', 'Alumn_02', 'Alumn_03', 'Alumn_04', 'Alumn_05', 'Alumn_06', 'Alumn_07', 'Alumn_08', 'Alumn_09', 'Alumn_10', 'alumn_pirata';
DROP USER IF EXISTS 'Prof_01', 'Prof_02', 'Prof_03', 'Prof_04', 'Prof_05';

-- Crear usuarios para alumnos
CREATE USER 'Alumn_01';
CREATE USER 'Alumn_02';
CREATE USER 'Alumn_03';
CREATE USER 'Alumn_04';
CREATE USER 'Alumn_05';
CREATE USER 'Alumn_06';
CREATE USER 'Alumn_07';
CREATE USER 'Alumn_08';
CREATE USER 'Alumn_09';
CREATE USER 'Alumn_10';

-- Crear usuarios para profesores
CREATE USER 'Prof_01';
CREATE USER 'Prof_02';
CREATE USER 'Prof_03';
CREATE USER 'Prof_04';
CREATE USER 'Prof_05';
#*******************************************************************************************
#	5.	CREAMOS DOS GRUPOS DE USUARIOS:	ALUMNADO, PROFESORADO
#		PROFESORADO -> ACCESO TOTAL
#		ALUMNADO	-> SÓLO CONSULTA
#*******************************************************************************************
-- DROP de roles si existen
DROP ROLE IF EXISTS ALUMNADO, PROFESORADO;

-- Crear roles ALUMNADO y PROFESORADO
CREATE ROLE ALUMNADO;
CREATE ROLE PROFESORADO;
#*******************************************************************************************
#	6.	DAMOS LOS RESPECTIVOS PRIVILEGIOS A LOS GRUPOS PROFESORADO Y ALUMNADO
#		PROFESORADO		Posibilidad de privilegios de acceso (role_admin) y creación de  usuarios (create user)
#		ALUMNADO		Sólo visibilidad (select)
#*******************************************************************************************
-- Asignar permisos al rol ALUMNADO
GRANT SELECT ON CicloDAW.* TO ALUMNADO;

-- Asignar permisos al rol PROFESORADO
GRANT ALL PRIVILEGES ON *.* TO PROFESORADO;
GRANT CREATE USER ON *.* TO PROFESORADO;
GRANT ALL PRIVILEGES ON *.* TO PROFESORADO WITH GRANT OPTION;
#*******************************************************************************************
#	7.	ASIGNAMOS A CADA GRUPO SUS USUARIOS CREADOS
#*******************************************************************************************
-- Asignar roles a los usuarios
GRANT ALUMNADO TO 'Alumn_01', 'Alumn_02', 'Alumn_03', 'Alumn_04', 'Alumn_05', 'Alumn_06', 'Alumn_07', 'Alumn_08', 'Alumn_09', 'Alumn_10';
GRANT PROFESORADO TO 'Prof_01', 'Prof_02', 'Prof_03', 'Prof_04', 'Prof_05' WITH ADMIN OPTION;
#*******************************************************************************************
#	8.	ASIGNAMOS PRIVILEGIOS POR DEFECTO
#*******************************************************************************************  
-- Asignar permisos al rol ALUMNADO
SET DEFAULT ROLE ALUMNADO FOR 'Alumn_01';
SET DEFAULT ROLE ALUMNADO FOR 'Alumn_02';
SET DEFAULT ROLE ALUMNADO FOR 'Alumn_03';
SET DEFAULT ROLE ALUMNADO FOR 'Alumn_04';
SET DEFAULT ROLE ALUMNADO FOR 'Alumn_05';
SET DEFAULT ROLE ALUMNADO FOR 'Alumn_06';
SET DEFAULT ROLE ALUMNADO FOR 'Alumn_07';
SET DEFAULT ROLE ALUMNADO FOR 'Alumn_08';
SET DEFAULT ROLE ALUMNADO FOR 'Alumn_09';
SET DEFAULT ROLE ALUMNADO FOR 'Alumn_10';

-- Asignar permisos al rol PROFESORADO
SET DEFAULT ROLE PROFESORADO FOR 'Prof_01';
SET DEFAULT ROLE PROFESORADO FOR 'Prof_02';
SET DEFAULT ROLE PROFESORADO FOR 'Prof_03';
SET DEFAULT ROLE PROFESORADO FOR 'Prof_04';
SET DEFAULT ROLE PROFESORADO FOR 'Prof_05';

#*******************************************************************************************
#	9.	REFRESCAMOS LOS CAMBIOS YA REALIZADOS (AUNQUE NO ES NECESARIO)
#*******************************************************************************************
FLUSH PRIVILEGES;

