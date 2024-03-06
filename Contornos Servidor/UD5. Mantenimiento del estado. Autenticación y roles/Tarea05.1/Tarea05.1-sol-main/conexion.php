<?php
// Configuración de la base de datos
$host = "localhost";
$db = "proyecto";
$user = "gestor";
$pass = "secreto";
$dsn = "mysql:host=$host;dbname=$db;charset=utf8mb4";

// Intenta establecer la conexión a la base de datos
try {
    $conProyecto = new PDO($dsn, $user, $pass);
    // Establece el modo de error y excepciones para la conexión
    $conProyecto->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
} catch (PDOException $ex) {
    // Si hay un error en la conexión, muestra un mensaje y termina el script
    die("Error en la conexión: mensaje: " . $ex->getMessage());
}

// Función para consultar un producto por su ID
function consultarProducto($id)
{
    global $conProyecto;
    $consulta = "SELECT * FROM productos WHERE id=:i";
    $stmt1 = $conProyecto->prepare($consulta);

    // Intenta ejecutar la consulta y maneja errores
    try {
        $stmt1->execute([':i' => $id]);
    } catch (PDOException $ex) {
        die("Error al recuperar Productos: " . $ex->getMessage());
    }

    // Recupera el producto (una sola fila)
    $producto = $stmt1->fetch(PDO::FETCH_OBJ);
    // Libera los recursos del statement
    $stmt1 = null;
    return $producto;
}

// Función para cerrar la conexión a la base de datos
function cerrar(&$con)
{
    $con = null;
}

// Función para cerrar tanto la conexión como el statement
function cerrarTodo(&$con, &$st)
{
    $st = null;
    $con = null;
}
