#---------------------------------------------------------------------------------------
#	CREACIÓN DE LA BASE DE DATOS Empresa
#---------------------------------------------------------------------------------------
DROP DATABASE IF EXISTS	Empresa;
CREATE DATABASE			Empresa;
USE						Empresa;

#---------------------------------------------------------------------------------------
#	CREACIÓN DE LAS TABLAS
#---------------------------------------------------------------------------------------
CREATE TABLE Oficina (
  idOficina 		INT 			AUTO_INCREMENT,
  nombreOficina 	VARCHAR( 50 ) ,
  numeroOficina		INT,
  dimension 		INT,
  ubicacion 		VARCHAR( 50 ),
  numeroMesas 		INT,
  CONSTRAINT	LlavePrimaria_Oficina	PRIMARY KEY ( idOficina ),
  CONSTRAINT	nombreOficinaNoNula		CHECK( nombreOficina 	IS NOT NULL ),
  CONSTRAINT	numeroOficinaNoNulo		CHECK( numeroOficina 	IS NOT NULL ),
  CONSTRAINT	dimensiónNoNula			CHECK( dimension		IS NOT NULL ),
  CONSTRAINT	ubicaciónNoNula			CHECK( ubicacion		IS NOT NULL ),
  CONSTRAINT	numeroMesasNoNulo		CHECK( numeroMesas		IS NOT NULL ),
  CONSTRAINT	NombreOficinaNoVacía	CHECK( nombreOficina 	!= '' ),
  CONSTRAINT	ubicacionNoVacía		CHECK( ubicacion		!= '' ),
  CONSTRAINT	numeroOficinaIncorrecto	CHECK( numeroOficina	>= 1000 ),
  CONSTRAINT	dimensionNoNegativa		CHECK( dimension		> 0 ),
  CONSTRAINT	numeroMesasNoNegativo	CHECK( numeroMesas		> 0 ),
  CONSTRAINT	nombreOficinaRepetido	UNIQUE( nombreOficina ),
  CONSTRAINT	numeroOficinaRepetido	UNIQUE( numeroOficina )
);

CREATE TABLE Empleado (
  idEmpleado 			INT 			AUTO_INCREMENT,
  NIFEmpleado			VARCHAR(  9 ),
  nombreEmpleado 		VARCHAR( 50 ),
  apellidosEmpleado 	VARCHAR( 50 ),
  fechaIncorporacion	DATE,
  CONSTRAINT	LlavePrimaria_Empleado		PRIMARY KEY ( idEmpleado ),
  CONSTRAINT	nombreEmpleadoNoNulo		CHECK( nombreEmpleado		IS NOT NULL ),
  CONSTRAINT	NIFEmpleadoNoNulo			CHECK( NIFEmpleado			IS NOT NULL ),
  CONSTRAINT	apellidosEmpleadoNoNulo		CHECK( apellidosEmpleado	IS NOT NULL ),
  CONSTRAINT	fechaIncorporacionNoNula	CHECK( fechaIncorporacion	IS NOT NULL ),
  CONSTRAINT	NIFEmpleadoNoVacío			CHECK( NIFEmpleado			!= '' ),
  CONSTRAINT	nombreEmpleadoNoVacío		CHECK( nombreEmpleado		!= '' ),
  CONSTRAINT	apellidosEmpleadoNoVacío	CHECK( apellidosEmpleado	!= '' ),
  CONSTRAINT	NIFDuplicado				UNIQUE( NIFEmpleado )
);
                   
CREATE TABLE Contratacion (
	idContratacion			INT	AUTO_INCREMENT,
	tipoContrato			VARCHAR( 40 ),
    inicioContratacion		DATE,
    finContratacion			DATE,
    Empleado				INT,
    Oficina					INT,
	puestoTrabajo			VARCHAR( 50 ),
    Jefe					INT,
    CONSTRAINT	PK_Contratacion				PRIMARY KEY( idContratacion ),
    CONSTRAINT	FK_Contratacion_Empleado	FOREIGN KEY( empleado )		REFERENCES Empleado( idEmpleado ),
    CONSTRAINT	FK_Contratacion_Oficina		FOREIGN KEY( oficina )		REFERENCES Oficina( idOficina ),
    CONSTRAINT	FK_Contratacion_Jefe		FOREIGN KEY( jefe )			REFERENCES Empleado( idEmpleado ),
    CONSTRAINT	tipoContratoNoNulo			CHECK( tipoContrato			IS NOT NULL ),
    CONSTRAINT	inicioContratacionNoNulo	CHECK( inicioContratacion	IS NOT NULL ),
    CONSTRAINT	empleadoNoNulo				CHECK( empleado				IS NOT NULL ),
    CONSTRAINT	oficinaNoNula				CHECK( oficina				IS NOT NULL ),
    CONSTRAINT	puestoTrabajoNoNulo			CHECK( puestoTrabajo		IS NOT NULL ),
    CONSTRAINT	tipoContratoNoVacío			CHECK( tipoContrato			!= '' ),
    CONSTRAINT	puestoTrabajoNoVacío		CHECK( puestoTrabajo		!= '' )
);

CREATE TABLE Salario (
  idSalario 			INT 	AUTO_INCREMENT,
  puestoTrabajo 		VARCHAR( 50 ),
  sueldoBase 			INT,
  incrementoAnual 		INT,
  productividad 		INT,
  CONSTRAINT	PK_Salario		PRIMARY KEY ( idSalario ),
  CONSTRAINT	Salario_puestoTrabajoNoNulo			CHECK( puestoTrabajo	IS NOT NULL ),
  CONSTRAINT	Salario_sueldoBaseNoNulo			CHECK( sueldoBase		IS NOT NULL ),
  CONSTRAINT	Salario_incrementoAnual				CHECK( incrementoAnual	IS NOT NULL ),
  CONSTRAINT	Salario_productividad				CHECK( productividad	IS NOT NULL ),
  CONSTRAINT	Salario_puestoTrabajoNoVacío		CHECK( puestoTrabajo	!= '' ),
  CONSTRAINT	Salario_sueldoBaseNoNegativo		CHECK( sueldoBase		>= 0 ),
  CONSTRAINT	Salario_incrementoAnualNoNegativo	CHECK( incrementoAnual	>= 0 ),
  CONSTRAINT	Salario_productividadNoNegativa		CHECK( productividad	>= 0 ),
  CONSTRAINT	Salario_sueldoBaseNoCero			CHECK( sueldoBase		!= 0 ),
  CONSTRAINT	Salario_incrementoAnualNoCero		CHECK( incrementoAnual	!= 0 )
);


#---------------------------------------------------------------------------------------
#	AGREGAMOS DATOS
#---------------------------------------------------------------------------------------
#---------------------------------------------------------------------------------------
#	Tabla de Oficinas - 8
#---------------------------------------------------------------------------------------
#INSERT	Oficina	( nombreOficina, numeroOficina, dimension, ubicacion, numeroMesas )	VALUES  	# MESAS 42
				( 			"Direccion",      1000,        50, "Planta 1", 2 ),
                ( 				 "RRHH",      8000,        50, "Planta 1", 6 ),
                ( 	  		  "Nóminas",      3600,        50, "Planta 1", 4 ),
                ( "Atención al Cliente",      1007,        50, "Planta 1", 9 ),
                ( 			   "Ventas",      1001,        50, "Planta 1", 8 ),
                ( 			  "Compras",      1002,        50, "Planta 1", 5 ),
                ( "Desarrollo Producto",      3505,        50, "Planta 1", 7 ),
                ( 			"Reuniones",      4040,        50, "Planta 1", 6 );
#---------------------------------------------------------------------------------------
#	Tabla de Empleados - 42
#---------------------------------------------------------------------------------------
INSERT	Empleado	( NIFEmpleado, nombreEmpleado, apellidosEmpleado, fechaIncorporacion )	VALUES
					( "42345678A", "Fulgencio", "Malatraba Uñíquez", 		"2024-02-01" ),
                    ( "62345678A", "Fulgencia", "Bienhallada Perfecta",		"2024-02-01" ),
                    ( "81111111A", "María", "López García", 				"2024-02-01" ),
                    ( "82222222B", "Juan", "Martínez Ruiz", 				"2024-02-02" ),
                    ( "63333333C", "Ana", "Sánchez Rodríguez", 				"2024-02-02" ),
                    ( "64444444D", "Carlos", "Fernández López", 			"2024-02-02" ),
                    ( "45555555E", "Laura", "González Martínez", 			"2024-02-02" ),
                    ( "76666666F", "David", "Pérez García", 				"2024-02-05" ),
                    ( "67777777G", "Sara", "Ruiz Sánchez", 					"2024-02-05" ),
                    ( "88888888H", "Javier", "Díaz Martínez", 				"2024-02-03" ),
                    ( "89999999I", "Elena", "López Pérez", 					"2024-02-05" ),
                    ( "70101010J", "Pedro", "García Ruiz", 					"2024-02-05" ),
                    ( "62121212K", "Marta", "Sánchez López", 				"2024-02-10" ),
                    ( "63131313L", "Roberto", "Martínez Sánchez", 			"2024-02-10" ),
                    ( "74141414M", "Carmen", "López Martínez", 				"2024-02-05" ),
                    ( "65151515N", "Daniel", "Sánchez Pérez", 				"2024-02-05" ),
                    ( "86161616O", "Paula", "Martínez García", 				"2024-02-09" ),
                    ( "47171717P", "Diego", "González Sánchez", 			"2024-02-09" ),
                    ( "58181818Q", "Lucía", "Pérez López", 					"2024-02-13" ),
                    ( "79191919R", "Adrián", "Sánchez Ruiz", 				"2024-02-14" ),
                    ( "60202020S", "Eva", "Martínez López", 				"2024-02-05" ),
                    ( "81212121T", "Marcos", "González Pérez", 				"2024-02-05" ),
                    ( "73232323U", "María José", "García López", 			"2024-02-12" ),
                    ( "84343434V", "Juan Antonio", "Martínez Gómez", 		"2024-02-10" ),
                    ( "55454545W", "Ana María", "Sánchez Rodríguez", 		"2024-02-15" ),
                    ( "76565656X", "Carlos Alberto", "Fernández López", 	"2024-02-17" ),
                    ( "57676767Y", "Laura Isabel", "González Martínez", 	"2024-02-25" ),
                    ( "38787878Z", "David Alejandro", "Pérez García", 		"2024-02-08" ),
                    ( "39898989A", "Sara Lucía", "Ruiz Sánchez", 			"2024-02-12" ),
                    ( "40909090B", "Javier Miguel", "Díaz Martínez", 		"2024-02-05" ),
                    ( "22121212C", "Elena Patricia", "López Pérez", 		"2024-02-15" ),
                    ( "33232323D", "Pedro José", "García Ruiz", 			"2024-02-05" ),
                    ( "34343434E", "Marta María", "Sánchez López", 			"2024-02-06" ),
                    ( "45454545F", "Roberto Antonio", "Martínez Sánchez", 	"2024-02-07" ),
                    ( "46565656G", "Carmen Isabel", "López Martínez", 		"2024-02-07" ),
                    ( "37676767H", "Daniel Alejandro", "Sánchez Pérez", 	"2024-02-11" ),
                    ( "38787878I", "Paula María", "Martínez García", 		"2024-02-13" ),
                    ( "29898989J", "Diego José", "González Sánchez", 		"2024-02-22" ),
                    ( "30909090K", "Lucía Antonia", "Pérez López", 			"2024-03-01" ),
                    ( "20101010L", "Adrián Manuel", "Sánchez Ruiz", 		"2024-03-03" ),
                    ( "41212121M", "Eva María", "Martínez López", 			"2024-03-05" ),
                    ( "31313131N", "Marcos Antonio", "González Pérez", 		"2024-03-05" );
#---------------------------------------------------------------------------------------
#	Tabla de Contrataciones
#---------------------------------------------------------------------------------------
INSERT Contratacion( tipoContrato, inicioContratacion, finContratacion, Empleado, Oficina, puestoTrabajo, Jefe )	VALUES
					( 'Indefinido', "2024-02-01", NULL,  1, 1, 'Director', NULL ),
                    ( 'Indefinido', "2024-02-01", NULL,  2, 2, 'Jefe de Recursos Humanos', 1 ),
                    ( 'Indefinido', "2024-02-01", NULL,  3, 3, 'Jefe de Nóminas', 1 ),
                    ( 'Indefinido', "2024-02-02", NULL,  4, 4, 'Jefe de Atención al Cliente', 1 ),
                    ( 'Indefinido', "2024-02-02", NULL,  5, 5, 'Jefe de Ventas', 1 ),
                    ( 'Indefinido', "2024-02-02", NULL,  6, 6, 'Jefe de Compras', 1 ),
                    ( 'Indefinido', "2024-02-02", NULL,  7, 7, 'Jefe de Desarrollo de Productos', 1 ),
                    ( 'Indefinido', "2024-02-05", NULL,  8, 8, 'Jefe de Reuniones', 1 ),
                    ( 'Indefinido', "2024-02-06", NULL,  9, 1, 'Secretario del Director', 1 ),
                    ( 'Indefinido', "2024-02-04", NULL, 10, 2, 'Trabajador de Recursos Humanos', 2 ),
                    ( 'Indefinido', "2024-02-05", NULL, 11, 2, 'Trabajador de Recursos Humanos', 2 ),
                    ( 'Indefinido', "2024-02-05", NULL, 12, 2, 'Trabajador de Recursos Humanos', 2 ),
                    ( 'Indefinido', "2024-02-12", NULL, 13, 2, 'Trabajador de Recursos Humanos', 2 ),
                    ( 'Indefinido', "2024-02-12", NULL, 14, 2, 'Trabajador de Recursos Humanos', 2 ),
                    ( 'Indefinido', "2024-02-08", NULL, 15, 3, 'Trabajador de Nóminas', 3 ),
                    ( 'Indefinido', "2024-02-08", NULL, 16, 3, 'Trabajador de Nóminas', 3 ),
                    ( 'Indefinido', "2024-02-09", NULL, 17, 3, 'Trabajador de Nóminas', 3 ),
                    ( 'Indefinido', "2024-02-10", NULL, 18, 4, 'Trabajador de Atención al Cliente', 4 ),
                    ( 'Indefinido', "2024-02-14", NULL, 19, 4, 'Trabajador de Atención al Cliente', 4 ),
                    ( 'Indefinido', "2024-02-15", NULL, 20, 4, 'Trabajador de Atención al Cliente', 4 ),
                    ( 'Indefinido', "2024-02-07", NULL, 21, 5, 'Trabajador de Ventas', 5 ),
                    ( 'Indefinido', "2024-02-12", NULL, 22, 5, 'Trabajador de Ventas', 5 ),
                    ( 'Indefinido', "2024-02-13", NULL, 23, 5, 'Trabajador de Ventas', 5 ),
                    ( 'Indefinido', "2024-02-10", NULL, 24, 5, 'Trabajador de Ventas', 5 ),
                    ( 'Indefinido', "2024-02-15", NULL, 25, 5, 'Trabajador de Ventas', 5 ),
                    ( 'Indefinido', "2024-02-17", NULL, 26, 5, 'Trabajador de Ventas', 5 ),
                    ( 'Indefinido', "2024-02-26", NULL, 27, 5, 'Trabajador de Ventas', 5 ),
                    ( 'Indefinido', "2024-02-12", NULL, 28, 6, 'Trabajador de Compras', 6 ),
                    ( 'Indefinido', "2024-02-12", NULL, 29, 6, 'Trabajador de Compras', 6 ),
                    ( 'Indefinido', "2024-02-07", NULL, 30, 6, 'Trabajador de Compras', 6 ),
                    ( 'Indefinido', "2024-02-18", NULL, 31, 6, 'Trabajador de Compras', 6 ),
                    ( 'Indefinido', "2024-02-05", NULL, 32, 7, 'Trabajador de Desarrollo de Productos', 7 ),
                    ( 'Indefinido', "2024-02-09", NULL, 33, 7, 'Trabajador de Desarrollo de Productos', 7 ),
                    ( 'Indefinido', "2024-02-08", NULL, 34, 7, 'Trabajador de Desarrollo de Productos', 7 ),
                    ( 'Indefinido', "2024-02-07", NULL, 35, 7, 'Trabajador de Desarrollo de Productos', 7 ),
                    ( 'Indefinido', "2024-02-11", NULL, 36, 7, 'Trabajador de Desarrollo de Productos', 7 ),
                    ( 'Indefinido', "2024-02-13", NULL, 37, 7, 'Trabajador de Desarrollo de Productos', 7 ),
                    ( 'Indefinido', "2024-02-25", NULL, 38, 4, 'Trabajador de Atención al Cliente', 4 ),
                    ( 'Indefinido', "2024-03-02", NULL, 39, 4, 'Trabajador de Atención al Cliente', 4 ),
                    ( 'Indefinido', "2024-03-03", NULL, 40, 4, 'Trabajador de Atención al Cliente', 4 ),
                    ( 'Indefinido', "2024-03-05", NULL, 41, 4, 'Trabajador de Atención al Cliente', 4 ),
                    ( 'Indefinido', "2024-03-05", NULL, 42, 4, 'Trabajador de Atención al Cliente', 4 );
#---------------------------------------------------------------------------------------
#	Tabla de Salarios
#---------------------------------------------------------------------------------------
INSERT INTO Salario ( puestoTrabajo, sueldoBase, incrementoAnual, productividad )	VALUES
			( 'Director', 							   10000, 1200, 0 ),
            ( 'Jefe de Recursos Humanos', 	 	 		8200,  800, 4000),
            ( 'Jefe de Nóminas', 			 	 		7800,  820, 4200),
            ( 'Jefe de Atención al Cliente', 	 		8300,  850, 4300),
            ( 'Jefe de Ventas', 			 	 		7900,  780, 3900),
            ( 'Jefe de Compras', 			 	 		8100,  800, 4100),
            ( 'Jefe de Desarrollo de Productos', 		8400,  840, 4400),
            ( 'Jefe de Reuniones', 				 		7700,  770, 3900),
            ( 'Secretario del Director', 		 		7000,  700, 3500),
            ( 'Trabajador de Recursos Humanos',  		4200,  500, 2500),
            ( 'Trabajador de Nóminas', 			 		3800,  550, 2700),
            ( 'Trabajador de Atención al Cliente', 		4300,  600, 3000),
            ( 'Trabajador de Ventas', 					3900,  530, 2600),
            ( 'Trabajador de Compras', 					4100,  580, 2900),
            ( 'Trabajador de Desarrollo de Productos',	4400,  620, 3100);
#

#---------------------------------------------------------------------------------------
#---------------------------------------------------------------------------------------
#	CONVIERTE LOS INSERT DE CADA UNA DE LAS TABLAS EN LOS PROCEDIMIENTOS ESPECIFICADOS
#	EN LOS PASOS SIGUIENTES:
#		-	El procedimiento de los pasos del 5 al 8 es para agregar CADA tupla de cada una de las tablas
#		-	El procedimiento de los pasos 2 al 4 es para agregar TODAS las tuplas de cada una de las tablas
#		-	El procedimiento del paso 1 es para invocar a los cuatro siguientes procedimientos
#---------------------------------------------------------------------------------------
#---------------------------------------------------------------------------------------
#---------------------------------------------------------------------------------------

#---------------------------------------------------------------------------------------
#	1. Procedimiento agregarDatosEmpresa
#		Agregamos los datos de las cuatro tablas
#---------------------------------------------------------------------------------------
DELIMITER //
CREATE PROCEDURE agregarDatosEmpresa()
BEGIN
    -- Paso 1: Llamada al método de Añadir datos a la tabla Oficina
    CALL agregarOficinas();
    
    -- Paso 2: Llamada al método de Añadir datos a la tabla Empleado
    CALL agregarEmpleados();
    
    -- Paso 3: Llamada al método de Añadir datos a la tabla Contratacion
    CALL agregarContratos();
    
    -- Llamada al método de Paso 4: Añadir datos a la tabla Salario
    CALL agregarSalarios();
END //
DELIMITER ;


#---------------------------------------------------------------------------------------
#	2. Procedimiento agregarOficinas - AGREGAMOS LAS OCHO OFICINAS
#---------------------------------------------------------------------------------------
DELIMITER //
CREATE PROCEDURE agregarOficinas()
BEGIN
    -- Añadir datos a la tabla Oficina
    INSERT INTO Oficina (nombreOficina, numeroOficina, dimension, ubicacion, numeroMesas)
    VALUES
        ("Direccion", 1000, 50, "Planta 1", 2),
        ("RRHH", 8000, 50, "Planta 1", 6),
        ("Nóminas", 3600, 50, "Planta 1", 4),
        ("Atención al Cliente", 1007, 50, "Planta 1", 9),
        ("Ventas", 1001, 50, "Planta 1", 8),
        ("Compras", 1002, 50, "Planta 1", 5),
        ("Desarrollo Producto", 3505, 50, "Planta 1", 7),
        ("Reuniones", 4040, 50, "Planta 1", 6);
END //
DELIMITER ;


#---------------------------------------------------------------------------------------
#	3. Procedimiento agregarEmpleados - AGREGAMOS LOS 48 EMPLEADOS
#---------------------------------------------------------------------------------------
DELIMITER //
CREATE PROCEDURE agregarEmpleados()
BEGIN
    -- Añadir datos a la tabla Empleado
    INSERT INTO Empleado (NIFEmpleado, nombreEmpleado, apellidosEmpleado, fechaIncorporacion)
    VALUES
        ("42345678A", "Fulgencio", "Malatraba Uñíquez", "2024-02-01"),
        ("62345678A", "Fulgencia", "Bienhallada Perfecta", "2024-02-01"),
        ("81111111A", "María", "López García", "2024-02-01"),
        ("82222222B", "Juan", "Martínez Ruiz", "2024-02-02"),
        ("63333333C", "Ana", "Sánchez Rodríguez", "2024-02-02"),
        ("64444444D", "Carlos", "Fernández López", "2024-02-02"),
        ("45555555E", "Laura", "González Martínez", "2024-02-02"),
        ("76666666F", "David", "Pérez García", "2024-02-05"),
        ("67777777G", "Sara", "Ruiz Sánchez", "2024-02-05"),
        ("88888888H", "Javier", "Díaz Martínez", "2024-02-03"),
        ("89999999I", "Elena", "López Pérez", "2024-02-05"),
        ("70101010J", "Pedro", "García Ruiz", "2024-02-05"),
        ("62121212K", "Marta", "Sánchez López", "2024-02-10"),
        ("63131313L", "Roberto", "Martínez Sánchez", "2024-02-10"),
        ("74141414M", "Carmen", "López Martínez", "2024-02-05"),
        ("65151515N", "Daniel", "Sánchez Pérez", "2024-02-05"),
        ("86161616O", "Paula", "Martínez García", "2024-02-09"),
        ("47171717P", "Diego", "González Sánchez", "2024-02-09"),
        ("58181818Q", "Lucía", "Pérez López", "2024-02-13"),
        ("79191919R", "Adrián", "Sánchez Ruiz", "2024-02-14"),
        ("60202020S", "Eva", "Martínez López", "2024-02-05"),
        ("81212121T", "Marcos", "González Pérez", "2024-02-05"),
        ("73232323U", "María José", "García López", "2024-02-12"),
        ("84343434V", "Juan Antonio", "Martínez Gómez", "2024-02-10"),
        ("55454545W", "Ana María", "Sánchez Rodríguez", "2024-02-15"),
        ("76565656X", "Carlos Alberto", "Fernández López", "2024-02-17"),
        ("57676767Y", "Laura Isabel", "González Martínez", "2024-02-25"),
        ("38787878Z", "David Alejandro", "Pérez García", "2024-02-08"),
        ("39898989A", "Sara Lucía", "Ruiz Sánchez", "2024-02-12"),
        ("40909090B", "Javier Miguel", "Díaz Martínez", "2024-02-05"),
        ("22121212C", "Elena Patricia", "López Pérez", "2024-02-15"),
        ("33232323D", "Pedro José", "García Ruiz", "2024-02-05"),
        ("34343434E", "Marta María", "Sánchez López", "2024-02-06"),
        ("45454545F", "Roberto Antonio", "Martínez Sánchez", "2024-02-07"),
        ("46565656G", "Carmen Isabel", "López Martínez", "2024-02-07"),
        ("37676767H", "Daniel Alejandro", "Sánchez Pérez", "2024-02-11"),
        ("38787878I", "Paula María", "Martínez García", "2024-02-13"),
        ("29898989J", "Diego José", "González Sánchez", "2024-02-22"),
        ("30909090K", "Lucía Antonia", "Pérez López", "2024-03-01"),
        ("20101010L", "Adrián Manuel", "Sánchez Ruiz", "2024-03-03"),
        ("41212121M", "Eva María", "Martínez López", "2024-03-05"),
        ("31313131N", "Marcos Antonio", "González Pérez", "2024-03-05");
END //
DELIMITER ;


#---------------------------------------------------------------------------------------
#	3. Procedimiento agregarContratos - AGREGAMOS LOS 48 EMPLEADOS
#---------------------------------------------------------------------------------------
DELIMITER //
CREATE PROCEDURE agregarContratos()
BEGIN
    -- Añade contratos a todos los empleados
    INSERT INTO Contratacion (tipoContrato, inicioContratacion, finContratacion, Empleado, Oficina, puestoTrabajo, Jefe)
    VALUES
        ('Indefinido', '2024-02-01', NULL, 1, 1, 'Director', NULL),
        ('Indefinido', '2024-02-01', NULL, 2, 2, 'Jefe de Recursos Humanos', 1),
        ('Indefinido', '2024-02-01', NULL, 3, 3, 'Jefe de Nóminas', 1),
        ('Indefinido', '2024-02-02', NULL, 4, 4, 'Jefe de Atención al Cliente', 1),
        ('Indefinido', '2024-02-02', NULL, 5, 5, 'Jefe de Ventas', 1),
        ('Indefinido', '2024-02-02', NULL, 6, 6, 'Jefe de Compras', 1),
        ('Indefinido', '2024-02-02', NULL, 7, 7, 'Jefe de Desarrollo de Productos', 1),
        ('Indefinido', '2024-02-05', NULL, 8, 8, 'Jefe de Reuniones', 1),
        ('Indefinido', '2024-02-06', NULL, 9, 1, 'Secretario del Director', 1),
        ('Indefinido', '2024-02-04', NULL, 10, 2, 'Trabajador de Recursos Humanos', 2),
        ('Indefinido', '2024-02-05', NULL, 11, 2, 'Trabajador de Recursos Humanos', 2),
        ('Indefinido', '2024-02-05', NULL, 12, 2, 'Trabajador de Recursos Humanos', 2),
        ('Indefinido', '2024-02-12', NULL, 13, 2, 'Trabajador de Recursos Humanos', 2),
        ('Indefinido', '2024-02-12', NULL, 14, 2, 'Trabajador de Recursos Humanos', 2),
        ('Indefinido', '2024-02-08', NULL, 15, 3, 'Trabajador de Nóminas', 3),
        ('Indefinido', '2024-02-08', NULL, 16, 3, 'Trabajador de Nóminas', 3),
        ('Indefinido', '2024-02-09', NULL, 17, 3, 'Trabajador de Nóminas', 3),
        ('Indefinido', '2024-02-10', NULL, 18, 4, 'Trabajador de Atención al Cliente', 4),
        ('Indefinido', '2024-02-14', NULL, 19, 4, 'Trabajador de Atención al Cliente', 4),
        ('Indefinido', '2024-02-15', NULL, 20, 4, 'Trabajador de Atención al Cliente', 4),
        ('Indefinido', '2024-02-07', NULL, 21, 5, 'Trabajador de Ventas', 5),
        ('Indefinido', '2024-02-12', NULL, 22, 5, 'Trabajador de Ventas', 5),
        ('Indefinido', '2024-02-13', NULL, 23, 5, 'Trabajador de Ventas', 5),
        ('Indefinido', '2024-02-10', NULL, 24, 5, 'Trabajador de Ventas', 5),
        ('Indefinido', '2024-02-15', NULL, 25, 5, 'Trabajador de Ventas', 5),
        ('Indefinido', '2024-02-17', NULL, 26, 5, 'Trabajador de Ventas', 5),
        ('Indefinido', '2024-02-26', NULL, 27, 5, 'Trabajador de Ventas', 5),
        ('Indefinido', '2024-02-12', NULL, 28, 5, 'Trabajador de Ventas', 5),
        ('Indefinido', '2024-02-18', NULL, 29, 6, 'Trabajador de Compras', 6),
        ('Indefinido', '2024-02-20', NULL, 30, 6, 'Trabajador de Compras', 6),
        ('Indefinido', '2024-02-21', NULL, 31, 6, 'Trabajador de Compras', 6),
        ('Indefinido', '2024-02-07', NULL, 32, 7, 'Trabajador de Desarrollo de Productos', 7),
        ('Indefinido', '2024-02-11', NULL, 33, 7, 'Trabajador de Desarrollo de Productos', 7),
        ('Indefinido', '2024-02-13', NULL, 34, 7, 'Trabajador de Desarrollo de Productos', 7),
        ('Indefinido', '2024-02-07', NULL, 35, 7, 'Trabajador de Desarrollo de Productos', 7),
        ('Indefinido', '2024-02-12', NULL, 36, 7, 'Trabajador de Desarrollo de Productos', 7),
        ('Indefinido', '2024-02-13', NULL, 37, 7, 'Trabajador de Desarrollo de Productos', 7),
        ('Indefinido', '2024-02-22', NULL, 38, 7, 'Trabajador de Desarrollo de Productos', 7),
        ('Indefinido', '2024-02-05', NULL, 39, 8, 'Trabajador de Reuniones', 8),
        ('Indefinido', '2024-02-06', NULL, 40, 8, 'Trabajador de Reuniones', 8),
        ('Indefinido', '2024-02-07', NULL, 41, 8, 'Trabajador de Reuniones', 8),
        ('Indefinido', '2024-02-07', NULL, 42, 8, 'Trabajador de Reuniones', 8),
        ('Indefinido', '2024-02-11', NULL, 43, 8, 'Trabajador de Reuniones', 8),
        ('Indefinido', '2024-02-13', NULL, 44, 8, 'Trabajador de Reuniones', 8),
        ('Indefinido', '2024-02-22', NULL, 45, 8, 'Trabajador de Reuniones', 8),
        ('Indefinido', '2024-02-26', NULL, 46, 8, 'Trabajador de Reuniones', 8),
        ('Indefinido', '2024-02-26', NULL, 47, 8, 'Trabajador de Reuniones', 8),
        ('Indefinido', '2024-02-26', NULL, 48, 8, 'Trabajador de Reuniones', 8);
END //
DELIMITER ;


#---------------------------------------------------------------------------------------
#	4. Procedimiento agregarSalarios - AGREGAMOS LOS SALARIOS DE LOS DISTINTOS TIPOS DE EMPLEADOS
#---------------------------------------------------------------------------------------
DELIMITER //
CREATE PROCEDURE agregarSalarios()
BEGIN
    -- Añadimos salarios para los diferentes tipos de empleados
    INSERT INTO Salarios (tipoEmpleado, salario)
    VALUES
        ('Director', 10000),
        ('Jefe de Recursos Humanos', 7000),
        ('Jefe de Nóminas', 7000),
        ('Jefe de Atención al Cliente', 7000),
        ('Jefe de Ventas', 7000),
        ('Jefe de Compras', 7000),
        ('Jefe de Desarrollo de Productos', 7000),
        ('Jefe de Reuniones', 7000),
        ('Secretario del Director', 5000),
        ('Trabajador de Recursos Humanos', 4000),
        ('Trabajador de Nóminas', 4000),
        ('Trabajador de Atención al Cliente', 4000),
        ('Trabajador de Ventas', 4000),
        ('Trabajador de Compras', 4000),
        ('Trabajador de Desarrollo de Productos', 4000),
        ('Trabajador de Reuniones', 4000);
END //
DELIMITER ;


#---------------------------------------------------------------------------------------
#	5. Procedimiento agregarOficina( nombre, numero, dimension, ubicacion, Mesas )
#		( nombreOficina, numeroOficina, dimension, ubicacion, numeroMesas )
#---------------------------------------------------------------------------------------
DELIMITER //

CREATE PROCEDURE agregarOficina(
    IN p_nombreOficina VARCHAR(50),
    IN p_numeroOficina INT,
    IN p_dimension INT,
    IN p_ubicacion VARCHAR(50),
    IN p_numeroMesas INT
)
BEGIN
    -- Añade información de la oficina a la tabla Oficina
    INSERT INTO Oficina (nombreOficina, numeroOficina, dimension, ubicacion, numeroMesas)
    VALUES (p_nombreOficina, p_numeroOficina, p_dimension, p_ubicacion, p_numeroMesas);
END //

DELIMITER ;
#---------------------------------------------------------------------------------------
#	6. Procedimiento agregarEmpleado( NIF, Nombre, apellidos, incorporación )
#		( NIFEmpleado, nombreEmpleado, apellidosEmpleado, fechaIncorporacion )
#---------------------------------------------------------------------------------------
DELIMITER //

CREATE PROCEDURE agregarEmpleado(
    IN p_NIFEmpleado VARCHAR(9),
    IN p_nombreEmpleado VARCHAR(50),
    IN p_apellidosEmpleado VARCHAR(50),
    IN p_fechaIncorporacion DATE
)
BEGIN
    -- Añadimos datos de empleado a la tabla Empleado
    INSERT INTO Empleado (NIFEmpleado, nombreEmpleado, apellidosEmpleado, fechaIncorporacion)
    VALUES (p_NIFEmpleado, p_nombreEmpleado, p_apellidosEmpleado, p_fechaIncorporacion);
END //

DELIMITER ;


#---------------------------------------------------------------------------------------
#	7. Procedimiento agregarContratacion( Contrato, Inicio, Fin, Trabajador, Oficina, Puesto, Jefe )
#		( tipoContrato, inicioContratacion, finContratacion, Empleado, Oficina, puestoTrabajo, Jefe )
#---------------------------------------------------------------------------------------
DELIMITER //

CREATE PROCEDURE agregarContratacion(
    IN p_tipoContrato VARCHAR(40),
    IN p_inicioContratacion DATE,
    IN p_finContratacion DATE,
    IN p_Trabajador INT,
    IN p_Oficina INT,
    IN p_Puesto VARCHAR(50),
    IN p_Jefe INT
)
BEGIN
    -- Añade datos de contratos a la tabla de contratación
    INSERT INTO Contratacion (tipoContrato, inicioContratacion, finContratacion, Empleado, Oficina, puestoTrabajo, Jefe)
    VALUES (p_tipoContrato, p_inicioContratacion, p_finContratacion, p_Trabajador, p_Oficina, p_Puesto, p_Jefe);
END //

DELIMITER ;


#---------------------------------------------------------------------------------------
#	8. Procedimiento agregarSalario( Puesto, Base, Incremento, Productividad )
#		( puestoTrabajo, sueldoBase, incrementoAnual, productividad )
#---------------------------------------------------------------------------------------
DELIMITER //

CREATE PROCEDURE agregarSalario(
    IN p_puestoTrabajo VARCHAR(50),
    IN p_sueldoBase INT,
    IN p_incrementoAnual INT,
    IN p_productividad INT
)
BEGIN
    -- Añade datos del salario a la tabla Salario
    INSERT INTO Salario (puestoTrabajo, sueldoBase, incrementoAnual, productividad)
    VALUES (p_puestoTrabajo, p_sueldoBase, p_incrementoAnual, p_productividad);
END //

DELIMITER ;


#---------------------------------------------------------------------------------------
#	9. Procedimiento despedirTrabajador( Trabajador, Despido )
#---------------------------------------------------------------------------------------
DELIMITER //

CREATE PROCEDURE despedirTrabajador(
    IN p_Trabajador INT,
    IN p_Despido DATE
)
BEGIN
    -- Actualiza la tabla Contratacion para que establezca la fecha de despido para el empleado especificado.
    UPDATE Contratacion
    SET finContratacion = p_Despido
    WHERE Empleado = p_Trabajador;
END //

DELIMITER ;


#---------------------------------------------------------------------------------------
#  10. Procedimiento contratarTrabajador( trabajador, Contrato, Fecha, OficinaTrabajo, Puesto, Jefe )
#---------------------------------------------------------------------------------------
DELIMITER //

CREATE PROCEDURE contratarTrabajador(
    IN p_trabajador INT,
    IN p_contrato VARCHAR(40),
    IN p_fecha DATE,
    IN p_oficinaTrabajo INT,
    IN p_puesto VARCHAR(50),
    IN p_jefe INT
)
BEGIN
    -- Añade un nuevo contrato para el empleado especificado
    INSERT INTO Contratacion (tipoContrato, inicioContratacion, Empleado, Oficina, puestoTrabajo, Jefe)
    VALUES (p_contrato, p_fecha, p_trabajador, p_oficinaTrabajo, p_puesto, p_jefe);
END //

DELIMITER ;

#---------------------------------------------------------------------------------------
#  11. Procedimiento mostrarContratosTrabajador( trabajador )
#---------------------------------------------------------------------------------------
DELIMITER //

CREATE PROCEDURE mostrarContratosTrabajador(
    IN p_trabajador INT
)
BEGIN
    -- Selecciona los contratos del empleado especificado
    SELECT idContratacion, tipoContrato, inicioContratacion, finContratacion, puestoTrabajo
    FROM Contratacion
    WHERE Empleado = p_trabajador;
END //

DELIMITER ;


#---------------------------------------------------------------------------------------
#---------------------------------------------------------------------------------------
#---------------------------------------------------------------------------------------
#	- Agrega todos los datos de la Empresa a la base de datos
CALL agregarDatosEmpresa();
#	- Despide al trabajador/es que desees con fecha de '2024-03-02'
CALL despedirTrabajador(1, '2024-03-02'); -- despide al trabajador con la ID 1
CALL despedirTrabajador(2, '2024-03-02'); -- despide al trabajador con la ID 2
#	- Contrata a ese mismo trabajador/es para realizar un 'Proyecto' como contrato, con fecha de '2024-03-02', asigna una oficina de trabajo, un puesto y un jefe
CALL contratarTrabajador(1, 'Proyecto', '2024-03-02', 1, 'Oficina de Proyectos', 'Desarrollador', NULL);
CALL contratarTrabajador(2, 'Proyecto', '2024-03-02', 1, 'Oficina de Proyectos', 'Desarrollador', NULL);

#	- Despide a un/unos trabajador/es con fecha de '2024-03-12'
 CALL despedirTrabajador(3, '2024-03-12'); -- Despedir al trabajador con la ID 3
CALL despedirTrabajador(4, '2024-03-12'); -- Despedir al trabajador con la ID 4

#	- Contrata a ese mismo trabajador/es para realizar otro 'Proyecto' como contrato, con fecha de '2024-03-14', asigna una oficina de trabajo, un puesto y un jefe
CALL contratarTrabajador(3, 'Proyecto', '2024-03-14', 2, 'Oficina de Proyectos', 'Analista de Datos', NULL);
CALL contratarTrabajador(4, 'Proyecto', '2024-03-14', 2, 'Oficina de Proyectos', 'Desarrollador', NULL);

#	- Despide a ese trabajador/es con fecha de '2024-03-17'
CALL despedirTrabajador(5, '2024-03-17'); -- Despedir al trabajador con ID 5
CALL despedirTrabajador(6, '2024-03-17'); -- Despedir al trabajador con ID 6

#	- Contrata a ese mismo trabajador/es con contrato indefinido, con fecha de '2024-03-20', asigna una oficina de trabajo, un puesto y un jefe
CALL contratarTrabajador(5, 'Contrato indefinido', '2024-03-20', 1, 'Empleado de oficina', 1); -- Contratar al trabajador con ID 5
CALL contratarTrabajador(6, 'Contrato indefinido', '2024-03-20', 1, 'Empleado de oficina', 1); -- Contratar al trabajador con ID 6

#	- Despide a ese trabajador/es con fecha de '2024-03-27'
CALL despedirTrabajador(5, '2024-03-27'); -- Despedir al trabajador con ID 5
CALL despedirTrabajador(6, '2024-03-27'); -- Despedir al trabajador con ID 6

#	- Contrata a ese mismo trabajador/es con contrato indefinido, con fecha de '2024-03-30', asigna una oficina de trabajo, un puesto y un jefe
CALL contratarTrabajador(5, 'Indefinido', '2024-03-30', 2, 'Trabajador de Recursos Humanos', 2); -- Contratar al trabajador con ID 5
CALL contratarTrabajador(6, 'Indefinido', '2024-03-30', 3, 'Trabajador de Nóminas', 3); -- Contratar al trabajador con ID 6

#	- Despide a ese trabajador/es con fecha de '2024-04-12'
CALL despedirTrabajador(5, '2024-04-12'); -- Despedir al trabajador con ID 5
CALL despedirTrabajador(6, '2024-04-12'); -- Despedir al trabajador con ID 6
-- Añade más llamadas si deseas despedir a más empleados

#	- Muestra los Contratos de ese trabajador/es
CALL mostrarContratosTrabajador(5); -- Mostrar los contratos del trabajador con ID 5
CALL mostrarContratosTrabajador(6); -- Mostrar los contratos del trabajador con ID 6

#---------------------------------------------------------------------------------------
#---------------------------------------------------------------------------------------
#---------------------------------------------------------------------------------------


