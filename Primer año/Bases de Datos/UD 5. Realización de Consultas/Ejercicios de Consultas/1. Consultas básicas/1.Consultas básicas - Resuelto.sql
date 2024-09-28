--Base de datos Tienda Informática

--Muestra los nombres y precios en euros de todos los productos.
SELECT nombre, precio FROM producto;

--Muestra todos los comerciales.
SELECT nombre FROM fabricante;

--Muestra los nombres en mayúsculas  y precios de todos los productos.
SELECT UPPER(nombre), precio FROM PRODUCTO;



--Base de datos Gestión de Empleados

--Muestra los datos de todos los Empleados.
SELECT * FROM empleado;

--Muestra el código y el nombre de todos los departamentos de la empresa.
SELECT codigo, nombre FROM departamento;

-- Muestra los primeros apellidos sin repetición de los Empleados.
SELECT DISTINCT apellido1 FROM empleado;



--Base de datos ventas

-- Muestra todo de todos los clientes
SELECT * FROM cliente;

--Muestra nombre y apellidos de los clientes.
SELECT nombre, apellido1, apellido2 FROM cliente;

-- Muestra todo de todos los comerciales.
SELECT * FROM comercial;

-- Muestra todo de todos los pedidos realizados
SELECT * from pedido;



--Base de datos NBA

-- Muestra todas las tablas de la base de datos NBA
SHOW TABLES FROM nba;

--Muestra todos los datos de cada tabla de la base de datos NBA.
SELECT * from equipos, estadisticas, jugadores, partidos;

-- Muestra el nombre y la división de cada Equipo.
SELECT DISTINCT nombre, division FROM equipos;

-- Muestra el número de tapones por partido de cada jugador y temporada de la tabla Estadisticas.
SELECT jugador, temporada, AVG(tapones_por_partido) AS promedio_tapones_por_partido
FROM estadisticas
GROUP BY jugador, temporada;

--Muestra el nombre y de donde procede de cada Jugador.
SELECT nombre, procedencia FROM jugadores;


--Muestra temporada, equipo local y puntuación, y equipo visitante y puntuación de la tabla Partidos.
SELECT temporada, equipo_local, sum(puntos_local) AS puntuacion_local, equipo_visitante, sum(puntos_visitante) AS puntuacion_visitante
 FROM Partidos
 GROUP BY temporada, equipo_local, equipo_visitante;


--Base de datos DepartamentoOficinas

-- Muestra toda la información de la tabla empleados.
SELECT * FROM empleado;

-- Muestra toda la información de la tabla departamento.
SELECT * FROM dpto_oficinas;

-- Muestra el codigo y nombre de las categorías del personal.
SELECT nombre, numero, categoria FROM empleado;


--Base de datos Jardineria

-- Muestra el nombre del cliente y el nombre completo del contacto.
SELECT nombre_cliente, CONCAT(nombre_contacto, " ", apellido_contacto) AS nombre_completo_contacto
FROM cliente;

-- Muestra los detalles de todos los productos contenidos en la tabla detalle_pedido.
SELECT * FROM detalle_pedido;

-- Muestra el nombre, apellidos, email y puesto de cada empleado.
SELECT CONCAT('nombre', ' ' , apellido1, ' ', apellido2) AS nombre_completo, email, puesto
FROM empleado;

-- Muestra el tipo de gama de producto y su descripción.
SELECT gama, descripcion_texto AS descripcion_producto FROM gama_producto;

-- Muestra el código de cada oficina junto con la ciudad en la que está.
SELECT codigo_oficina, ciudad  FROM oficina;

-- Muestra el detalle de todos los pagos.
SELECT * from pago;

-- Muestra el detalle de todos los pedidos.
SELECT * from pedido;

-- Muestra el detalle de todos los productos, salvo su codigo.
SELECT nombre, gama, dimensiones, proveedor, descripcion, cantidad_en_stock, precio_venta, precio_proveedor FROM producto;