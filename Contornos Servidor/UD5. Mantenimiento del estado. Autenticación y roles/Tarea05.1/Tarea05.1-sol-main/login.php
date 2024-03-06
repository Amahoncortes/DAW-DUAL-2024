<?php
// Inicia la sesión PHP
session_start();

// Requiere el archivo de conexión a la base de datos
require_once 'conexion.php';

// Función para manejar errores y redireccionar al formulario de login
function error($mensaje)
{
    $_SESSION['error'] = $mensaje;
    header('Location: login.php');
    die();
}
?>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap CDN -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
        integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <!--Fontawesome CDN-->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
        integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
    <title>Login</title>
</head>

<body style="background:silver;">
    <?php
    // Verifica si se envió el formulario de inicio de sesión
    if (isset($_POST['login'])) {
        // Obtiene y limpia los datos del formulario
        $nombre = trim($_POST['usuario']);
        $pass = trim($_POST['pass']);

        // Verifica que el nombre de usuario y la contraseña no estén vacíos
        if (strlen($nombre) == 0 || strlen($pass) == 0) {
            error("Error, El nombre o la contraseña no pueden contener solo espacios en blancos.");
        }

        // Crea el hash SHA-256 de la contraseña para comparar con la base de datos
        $pass1 = hash('sha256', $pass);

        // Prepara la consulta SQL para verificar las credenciales del usuario
        $consulta = "SELECT * FROM usuarios WHERE usuario=:u AND pass=:p";
        $stmt = $conProyecto->prepare($consulta);

        // Ejecuta la consulta y maneja errores de base de datos
        try {
            $stmt->execute([
                ':u' => $nombre,
                ':p' => $pass1
            ]);
        } catch (PDOException $ex) {
            cerrarTodo($conProyecto, $stmt);
            error("Error en la consulta a la base de datos.");
        }

        // Verifica si las credenciales son válidas
        if ($stmt->rowCount() == 0) {
            unset($_POST['login']);
            cerrarTodo($conProyecto, $stmt);
            error("Error, Nombre de usuario o contraseña incorrecto");
        }

        // Cierra la conexión y continúa con la sesión de usuario válida
        cerrarTodo($conProyecto, $stmt);
        $_SESSION['nombre'] = $nombre;
        header('Location: listado.php');
    } else {
        ?>
        <!-- Formulario de inicio de sesión -->
        <div class="container mt-5">
            <div class="d-flex justify-content-center h-100">
                <div class="card">
                    <div class="card-header">
                        <h3>Login</h3>
                    </div>
                    <div class="card-body">
                        <form name='login' method='POST' action='<?php echo $_SERVER['PHP_SELF']; ?>'>
                            <div class="input-group form-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="fas fa-user"></i></span>
                                </div>
                                <input type="text" class="form-control" placeholder="usuario" name='usuario' required>
                            </div>
                            <div class="input-group form-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="fas fa-key"></i></span>
                                </div>
                                <input type="password" class="form-control" placeholder="contraseña" name='pass' required>
                            </div>
                            <div class="form-group">
                                <input type="submit" value="Login" class="btn float-right btn-success" name='login'>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <?php
            // Muestra un mensaje de error si existe
            if (isset($_SESSION['error'])) {
                echo "<div class='mt-3 text-danger font-weight-bold text-lg'>";
                echo $_SESSION['error'];
                unset($_SESSION['error']);
                echo "</div>";
            }
            ?>
        </div>
    <?php } ?>
</body>

</html>