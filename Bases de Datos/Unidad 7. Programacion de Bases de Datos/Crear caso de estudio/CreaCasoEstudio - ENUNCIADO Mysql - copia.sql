#---------------------------------------------------------------------------------------
#	CREACIÓN DE LA BASE DE DATOS Empresa
#---------------------------------------------------------------------------------------
DROP DATABASE IF EXISTS Empresa;
CREATE DATABASE Empresa;
USE Empresa;

#------------------------------------------------------------------------------------------------------
#  BORRAMOS LAS TABLAS EXISTENTES PARA EVITAR CONFLICTOS
#------------------------------------------------------------------------------------------------------
DROP TABLE IF EXISTS oficinas, familias, agentes;
DROP TABLE IF EXISTS oficinasCopia, familiasCopia, agentesCopia;
DROP TABLE IF EXISTS oficinasOLD, familiasOLD, agentesOLD;

#------------------------------------------------------------------------------------------------------
#  CREAMOS LAS TABLAS
#------------------------------------------------------------------------------------------------------
CREATE TABLE oficinas (
    identificador     INT,
    nombre           VARCHAR(40),
    domicilio        VARCHAR(40),
    localidad        VARCHAR(20),
    codigo_postal    VARCHAR(5),
    CONSTRAINT PK_oficinas PRIMARY KEY (identificador),
    CONSTRAINT UQ_oficinas_nombre UNIQUE (nombre),
    CONSTRAINT oficinas_nombre_NULO CHECK (nombre IS NOT NULL)
);

CREATE TABLE familias (
    identificador    INT,
    nombre           VARCHAR(40),
    familia          INT,
    oficina          INT,
    CONSTRAINT PK_familias PRIMARY KEY (identificador),
    CONSTRAINT FK_familias_familias FOREIGN KEY (familia) REFERENCES familias(identificador) ON DELETE CASCADE,
    CONSTRAINT FK_familias_oficinas FOREIGN KEY (oficina) REFERENCES oficinas(identificador) ON DELETE CASCADE,
    CONSTRAINT UQ_familias_nombre UNIQUE (nombre),
    CONSTRAINT familia_nombre_NULO CHECK (nombre IS NOT NULL)
);

CREATE TABLE agentes (
    identificador    INT,
    nombre           VARCHAR(60),
    usuario          VARCHAR(20),
    clave            VARCHAR(20),
    habilidad        INT,
    categoria        INT,
    familia          INT,
    oficina          INT,
    CONSTRAINT PK_agentes PRIMARY KEY (identificador),
    CONSTRAINT FK_agentes_familias FOREIGN KEY (familia) REFERENCES familias(identificador) ON DELETE CASCADE,
    CONSTRAINT FK_agentes_oficinas FOREIGN KEY (oficina) REFERENCES oficinas(identificador) ON DELETE CASCADE,
    CONSTRAINT UQ_agentes_usuario UNIQUE (usuario),
    CONSTRAINT agentes_nombre_NULO CHECK (nombre IS NOT NULL),
    CONSTRAINT agentes_usuario_NULO CHECK (usuario IS NOT NULL),
    CONSTRAINT agentes_clave_NULA CHECK (clave IS NOT NULL),
    CONSTRAINT agentes_habilidad_NULA CHECK (habilidad IS NOT NULL),
    CONSTRAINT agentes_categoria_NULA CHECK (categoria IS NOT NULL)
);

#------------------------------------------------------------------------------------------------------
#  CREAMOS LAS TABLAS COPIA Y LAS TABLAS OLD, A PARTIR DE LAS TABLAS RECIÉN CREADAS
#   EJEMPLO: oficinas, oficinasCopia y oficinasOLD
#------------------------------------------------------------------------------------------------------
CREATE TABLE oficinasCopia AS SELECT * FROM oficinas;
CREATE TABLE familiasCopia AS SELECT * FROM familias;
CREATE TABLE agentesCopia AS SELECT * FROM agentes;

CREATE TABLE oficinasOLD LIKE oficinas;
CREATE TABLE familiasOLD LIKE familias;
CREATE TABLE agentesOLD LIKE agentes;

#------------------------------------------------------------------------------------------------------
#------------------------------------------------------------------------------------------------------


#------------------------------------------------------------------------------------------------------
#------------------------------------------------------------------------------------------------------
#  GUIONES - ES LA SECUENCIA DE INSTRUCCIONES QUE APARECEN EN ESTE DOCUMENTO
#------------------------------------------------------------------------------------------------------
#------------------------------------------------------------------------------------------------------
# Secuencia de instrucciones que se ejecutarán de forma ordenada


#------------------------------------------------------------------------------------------------------
#------------------------------------------------------------------------------------------------------
#  PROCEDIMIENTOS
#------------------------------------------------------------------------------------------------------
#------------------------------------------------------------------------------------------------------
#   - Procedimiento para añadir los datos de una nueva Oficina
#------------------------------------------------------------------------------------------------------
DELIMITER //
DROP PROCEDURE IF EXISTS agregarOficina //
CREATE PROCEDURE agregarOficina ( 
    id      INT,
    Nom     VARCHAR(40),
    Dom     VARCHAR(40),
    Loc     VARCHAR(20),
    CP      VARCHAR(5) ) 
BEGIN
    INSERT INTO oficinas (identificador, nombre, domicilio, localidad, codigo_postal) 
        VALUES (id, Nom, Dom, Loc, CP);
END;
// DELIMITER ;
#------------------------------------------------------------------------------------------------------
#   - Procedimiento para añadir los datos todas las oficinas en función del procedimiento creado previamente
#------------------------------------------------------------------------------------------------------
DELIMITER //
DROP PROCEDURE IF EXISTS agregarOficinas //
CREATE PROCEDURE agregarOficinas()
BEGIN
    CALL agregarOficina(1, 'Madrid', 'Gran vía, 37', 'Madrid', '28000');
    CALL agregarOficina(2, 'Barcelona', 'Diagonal, 123', 'Barcelona', '08000');
    CALL agregarOficina(3, 'Sevilla', 'Calle Sierpes, 5', 'Sevilla', '41000');
END;
// DELIMITER ;
#------------------------------------------------------------------------------------------------------
#   - Procedimiento para añadir los datos de una nueva Familia
#------------------------------------------------------------------------------------------------------
DELIMITER //
CREATE PROCEDURE agregarFamilia (
    id INT,
    Nom VARCHAR(40),
    Fam INT,
    Ofi INT
) 
BEGIN
    INSERT INTO familias (identificador, nombre, familia, oficina) 
    VALUES (id, Nom, Fam, Ofi);
END;
//

#------------------------------------------------------------------------------------------------------
#   - Procedimiento para añadir los datos todas las familias en función del procedimiento creado previamente
#------------------------------------------------------------------------------------------------------
DELIMITER //
DROP PROCEDURE IF EXISTS agregarFamilias //
CREATE PROCEDURE agregarFamilias()
BEGIN
    CALL agregarFamilia(10, 'Familia-1', NULL, 1);
    CALL agregarFamilia(11, 'Madrid-1', NULL, 1);
    CALL agregarFamilia(12, 'Familia-2', NULL, 1);
    -- añade aquí los datos de las demás familias
END;
// DELIMITER ;
DELIMITER ;
#------------------------------------------------------------------------------------------------------
#   - Procedimiento para añadir los datos de un nuevo agente
#------------------------------------------------------------------------------------------------------
DELIMITER //

DROP PROCEDURE IF EXISTS agregarAgente //

CREATE PROCEDURE agregarAgente (
    IN id INT,
    IN nombreAgente VARCHAR(60),
    IN usuarioAgente VARCHAR(20),
    IN claveAgente VARCHAR(20),
    IN habilidadAgente INT,
    IN categoriaAgente INT,
    IN familiaPerteneciente INT,
    IN oficinaAsociada INT
)
BEGIN
    INSERT INTO agentes (identificador, nombre, usuario, clave, habilidad, categoria, familia, oficina)
    VALUES (id, nombreAgente, usuarioAgente, claveAgente, habilidadAgente, categoriaAgente, familiaPerteneciente, oficinaAsociada);
END;
// DELIMITER ;

#------------------------------------------------------------------------------------------------------
#   - Procedimiento para añadir los datos todos los agentes en función del procedimiento creado previamente
#------------------------------------------------------------------------------------------------------
DELIMITER //
DROP PROCEDURE IF EXISTS agregarAgentes //
CREATE PROCEDURE agregarAgentes()
BEGIN
    CALL agregarAgente(101, 'Agente-1', 'agente1', 'clave1', 1, 1, 10, 1);
    CALL agregarAgente(102, 'Agente-2', 'agente2', 'clave2', 2, 1, 10, 1);
    CALL agregarAgente(103, 'Agente-3', 'agente3', 'clave3', 1, 2, 11, 2);
    -- añade aquí los datos de los demás agentes
END;
// DELIMITER ;

#------------------------------------------------------------------------------------------------------
#------------------------------------------------------------------------------------------------------

#------------------------------------------------------------------------------------------------------
#------------------------------------------------------------------------------------------------------
#  FUNCIONES
#------------------------------------------------------------------------------------------------------
#  Función que devuelve el número de miembros de una familia dado su identificador
#------------------------------------------------------------------------------------------------------
DELIMITER //
CREATE FUNCTION miembrosFamilia (famId INT) 
RETURNS INT
BEGIN
    DECLARE miembros INT;
    SELECT COUNT(*) INTO miembros FROM agentes WHERE familia = famId;
    RETURN miembros;
END;
//
DELIMITER ;

#------------------------------------------------------------------------------------------------------
#  Función que devuelve el nombre de una familia dado su identificador
#------------------------------------------------------------------------------------------------------
DELIMITER //
CREATE FUNCTION nombreFamilia (famId INT) 
RETURNS VARCHAR(40)
BEGIN
    DECLARE famNombre VARCHAR(40);
    SELECT nombre INTO famNombre FROM familias WHERE identificador = famId;
    RETURN famNombre;
END;
//
DELIMITER ;
#------------------------------------------------------------------------------------------------------
#------------------------------------------------------------------------------------------------------

#------------------------------------------------------------------------------------------------------
#------------------------------------------------------------------------------------------------------
#  PROCEDIMIENTOS SIMPLES
#------------------------------------------------------------------------------------------------------
#------------------------------------------------------------------------------------------------------
#  Procedimiento que muestra los datos de todas las oficinas
#------------------------------------------------------------------------------------------------------

DELIMITER //
	DROP PROCEDURE IF EXISTS mostrarOficinas //
	CREATE PROCEDURE mostrarOficinas()
	BEGIN
    SELECT * FROM oficinas;
	END;
// DELIMITER ;

#------------------------------------------------------------------------------------------------------
#  Procedimiento que muestra los datos de todas las familias
#------------------------------------------------------------------------------------------------------
DELIMITER //
	DROP PROCEDURE IF EXISTS mostrarFamilias //
   CREATE PROCEDURE mostrarFamilias()
	BEGIN
    SELECT * FROM familias;
	END;
// DELIMITER ;

#------------------------------------------------------------------------------------------------------
#  Procedimiento que muestra los datos de todos los agentes
#------------------------------------------------------------------------------------------------------
DELIMITER //
	DROP PROCEDURE IF EXISTS mostrarAgentes //
   CREATE PROCEDURE mostrarAgentes()
	BEGIN
    SELECT * FROM agentes;
	END;
// DELIMITER ;

#------------------------------------------------------------------------------------------------------
#------------------------------------------------------------------------------------------------------

#------------------------------------------------------------------------------------------------------
#------------------------------------------------------------------------------------------------------
#  DISPARADORES
#------------------------------------------------------------------------------------------------------
DELIMITER //

#------------------------------------------------------------------------------------------------------
#   - Triggers para actualizar las tablas copia y old
#------------------------------------------------------------------------------------------------------
CREATE TRIGGER copiaOficinas AFTER INSERT ON oficinas
FOR EACH ROW
BEGIN
    INSERT INTO oficinasCopia (identificador, nombre, domicilio, localidad, codigo_postal) 
    VALUES (NEW.identificador, NEW.nombre, NEW.domicilio, NEW.localidad, NEW.codigo_postal);
    INSERT INTO oficinasOLD (identificador, nombre, domicilio, localidad, codigo_postal) 
    VALUES (OLD.identificador, OLD.nombre, OLD.domicilio, OLD.localidad, OLD.codigo_postal);
END;
//

CREATE TRIGGER copiaFamilias AFTER INSERT ON familias
FOR EACH ROW
BEGIN
    INSERT INTO familiasCopia (identificador, nombre, familia, oficina) 
    VALUES (NEW.identificador, NEW.nombre, NEW.familia, NEW.oficina);
    INSERT INTO familiasOLD (identificador, nombre, familia, oficina) 
    VALUES (OLD.identificador, OLD.nombre, OLD.familia, OLD.oficina);
END;
//

CREATE TRIGGER copiaAgentes AFTER INSERT ON agentes
FOR EACH ROW
BEGIN
    INSERT INTO agentesCopia (identificador, nombre, usuario, clave, habilidad, categoria, familia, oficina) 
    VALUES (NEW.identificador, NEW.nombre, NEW.usuario, NEW.clave, NEW.habilidad, NEW.categoria, NEW.familia, NEW.oficina);
    INSERT INTO agentesOLD (identificador, nombre, usuario, clave, habilidad, categoria, familia, oficina) 
    VALUES (OLD.identificador, OLD.nombre, OLD.usuario, OLD.clave, OLD.habilidad, OLD.categoria, OLD.familia, OLD.oficina);
END;
//
DELIMITER ;
#------------------------------------------------------------------------------------------------------
#------------------------------------------------------------------------------------------------------

#------------------------------------------------------------------------------------------------------
#------------------------------------------------------------------------------------------------------
#  CURSORES
#------------------------------------------------------------------------------------------------------
#------------------------------------------------------------------------------------------------------
#   - Cursores para restaurar los datos de las tablas copia y old en caso de ser necesario
#------------------------------------------------------------------------------------------------------
DELIMITER //
CREATE PROCEDURE restaurarDatos ()
BEGIN
    DECLARE done INT DEFAULT FALSE;
    DECLARE id INT;
    DECLARE nom VARCHAR(60);
    DECLARE user VARCHAR(20);
    DECLARE pwd VARCHAR(20);
    DECLARE habilidad INT;
    DECLARE categoria INT;
    DECLARE fam INT;
    DECLARE ofi INT;
    DECLARE cur CURSOR FOR SELECT * FROM agentesOLD;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

    OPEN cur;
    read_loop: LOOP
        FETCH cur INTO id, nom, user, pwd, habilidad, categoria, fam, ofi;
        IF done THEN
            LEAVE read_loop;
        END IF;
        INSERT INTO agentes VALUES (id, nom, user, pwd, habilidad, categoria, fam, ofi);
    END LOOP;
    CLOSE cur;
END;
// DELIMITER ;

#------------------------------------------------------------------------------------------------------
#------------------------------------------------------------------------------------------------------
#  PROCEDIMIENTOS DE GESTIÓN DE DATOS
#------------------------------------------------------------------------------------------------------
#------------------------------------------------------------------------------------------------------
#   - Procedimientos para eliminar y restaurar los datos de las tablas
#------------------------------------------------------------------------------------------------------
DELIMITER //
CREATE PROCEDURE eliminarDatos ()
BEGIN
    DELETE FROM agentes;
    DELETE FROM familias;
    DELETE FROM oficinas;
END;
// DELIMITER ;

DELIMITER //
CREATE PROCEDURE restaurarDatosCopiados ()
BEGIN
    TRUNCATE TABLE agentes;
    TRUNCATE TABLE familias;
    TRUNCATE TABLE oficinas;

    INSERT INTO agentes SELECT * FROM agentesCopia;
    INSERT INTO familias SELECT * FROM familiasCopia;
    INSERT INTO oficinas SELECT * FROM oficinasCopia;
END;
// DELIMITER ;

#------------------------------------------------------------------------------------------------------
#   - Procedimiento para eliminar todos los datos y restaurar los datos copiados
#------------------------------------------------------------------------------------------------------
DELIMITER //
CREATE PROCEDURE eliminarYRestaurarDatos ()
BEGIN
    CALL eliminarDatos();
    CALL restaurarDatosCopiados();
END;
// DELIMITER ;

DELIMITER ;
#------------------------------------------------------------------------------------------------------
#------------------------------------------------------------------------------------------------------

#------------------------------------------------------------------------------------------------------
#------------------------------------------------------------------------------------------------------
#  COMANDOS DE PRUEBA
#------------------------------------------------------------------------------------------------------
#------------------------------------------------------------------------------------------------------

CALL agregarOficinas();
CALL agregarFamilias();
CALL agregarAgentes();

CALL mostrarOficinas();
CALL mostrarFamilias();
CALL mostrarAgentes();

CALL eliminarYRestaurarDatos();

CALL mostrarOficinas();
CALL mostrarFamilias();
CALL mostrarAgentes();
