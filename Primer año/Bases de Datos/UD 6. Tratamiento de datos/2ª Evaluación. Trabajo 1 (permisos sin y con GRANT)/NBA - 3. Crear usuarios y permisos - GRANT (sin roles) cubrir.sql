#--------------------------------------------------------------------------------------------
#	1.	UTILIZAMOS LA BASE DE DATOS 'NBA'
#--------------------------------------------------------------------------------------------
#	USE <base de datos>
#--------------------------------------------------------------------------------------------
USE nba;
#--------------------------------------------------------------------------------------------
#	2. 	BORRAMOS Y CREAMOS LOS USUARIOS: hay 2 Conferencias (East, West) y 3 divisiones en cada una (Atlantic, SouthEast, Central) y (Pacific, SouthWest, NorthWest)
#	Los usuarios serán creados todos con la misma clave 'abc'
#--------------------------------------------------------------------------------------------
#	DROP USER IF EXISTS <usuario>		CREATE USER <usuario>	IDENTIFIED BY <clave>
#--------------------------------------------------------------------------------------------
#	Fulgencio y Fulgencia
#	Guillermino y Guillermina
#	Pancracio y Pancracia
#	Filomeno y Filomena
#	Anaximandro y Anaximandra
#	Romino y Romina
#	Agapito y Agapita
#	Apolonio y Apolonia
#	Luzdivino y Luzdivina
#--------------------------------------------------------------------------------------------
DROP USER IF EXISTS 'Fulgencio', 'Fulgencia'
,'Guillermino', 'Guillermina',
 'Pancracio', 'Pancracia',
'Filomeno', 'Filomena',
'Anaximandro', 'Anaximandra',
'Romino', 'Romina',
'Agapito', 'Agapita',
'Apolonio', 'Apolonia',
'Luzdivino', 'Luzdivina';

CREATE USER 'Fulgencio' IDENTIFIED BY 'abc', 'Fulgencia' IDENTIFIED BY 'abc'
,'Guillermino' IDENTIFIED BY 'abc', 'Guillermina' IDENTIFIED BY 'abc',
 'Pancracio' IDENTIFIED BY 'abc', 'Pancracia' IDENTIFIED BY 'abc',
'Filomeno' IDENTIFIED BY 'abc', 'Filomena' IDENTIFIED BY 'abc',
'Anaximandro' IDENTIFIED BY 'abc', 'Anaximandra' IDENTIFIED BY 'abc',
'Romino' IDENTIFIED BY 'abc', 'Romina' IDENTIFIED BY 'abc',
'Agapito' IDENTIFIED BY 'abc', 'Agapita' IDENTIFIED BY 'abc',
'Apolonio' IDENTIFIED BY 'abc', 'Apolonia' IDENTIFIED BY 'abc',
'Luzdivino' IDENTIFIED BY 'abc', 'Luzdivina' IDENTIFIED BY 'abc';
#--------------------------------------------------------------------------------------------
#	3. BORRAMOS Y CREAMOS LAS VISTAS
#--------------------------------------------------------------------------------------------
#	DROP VIEW IF EXISTS <vista>							CREATE VIEW	<vista>	AS <consulta>
#--------------------------------------------------------------------------------------------
#Vista General de TODOS los Equipos  otra para TODAS las Estadísticas y otra para TODOS los partidos
# Vista General de TODOS los Equipos
DROP VIEW IF EXISTS NBA_EQUIPOS;
CREATE VIEW NBA_EQUIPOS AS SELECT * FROM NBA.equipos;

# Vista General de TODOS los Jugadores
DROP VIEW IF EXISTS NBA_JUGADORES;
CREATE VIEW NBA_JUGADORES AS SELECT * FROM NBA.jugadores;

# Vista General de TODAS las Estadísticas
DROP VIEW IF EXISTS NBA_ESTADISTICAS;
CREATE VIEW NBA_ESTADISTICAS AS SELECT * FROM NBA.estadisticas;

# Vista General de TODOS los Partidos
DROP VIEW IF EXISTS NBA_PARTIDOS;
CREATE VIEW NBA_PARTIDOS AS SELECT * FROM NBA.partidos;

# Vista de Equipos, Jugadores, Estadísticas y Partidos sobre la Conferencia ESTE
DROP VIEW IF EXISTS CONFERENCIA_ESTE_EQUIPOS;
CREATE VIEW CONFERENCIA_ESTE_EQUIPOS AS SELECT * FROM NBA.equipos WHERE Conferencia = 'East';

DROP VIEW IF EXISTS CONFERENCIA_ESTE_JUGADORES;           
CREATE VIEW CONFERENCIA_ESTE_JUGADORES AS SELECT * FROM NBA.jugadores WHERE nombre_equipo IN (SELECT nombre FROM CONFERENCIA_ESTE_EQUIPOS);

DROP VIEW IF EXISTS CONFERENCIA_ESTE_ESTADISTICAS;        
CREATE VIEW CONFERENCIA_ESTE_ESTADISTICAS AS SELECT * FROM NBA.estadisticas WHERE jugador IN (SELECT codigo FROM CONFERENCIA_ESTE_JUGADORES);

DROP VIEW IF EXISTS CONFERENCIA_ESTE_PARTIDOS;
CREATE VIEW CONFERENCIA_ESTE_PARTIDOS AS SELECT * FROM NBA.partidos WHERE equipo_local IN (SELECT nombre FROM CONFERENCIA_ESTE_EQUIPOS) OR equipo_visitante IN(SELECT nombre FROM CONFERENCIA_ESTE_EQUIPOS);


# Vista de Equipos, Jugadores, Estadísticas y Partidos sobre la Conferencia OESTE
DROP VIEW IF EXISTS CONFERENCIA_OESTE_EQUIPOS;
CREATE VIEW CONFERENCIA_OESTE_EQUIPOS AS SELECT * FROM NBA.equipos WHERE Conferencia = 'West';

DROP VIEW IF EXISTS CONFERENCIA_OESTE_JUGADORES;           
CREATE VIEW CONFERENCIA_OESTE_JUGADORES AS SELECT * FROM NBA.jugadores WHERE nombre_equipo IN (SELECT nombre FROM CONFERENCIA_OESTE_EQUIPOS);

DROP VIEW IF EXISTS CONFERENCIA_OESTE_ESTADISTICAS;        
CREATE VIEW CONFERENCIA_OESTE_ESTADISTICAS AS SELECT * FROM NBA.estadisticas WHERE jugador IN (SELECT codigo FROM CONFERENCIA_OESTE_JUGADORES);

DROP VIEW IF EXISTS CONFERENCIA_OESTE_PARTIDOS;
CREATE VIEW CONFERENCIA_OESTE_PARTIDOS AS SELECT * FROM NBA.partidos WHERE equipo_local IN (SELECT nombre FROM CONFERENCIA_OESTE_EQUIPOS) OR equipo_visitante IN(SELECT nombre FROM CONFERENCIA_OESTE_EQUIPOS);


# Vista de Equipos, Jugadores, Estadísticas y Partidos sobre la División Atlantica 
DROP VIEW IF EXISTS DIVISION_ATLANTICA_EQUIPOS;
CREATE VIEW DIVISION_ATLANTICA_EQUIPOS AS SELECT * FROM NBA.equipos WHERE Division = 'Atlantic';

DROP VIEW IF EXISTS DIVISION_ATLANTICA_JUGADORES;           
CREATE VIEW DIVISION_ATLANTICA_JUGADORES AS SELECT * FROM NBA.jugadores WHERE nombre_equipo IN (SELECT nombre FROM DIVISION_ATLANTICA_EQUIPOS);

DROP VIEW IF EXISTS DIVISION_ATLANTICA_ESTADISTICAS;        
CREATE VIEW DIVISION_ATLANTICA_ESTADISTICAS AS SELECT * FROM NBA.estadisticas WHERE jugador IN (SELECT codigo FROM DIVISION_ATLANTICA_JUGADORES);

DROP VIEW IF EXISTS DIVISION_ATLANTICA_PARTIDOS;
CREATE VIEW DIVISION_ATLANTICA_PARTIDOS AS SELECT * FROM NBA.partidos WHERE equipo_local IN (SELECT nombre FROM DIVISION_ATLANTICA_EQUIPOS) OR equipo_visitante IN(SELECT nombre FROM DIVISION_ATLANTICA_EQUIPOS);



# Vista de Equipos, Jugadores, Estadísticas y Partidos sobre la División Sudeste
DROP VIEW IF EXISTS DIVISION_SUDESTE_EQUIPOS;
CREATE VIEW DIVISION_SUDESTE_EQUIPOS AS SELECT * FROM NBA.equipos WHERE Division = 'SouthEast';

DROP VIEW IF EXISTS DIVISION_SUDESTE_JUGADORES;           
CREATE VIEW DIVISION_SUDESTE_JUGADORES AS SELECT * FROM NBA.jugadores WHERE nombre_equipo IN (SELECT nombre FROM DIVISION_SUDESTE_EQUIPOS);

DROP VIEW IF EXISTS DIVISION_SUDESTE_ESTADISTICAS;        
CREATE VIEW DIVISION_SUDESTE_ESTADISTICAS AS SELECT * FROM NBA.estadisticas WHERE jugador IN (SELECT codigo FROM DIVISION_SUDESTE_JUGADORES);

DROP VIEW IF EXISTS DIVISION_SUDESTE_PARTIDOS;
CREATE VIEW DIVISION_SUDESTE_PARTIDOS AS SELECT * FROM NBA.partidos WHERE equipo_local IN (SELECT nombre FROM DIVISION_SUDESTE_EQUIPOS) OR equipo_visitante IN(SELECT nombre FROM DIVISION_SUDESTE_EQUIPOS);



# Vista de Equipos, Jugadores, Estadísticas y Partidos sobre la División Central
DROP VIEW IF EXISTS DIVISION_CENTRAL_EQUIPOS;
CREATE VIEW DIVISION_CENTRAL_EQUIPOS AS SELECT * FROM NBA.equipos WHERE Division = 'Central';

DROP VIEW IF EXISTS DIVISION_CENTRAL_JUGADORES;           
CREATE VIEW DIVISION_CENTRAL_JUGADORES AS SELECT * FROM NBA.jugadores WHERE nombre_equipo IN (SELECT nombre FROM DIVISION_CENTRAL_EQUIPOS);

DROP VIEW IF EXISTS DIVISION_CENTRAL_ESTADISTICAS;        
CREATE VIEW DIVISION_CENTRAL_ESTADISTICAS AS SELECT * FROM NBA.estadisticas WHERE jugador IN (SELECT codigo FROM DIVISION_CENTRAL_JUGADORES);

DROP VIEW IF EXISTS DIVISION_CENTRAL_PARTIDOS;
CREATE VIEW DIVISION_CENTRAL_PARTIDOS AS SELECT * FROM NBA.partidos WHERE equipo_local IN (SELECT nombre FROM DIVISION_CENTRAL_EQUIPOS) OR equipo_visitante IN (SELECT nombre FROM DIVISION_CENTRAL_EQUIPOS);


# Vista de Equipos, Jugadores, Estadísticas y Partidos sobre la División Pacífico
DROP VIEW IF EXISTS DIVISION_PACIFICO_EQUIPOS;
CREATE VIEW DIVISION_PACIFICO_EQUIPOS AS SELECT * FROM NBA.equipos WHERE Division = 'Pacific';

DROP VIEW IF EXISTS DIVISION_PACIFICO_JUGADORES;           
CREATE VIEW DIVISION_PACIFICO_JUGADORES AS SELECT * FROM NBA.jugadores WHERE nombre_equipo IN (SELECT nombre FROM DIVISION_PACIFICO_EQUIPOS);

DROP VIEW IF EXISTS DIVISION_PACIFICO_ESTADISTICAS;        
CREATE VIEW DIVISION_PACIFICO_ESTADISTICAS AS SELECT * FROM NBA.estadisticas WHERE jugador IN (SELECT codigo FROM DIVISION_PACIFICO_JUGADORES);

DROP VIEW IF EXISTS DIVISION_PACIFICO_PARTIDOS;
CREATE VIEW DIVISION_PACIFICO_PARTIDOS AS SELECT * FROM NBA.partidos WHERE equipo_local IN (SELECT nombre FROM DIVISION_PACIFICO_EQUIPOS) OR equipo_visitante IN (SELECT nombre FROM DIVISION_PACIFICO_EQUIPOS);


# Vista de Equipos, Jugadores, Estadísticas y Partidos sobre la División Sudoeste
DROP VIEW IF EXISTS DIVISION_SUDOESTE_EQUIPOS;
CREATE VIEW DIVISION_SUDOESTE_EQUIPOS AS SELECT * FROM NBA.equipos WHERE Division = 'SouthWest';

DROP VIEW IF EXISTS DIVISION_SUDOESTE_JUGADORES;           
CREATE VIEW DIVISION_SUDOESTE_JUGADORES AS SELECT * FROM NBA.jugadores WHERE nombre_equipo IN (SELECT nombre FROM DIVISION_SUDOESTE_EQUIPOS);

DROP VIEW IF EXISTS DIVISION_SUDOESTE_ESTADISTICAS;        
CREATE VIEW DIVISION_SUDOESTE_ESTADISTICAS AS SELECT * FROM NBA.estadisticas WHERE jugador IN (SELECT codigo FROM DIVISION_SUDOESTE_JUGADORES);

DROP VIEW IF EXISTS DIVISION_SUDOESTE_PARTIDOS;
CREATE VIEW DIVISION_SUDOESTE_PARTIDOS AS SELECT * FROM NBA.partidos WHERE equipo_local IN (SELECT nombre FROM DIVISION_SUDOESTE_EQUIPOS) OR equipo_visitante IN (SELECT nombre FROM DIVISION_SUDOESTE_EQUIPOS);


# Vista de Equipos, Jugadores, Estadísticas y Partidos sobre la División Noroeste
DROP VIEW IF EXISTS DIVISION_NOROESTE_EQUIPOS;
CREATE VIEW DIVISION_NOROESTE_EQUIPOS AS SELECT * FROM NBA.equipos WHERE Division = 'NorthWest';

DROP VIEW IF EXISTS DIVISION_NOROESTE_JUGADORES;           
CREATE VIEW DIVISION_NOROESTE_JUGADORES AS SELECT * FROM NBA.jugadores WHERE nombre_equipo IN (SELECT nombre FROM DIVISION_NOROESTE_EQUIPOS);

DROP VIEW IF EXISTS DIVISION_NOROESTE_ESTADISTICAS;        
CREATE VIEW DIVISION_NOROESTE_ESTADISTICAS AS SELECT * FROM NBA.estadisticas WHERE jugador IN (SELECT codigo FROM DIVISION_NOROESTE_JUGADORES);

DROP VIEW IF EXISTS DIVISION_NOROESTE_PARTIDOS;
CREATE VIEW DIVISION_NOROESTE_PARTIDOS AS SELECT * FROM NBA.partidos WHERE equipo_local IN (SELECT nombre FROM DIVISION_NOROESTE_EQUIPOS) OR equipo_visitante IN (SELECT nombre FROM DIVISION_NOROESTE_EQUIPOS);


#--------------------------------------------------------------------------------------------
#	4. ASIGNAMOS PRIVILEGIOS (O PERMISOS) A LOS USUARIOS
#--------------------------------------------------------------------------------------------
#	GRANT <permiso>	ON <vista>	TO <usuario>, ...
#--------------------------------------------------------------------------------------------
#		USUARIOS						ACCESO
#

-- Asignar permisos a Fulgencio y Fulgencia en todas las tablas
GRANT ALL PRIVILEGES ON NBA_EQUIPOS TO 'Fulgencio', 'Fulgencia';
GRANT ALL PRIVILEGES ON NBA_JUGADORES TO 'Fulgencio', 'Fulgencia';
GRANT ALL PRIVILEGES ON NBA_ESTADISTICAS TO 'Fulgencio', 'Fulgencia';
GRANT ALL PRIVILEGES ON NBA_PARTIDOS TO 'Fulgencio', 'Fulgencia';
			
-- Otorgar permisos a Guillermino y Guillermina en todos los datos de Equipos, Jugadores, Estadisticas y Partidos de la Conferencia ESTE
GRANT ALL PRIVILEGES ON CONFERENCIA_ESTE_EQUIPOS TO 'Guillermino', 'Guillermina';
GRANT ALL PRIVILEGES ON CONFERENCIA_ESTE_JUGADORES TO 'Guillermino', 'Guillermina';
GRANT ALL PRIVILEGES ON CONFERENCIA_ESTE_ESTADISTICAS TO 'Guillermino', 'Guillermina';
GRANT ALL PRIVILEGES ON CONFERENCIA_ESTE_PARTIDOS TO 'Guillermino', 'Guillermina';


-- Otorgar permisos a Pancracio y Pancracia en todos los datos de Equipos, Jugadores, Estadisticas y Partidos de la Conferencia Oeste
GRANT ALL PRIVILEGES ON CONFERENCIA_OESTE_EQUIPOS TO 'Pancracio', 'Pancracia';
GRANT ALL PRIVILEGES ON CONFERENCIA_OESTE_JUGADORES TO 'Pancracio', 'Pancracia';
GRANT ALL PRIVILEGES ON CONFERENCIA_OESTE_ESTADISTICAS TO 'Pancracio', 'Pancracia';
GRANT ALL PRIVILEGES ON CONFERENCIA_OESTE_PARTIDOS TO 'Pancracio', 'Pancracia';

-- Otorgar permisos a Filomeno y Filomena en las vistas de la División Atlántica
GRANT ALL PRIVILEGES ON DIVISION_ATLANTICA_EQUIPOS TO 'Filomeno', 'Filomena';
GRANT ALL PRIVILEGES ON DIVISION_ATLANTICA_JUGADORES TO 'Filomeno', 'Filomena';
GRANT ALL PRIVILEGES ON DIVISION_ATLANTICA_ESTADISTICAS TO 'Filomeno', 'Filomena';
GRANT ALL PRIVILEGES ON DIVISION_ATLANTICA_PARTIDOS TO 'Filomeno', 'Filomena';


-- Otorgar todos los permisos a Anaximandro y Anaximandra en las vistas de la División Sudeste
GRANT ALL PRIVILEGES ON DIVISION_SUDESTE_EQUIPOS TO 'Anaximandro', 'Anaximandra';
GRANT ALL PRIVILEGES ON DIVISION_SUDESTE_JUGADORES TO 'Anaximandro', 'Anaximandra';
GRANT ALL PRIVILEGES ON DIVISION_SUDESTE_ESTADISTICAS TO 'Anaximandro', 'Anaximandra';
GRANT ALL PRIVILEGES ON DIVISION_SUDESTE_PARTIDOS TO 'Anaximandro', 'Anaximandra';

-- Otorgar todos los permisos a Romino y Romina en las vistas de la División Central
GRANT ALL PRIVILEGES ON DIVISION_CENTRAL_EQUIPOS TO 'Romino', 'Romina';
GRANT ALL PRIVILEGES ON DIVISION_CENTRAL_JUGADORES TO 'Romino', 'Romina';
GRANT ALL PRIVILEGES ON DIVISION_CENTRAL_ESTADISTICAS TO 'Romino', 'Romina';
GRANT ALL PRIVILEGES ON DIVISION_CENTRAL_PARTIDOS TO 'Romino', 'Romina';

-- Otorgar todos los permisos a Agapito y Agapita en las vistas de la División Pacífico
GRANT ALL PRIVILEGES ON DIVISION_PACIFICO_EQUIPOS TO 'Agapito', 'Agapita';
GRANT ALL PRIVILEGES ON DIVISION_PACIFICO_JUGADORES TO 'Agapito', 'Agapita';
GRANT ALL PRIVILEGES ON DIVISION_PACIFICO_ESTADISTICAS TO 'Agapito', 'Agapita';
GRANT ALL PRIVILEGES ON DIVISION_PACIFICO_PARTIDOS TO 'Agapito', 'Agapita';

-- Otorgar todos los permisos a Apolonio y Apolonia en las vistas de la División Sudoeste
GRANT ALL PRIVILEGES ON DIVISION_SUDOESTE_EQUIPOS TO 'Apolonio', 'Apolonia';
GRANT ALL PRIVILEGES ON DIVISION_SUDOESTE_JUGADORES TO 'Apolonio', 'Apolonia';
GRANT ALL PRIVILEGES ON DIVISION_SUDOESTE_ESTADISTICAS TO 'Apolonio', 'Apolonia';
GRANT ALL PRIVILEGES ON DIVISION_SUDOESTE_PARTIDOS TO 'Apolonio', 'Apolonia';


-- Otorgar todos los permisos a Luzdivino y Luzdivina en las vistas de la División Noroeste
GRANT ALL PRIVILEGES ON DIVISION_NOROESTE_EQUIPOS TO 'Luzdivino', 'Luzdivina';
GRANT ALL PRIVILEGES ON DIVISION_NOROESTE_JUGADORES TO 'Luzdivino', 'Luzdivina';
GRANT ALL PRIVILEGES ON DIVISION_NOROESTE_ESTADISTICAS TO 'Luzdivino', 'Luzdivina';
GRANT ALL PRIVILEGES ON DIVISION_NOROESTE_PARTIDOS TO 'Luzdivino', 'Luzdivina';

#--------------------------------------------------------------------------------------------
#	5. REFRESCAMOS LOS PRIVILEGIOS
#--------------------------------------------------------------------------------------------
#	FLUSH PRIVILEGES;
#--------------------------------------------------------------------------------------------
    FLUSH PRIVILEGES;
