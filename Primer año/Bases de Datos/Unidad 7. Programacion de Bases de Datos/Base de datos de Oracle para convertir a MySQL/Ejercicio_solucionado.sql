#	MySQL
#---------------------------------------------------------------------------------------
#	CREACIÓN DE LA BASE DE DATOS Empresa
#---------------------------------------------------------------------------------------
DROP DATABASE IF EXISTS	Empresa;
CREATE DATABASE			Empresa;
USE						Empresa;
#------------------------------------------------------------------------------------------------------
#  BORRAMOS LAS TABLAS
#------------------------------------------------------------------------------------------------------
DROP TABLE IF EXISTS oficinas;    DROP TABLE IF EXISTS oficinasCopia;
DROP TABLE IF EXISTS familias;    DROP TABLE IF EXISTS familiasCopia;
DROP TABLE IF EXISTS agentes;     DROP TABLE IF EXISTS agentesCopia;

#------------------------------------------------------------------------------------------------------
#  CREAMOS LAS TABLAS
#------------------------------------------------------------------------------------------------------
CREATE TABLE oficinas (
     identificador     	int(6) NOT NULL PRIMARY KEY,
     nombre          	varchar(40) NOT NULL UNIQUE,
     domicilio     		varchar(40),
     localidad     		varchar(20),
     codigo_postal      varchar(5)
);

CREATE TABLE familias (
     identificador     	int(6) NOT NULL PRIMARY KEY,
     nombre          	varchar(40) NOT NULL UNIQUE,
     familia          	int(6) REFERENCES familias,
     oficina          	int(6) REFERENCES oficinas
);

CREATE TABLE agentes (
     identificador     	int(6) NOT NULL PRIMARY KEY,
     nombre          	varchar(60) NOT NULL,
     usuario          	varchar(20) NOT NULL UNIQUE,
     clave          	varchar(20) NOT NULL,
     habilidad     		int(1) NOT NULL,
     categoria     		int(1) NOT NULL,
     familia          	int(6) REFERENCES familias,
     oficina          	int(6) REFERENCES oficinas
);

#------------------------------------------------------------------------------------------------------
#  CREAMOS LAS TABLAS COPIA
#------------------------------------------------------------------------------------------------------
CREATE TABLE oficinasCopia AS SELECT * FROM oficinas;
CREATE TABLE familiasCopia AS SELECT * FROM familias;
CREATE TABLE agentesCopia  AS SELECT * FROM agentes;

#------------------------------------------------------------------------------------------------------
#------------------------------------------------------------------------------------------------------
#  GUIONES
#------------------------------------------------------------------------------------------------------
#------------------------------------------------------------------------------------------------------
# Secuencia de instrucciones que se ejecutarán de forma ordenada

#------------------------------------------------------------------------------------------------------
#------------------------------------------------------------------------------------------------------
#  PROCEDIMIENTOS
#------------------------------------------------------------------------------------------------------
#------------------------------------------------------------------------------------------------------
DELIMITER //
	DROP PROCEDURE IF EXISTS agregarOficina //
	CREATE PROCEDURE agregarOficina ( 
     id      INT,
     Nom     varchar(40),
     Dom     varchar(40),
     Loc     varchar(20),
     CP      varchar(5)	) 
	BEGIN
        INSERT INTO oficinas (identificador, nombre, domicilio, localidad, codigo_postal) 
            VALUES ( id, Nom, Dom, Loc, CP );
	END;
// DELIMITER ;
#------------------------------------------------------------------------------------------------------
DELIMITER //
	DROP PROCEDURE IF EXISTS agregarOficinas //
	CREATE PROCEDURE agregarOficinas()
		BEGIN
			CALL agregarOficina( 1, 'Madrid', 'Gran vía, 37', 'Madrid', '28000' );
			CALL agregarOficina( 2, 'Granada', 'Camino Ronda, 50', 'Granada', '36000' );
			CALL agregarOficina( 3, 'Jaén', 'Gran Eje, 80', 'Jaén', '27000' );
		END;
// DELIMITER ;
#------------------------------------------------------------------------------------------------------
DELIMITER //
DROP PROCEDURE IF EXISTS agregarFamilia //
CREATE PROCEDURE agregarFamilia (
     id     INT,
     Nom    varchar(40),
     Fam    INT,
     Ofi    INT )
BEGIN
	INSERT INTO familias VALUES ( id, Nom, Fam, Ofi );
END; //
DELIMITER ;
#------------------------------------------------------------------------------------------------------
DELIMITER //
DROP PROCEDURE IF EXISTS agregarFamilias //
CREATE PROCEDURE agregarFamilias()
    BEGIN
        call agregarFamilia( 11, 'Madrid-1', NULL, 1 );
        call agregarFamilia( 111, 'Madrid-1.1', 11, NULL );
        call agregarFamilia( 112, 'Madrid-1.2', 11, NULL );
        call agregarFamilia( 1121, 'Madrid-1.2.1', 112, NULL );
        call agregarFamilia( 1122, 'Madrid-1.2.2', 112, NULL );
        call agregarFamilia( 1123, 'Madrid-1.2.3', 112, NULL );
        call agregarFamilia( 21, 'Granada-1', NULL, 2 );
        call agregarFamilia( 211, 'Granada-1.1', 21, NULL );
        call agregarFamilia( 212, 'Granada-1.2', 21, NULL );
        call agregarFamilia( 213, 'Granada-1.3', 21, NULL );
        call agregarFamilia( 31, 'Jaén-1', NULL, 3 );
    END; //
DELIMITER ;
#------------------------------------------------------------------------------------------------------
DELIMITER //
DROP PROCEDURE IF EXISTS agregarAgente //
CREATE PROCEDURE agregarAgente (
     id     int,
     Nom    varchar(60),
     Usu    varchar(20),
     Cla    varchar(20),
     Hab    INT,
     Cat    INT,
     Fam    INT,
     Ofi    INT	)
BEGIN
	INSERT INTO agentes	VALUES ( id, Nom, Usu, Cla, Hab, Cat, Fam, Ofi );
END; //
DELIMITER ;
#------------------------------------------------------------------------------------------------------
#------------------------------------------------------------------------------------------------------
DELIMITER //
DROP PROCEDURE IF EXISTS agregarAgentes //
CREATE PROCEDURE agregarAgentes()
    BEGIN
    CALL agregarAgente( 41, 'María Fernández López', 'mfl', 'sup41', 9, 2, NULL, 4);
    CALL agregarAgente( 412, 'Ricardo Martínez Gómez', 'rmg', 'ag412', 5, 0, 41, NULL);
    CALL agregarAgente( 413, 'Sandra Pérez González', 'spg', 'ag413', 5, 0, 41, NULL);
    CALL agregarAgente( 414, 'Laura Gutiérrez Sánchez', 'lgs', 'ag414', 5, 0, 41, NULL);
    CALL agregarAgente( 415, 'Javier Rodríguez Fernández', 'jrf', 'ag415', 5, 0, 41, NULL);
    CALL agregarAgente( 416, 'Marina Ruiz Alonso', 'mra', 'ag416', 5, 0, 41, NULL);
    CALL agregarAgente( 22, 'Andrea Martínez Pérez', 'amp', 'sup22', 9, 2, NULL, 2);
    CALL agregarAgente( 221, 'Alejandro Gómez Hernández', 'agh', 'ag221', 8, 1, 22, NULL);
    CALL agregarAgente( 222, 'Lucía Sánchez Díaz', 'lsd', 'ag222', 8, 1, 22, NULL);
    CALL agregarAgente( 223, 'Diego Rodríguez Martínez', 'drm', 'ag223', 8, 1, 22, NULL);
    CALL agregarAgente( 224, 'Elena López García', 'elg', 'ag224', 8, 1, 22, NULL);
    CALL agregarAgente( 225, 'Gabriel Pérez Moreno', 'gpm', 'ag225', 8, 1, 22, NULL);
    CALL agregarAgente( 23, 'Raquel Martín Sánchez', 'rms', 'sup23', 9, 2, NULL, 2);
    CALL agregarAgente( 231, 'Carlos Pérez Rodríguez', 'cpr', 'ag231', 8, 1, 23, NULL);
    CALL agregarAgente( 232, 'María José García López', 'mjgl', 'ag232', 8, 1, 23, NULL);
    CALL agregarAgente( 233, 'Jorge Martínez Fernández', 'jmf', 'ag233', 8, 1, 23, NULL);
    CALL agregarAgente( 234, 'Sara Rodríguez Martínez', 'srm', 'ag234', 8, 1, 23, NULL);
    CALL agregarAgente( 235, 'Alberto López González', 'alg', 'ag235', 8, 1, 23, NULL);
    CALL agregarAgente( 24, 'Ana María Pérez Gómez', 'ampg', 'sup24', 9, 2, NULL, 2);
    CALL agregarAgente( 241, 'José Manuel Martínez López', 'jmml', 'ag241', 8, 1, 24, NULL);
    CALL agregarAgente( 242, 'Lorena García Pérez', 'lgp', 'ag242', 8, 1, 24, NULL);
    CALL agregarAgente( 243, 'Miguel Ángel Sánchez Rodríguez', 'masr', 'ag243', 8, 1, 24, NULL);
    CALL agregarAgente( 244, 'María Carmen López García', 'mclg', 'ag244', 8, 1, 24, NULL);
    CALL agregarAgente( 245, 'Pablo Fernández Martínez', 'pfm', 'ag245', 8, 1, 24, NULL);
    CALL agregarAgente( 25, 'Cristina Sánchez Pérez', 'csp', 'sup25', 9, 2, NULL, 2);
    CALL agregarAgente( 251, 'David López Rodríguez', 'dlr', 'ag251', 8, 1, 25, NULL);
    CALL agregarAgente( 252, 'Natalia García Martínez', 'ngm', 'ag252', 8, 1, 25, NULL);
    CALL agregarAgente( 253, 'Javier Pérez Sánchez', 'jps', 'ag253', 8, 1, 25, NULL);
    CALL agregarAgente( 254, 'Carmen Sánchez Fernández', 'csf', 'ag254', 8, 1, 25, NULL);
    CALL agregarAgente( 255, 'Roberto Martínez López', 'rml', 'ag255', 8, 1, 25, NULL);
    CALL agregarAgente( 26, 'Elena Pérez Martínez', 'epm', 'sup26', 9, 2, NULL, 2);
    CALL agregarAgente( 261, 'Víctor Sánchez García', 'vsg', 'ag261', 8, 1, 26, NULL);
    CALL agregarAgente( 262, 'Luisa Martínez Sánchez', 'lms', 'ag262', 8, 1, 26, NULL);
    CALL agregarAgente( 263, 'Daniel Pérez Martínez', 'dpm', 'ag263', 8, 1, 26, NULL);
    CALL agregarAgente( 264, 'María José García Fernández', 'mjgf', 'ag264', 8, 1, 26, NULL);
    CALL agregarAgente( 265, 'Francisco Javier Sánchez Martínez', 'fjsm', 'ag265', 8, 1, 26, NULL);
    CALL agregarAgente( 27, 'Andrés Martínez Pérez', 'amp2', 'sup27', 9, 2, NULL, 2); -- Modified 'amp' to 'amp2'
    CALL agregarAgente( 271, 'Ana García Rodríguez', 'agr', 'ag271', 8, 1, 27, NULL);
    CALL agregarAgente( 272, 'Pedro Martínez García', 'pmg', 'ag272', 8, 1, 27, NULL);
    CALL agregarAgente( 273, 'María Teresa Sánchez Pérez', 'mtsp', 'ag273', 8, 1, 27, NULL);
    CALL agregarAgente( 274, 'Antonio López Martínez', 'alm', 'ag274', 8, 1, 27, NULL);
    CALL agregarAgente( 275, 'Sofía García Martínez', 'sgm', 'ag275', 8, 1, 27, NULL);
    END //
DELIMITER ;
#------------------------------------------------------------------------------------------------------
DELIMITER //
DROP PROCEDURE IF EXISTS agregarDatos //
CREATE PROCEDURE agregarDatos()
    BEGIN
        CALL agregarOficinas();
        CALL agregarFamilias();
        CALL agregarAgentes();
    END; //
DELIMITER ;
#------------------------------------------------------------------------------------------------------
#------------------------------------------------------------------------------------------------------
#  FUNCIONES
#------------------------------------------------------------------------------------------------------
#------------------------------------------------------------------------------------------------------
DELIMITER //
DROP FUNCTION IF EXISTS contarMiembrosFamilia //
CREATE FUNCTION contarMiembrosFamilia( familiaContar varchar(40) ) RETURNS INT
    BEGIN
		DECLARE numMiembros int;
    	
        SELECT COUNT(*) INTO numMiembros FROM agentes WHERE familia = familiaContar;

    	RETURN numMiembros;
    END; //
DELIMITER ;
#------------------------------------------------------------------------------------------------------
#------------------------------------------------------------------------------------------------------
DELIMITER //
DROP FUNCTION IF EXISTS obtenerNombreFamilia //
CREATE FUNCTION obtenerNombreFamilia( idFamilia int ) RETURNS varchar(40)
BEGIN
    DECLARE nombreFamilia varchar(40);
    
    SELECT nombre INTO nombreFamilia FROM familias WHERE identificador = idFamilia;
    	
	IF nombreFamilia IS NULL THEN
        RETURN 'Identificador no válido'; -- Mensaje de identificador no válido
    ELSE
        RETURN nombreFamilia;
    END IF;
    
END; //
DELIMITER ;
#------------------------------------------------------------------------------------------------------
#------------------------------------------------------------------------------------------------------
#  DISPARADORES
#------------------------------------------------------------------------------------------------------
#------------------------------------------------------------------------------------------------------
DELIMITER //
DROP TRIGGER IF EXISTS TRAS_AGREGAR_OFICINA //
CREATE TRIGGER TRAS_AGREGAR_OFICINA
	AFTER INSERT ON oficinas	FOR EACH ROW
BEGIN
    INSERT INTO oficinasCopia VALUES (NEW.identificador, NEW.nombre, NEW.domicilio, NEW.localidad, NEW.codigo_postal);
END; //
DELIMITER ; 
#------------------------------------------------------------------------------------------------------
DELIMITER //
DROP TRIGGER IF EXISTS TRAS_AGREGAR_FAMILIA //
CREATE TRIGGER TRAS_AGREGAR_FAMILIA
	AFTER INSERT ON familias	FOR EACH ROW
BEGIN
    INSERT INTO familiasCopia VALUES (NEW.identificador, NEW.nombre, NEW.familia, NEW.oficina);
END; //
DELIMITER ;
#------------------------------------------------------------------------------------------------------
DELIMITER //
DROP TRIGGER IF EXISTS TRAS_AGREGAR_AGENTE //
CREATE TRIGGER TRAS_AGREGAR_AGENTE
	AFTER INSERT ON agentes		FOR EACH ROW
BEGIN
    INSERT INTO agentesCopia VALUES (NEW.identificador, NEW.nombre, NEW.usuario, NEW.clave, NEW.habilidad, NEW.categoria, NEW.familia, NEW.oficina);
END; //
DELIMITER ;
#------------------------------------------------------------------------------------------------------
DELIMITER //
DROP TRIGGER IF EXISTS TRAS_MODIFICAR_OFICINA //
CREATE TRIGGER TRAS_MODIFICAR_OFICINA
	AFTER UPDATE ON oficinas	FOR EACH ROW
BEGIN
    UPDATE oficinasCopia
    SET nombre = NEW.nombre, domicilio = NEW.domicilio, localidad = NEW.localidad, codigo_postal = NEW.codigo_postal
    	WHERE identificador = OLD.identificador;
END; //
DELIMITER ;
#------------------------------------------------------------------------------------------------------
DELIMITER //
DROP TRIGGER IF EXISTS TRAS_MODIFICAR_FAMILIA //
CREATE TRIGGER TRAS_MODIFICAR_FAMILIA
	AFTER UPDATE ON familias	FOR EACH ROW
BEGIN
    UPDATE familiasCopia
    SET nombre = NEW.nombre, familia = NEW.familia, oficina = NEW.oficina
    	WHERE identificador = OLD.identificador;
END; //
DELIMITER ;
#------------------------------------------------------------------------------------------------------
DELIMITER //
DROP TRIGGER IF EXISTS TRAS_MODIFICAR_AGENTE //
CREATE TRIGGER TRAS_MODIFICAR_AGENTE
	AFTER UPDATE ON agentes	  FOR EACH ROW
BEGIN
    UPDATE agentesCopia
    SET nombre = NEW.nombre, usuario = NEW.usuario, clave = NEW.clave, habilidad = NEW.habilidad, categoria = NEW.categoria, familia = NEW.familia, oficina = NEW.oficina
    	WHERE identificador = OLD.identificador;
END; //
DELIMITER ;
#------------------------------------------------------------------------------------------------------
#------------------------------------------------------------------------------------------------------
#------------------------------------------------------------------------------------------------------
#  CURSORES
#------------------------------------------------------------------------------------------------------
#------------------------------------------------------------------------------------------------------
DELIMITER //
DROP PROCEDURE IF EXISTS mostrarOficinas //
CREATE PROCEDURE mostrarOficinas()
BEGIN
    DECLARE done INT DEFAULT FALSE;
	DECLARE var_id INT;
    DECLARE var_nom VARCHAR(40);
    DECLARE var_dom VARCHAR(40);
    DECLARE var_loc VARCHAR(20);
    DECLARE var_cp VARCHAR(5);
    
     -- Cursor para seleccionar los datos de oficinas
    DECLARE cursor_oficinas CURSOR FOR
        SELECT * FROM oficinas;
     
     -- Manejador para no encontrar más filas
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
   
   -- Creamos una tabla temporal para almacenar los datos
	DROP TEMPORARY TABLE IF EXISTS temp_oficinas;
    CREATE TEMPORARY TABLE temp_oficinas (
        datosOficinas VARCHAR(255)
    );
    
    OPEN cursor_oficinas;
    read_loop: LOOP
			   FETCH cursor_oficinas INTO var_id, var_nom, var_dom, var_loc, var_cp;
               IF done THEN
					LEAVE read_loop;
			   END IF;
        
        -- Mostrar los datos de la fila actual
        INSERT INTO temp_oficinas VALUES (CONCAT('Identificador: ', var_id, ', Nombre: ', var_nom, ', Domicilio: ', var_dom, ', Localidad: ', var_loc, ', Código Postal: ', var_cp));
		END LOOP read_loop;
    CLOSE cursor_oficinas;
   SELECT datosOficinas AS "Datos de las oficinas" FROM temp_oficinas;

END; //
DELIMITER ;
#------------------------------------------------------------------------------------------------------
DELIMITER //
DROP PROCEDURE IF EXISTS mostrarFamilias //
CREATE PROCEDURE mostrarFamilias()
BEGIN
	DECLARE done INT DEFAULT FALSE;
    DECLARE var_id INT;
    DECLARE var_nom VARCHAR(40);
    DECLARE var_fam INT;
    DECLARE var_ofi INT;
    
	 -- Cursor para seleccionar los datos de oficinas
    DECLARE cursor_familias CURSOR FOR
        SELECT * FROM familias;
        
	 -- Manejador para no encontrar más filas
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
    
	-- Creamos una tabla temporal para almacenar los datos
    DROP TEMPORARY TABLE IF EXISTS temp_familias;
    CREATE TEMPORARY TABLE temp_familias (
        datosFamilias VARCHAR(255)
    );
    
    OPEN cursor_familias;
    
    read_loop: LOOP
			   FETCH cursor_familias INTO var_id, var_nom, var_fam, var_ofi;
			   IF done THEN
					LEAVE read_loop;
			   END IF;
        -- Mostrar los datos de la fila actual
        INSERT INTO temp_familias VALUES(CONCAT('Identificador: ', var_id, ', Nombre: ', var_nom, ', Familia: ', IFNULL(var_fam, 'null'), ', Oficina: ', IFNULL(var_ofi, 'null')));
		END LOOP read_loop;
				
    CLOSE cursor_familias;
    SELECT datosFamilias AS "Datos de las familias"  FROM temp_familias;

END; //
DELIMITER ;
#------------------------------------------------------------------------------------------------------
DELIMITER //
DROP PROCEDURE IF EXISTS mostrarAgentes //
CREATE PROCEDURE mostrarAgentes()        
BEGIN
	DECLARE done INT DEFAULT FALSE;
    DECLARE var_id INT;
    DECLARE var_nom VARCHAR(60);
    DECLARE var_usu VARCHAR(20);
    DECLARE var_cla VARCHAR(20);
    DECLARE var_hab INT;
    DECLARE var_cat INT;
    DECLARE var_fam INT;
    DECLARE var_ofi INT;
  
 	 -- Cursor para seleccionar los datos de los agentes
	DECLARE cursor_agentes CURSOR FOR SELECT * FROM agentes;
    
	-- Manejador para no encontrar más filas
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
    
    -- Creamos una tabla temporal para almacenar los datos
	DROP TEMPORARY TABLE IF EXISTS temp_agentes;
    CREATE TEMPORARY TABLE temp_agentes (
        datosAgentes VARCHAR(255)
    );
	
    OPEN cursor_agentes;
    read_loop: LOOP
        FETCH cursor_agentes INTO var_id, var_nom, var_usu, var_cla, var_hab, var_cat, var_fam, var_ofi;
        IF done THEN
            LEAVE read_loop;
        END IF;
        
        -- Mostrar los datos de la fila actual
        INSERT INTO temp_agentes VALUES( CONCAT('Identificador: ', var_id, ', Nombre: ', var_nom, ', Usuario: ', var_usu, ', Clave: ', var_cla, ', Habilidad: ', var_hab, ', Categoría: ', var_cat, ', Familia: ', IFNULL(var_fam, 'null'), ', Oficina: ', IFNULL(var_ofi,'null')));
        END LOOP read_loop;
    CLOSE cursor_agentes;
    SELECT datosAgentes AS "Datos de los agentes" FROM temp_agentes;
    
END; //
DELIMITER ;
#------------------------------------------------------------------------------------------------------
DELIMITER //
DROP PROCEDURE IF EXISTS mostrarDatos //
CREATE PROCEDURE mostrarDatos()
    BEGIN
        call mostrarOficinas();
        call mostrarFamilias();
        call mostrarAgentes();
    END; //
DELIMITER ;
#------------------------------------------------------------------------------------------------------
#------------------------------------------------------------------------------------------------------

CALL agregarDatos();
CALL mostrarDatos();
select obtenerNombreFamilia( 10 );
CALL mostrarOficinas();