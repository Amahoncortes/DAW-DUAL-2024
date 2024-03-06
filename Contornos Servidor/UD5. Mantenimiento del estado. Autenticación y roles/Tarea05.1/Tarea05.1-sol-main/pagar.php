<?php
// Incluye el archivo de utilidades
require_once('util.php');

// Inicia la sesión PHP
session_start();

// Redirige a la página de inicio de sesión si el usuario no ha iniciado sesión
if (!isset($_SESSION['nombre'])) {
    header('Location:login.php');
}
?>
<!doctype html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!-- CSS para usar Bootstrap -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
        integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <!-- CSS Fontawesome CDN-->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
        integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
    <title>Tema 4</title>
</head>

<body style="background: grey">
    <div class="float float-right d-inline-flex mt-2">
        <!-- Icono de usuario -->
        <i class="fas fa-user mr-3 fa-2x"></i>

        <!-- Muestra el nombre de usuario en un campo de texto deshabilitado -->
        <input type="text" size='10px' value="<?php echo $_SESSION['nombre']; ?>" class="form-control
    mr-2 bg-transparent text-white" disabled>

        <!-- Enlace para cerrar sesión -->
        <a href="cerrar.php" class="btn btn-warning mr-2">Salir</a>
    </div>
    <br>
    <h4 class="container text-center mt-4 font-weight-bold">Tienda onLine</h4>
    <div class="container">
        <!-- Mensaje de confirmación del pedido -->
        <p class="font-weight-bold">Pedido realizado Correctamente.</p>

        <!-- Enlace para hacer otra compra -->
        <a href="listado.php" class="btn btn-info mt-3">Hacer otra Compra</a>

        <!-- Muestra las familias de productos -->
        <?php mostrar_familias(); ?>
    </div>

</body>

</html>