<?php
// Inicia la sesión PHP
session_start();

// Elimina las variables de sesión asociadas al usuario
unset($_SESSION['nombre']);
unset($_SESSION['cesta']);

// Redirige a la página de inicio de sesión
header('Location:login.php');

