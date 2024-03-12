<?php
require_once('util.php');

session_start();
unset($_SESSION['nombre']);
unset($_SESSION['cesta']);

//4. Llama a la función que has creado en el punto anterior en cerrar.php.
//Cerramos la sesion antes de redirigir al usuario a la pagina de inicio de sesion
cerrarSesion();

header('Location:login.php');

