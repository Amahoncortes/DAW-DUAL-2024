<?php
const DURATION_COOKIE_FAMILIAS = 60 * 60 * 24 * 30;

/**
 * Ejercicio 3 apartado c)
 */
function gestionar_cookie_familia(string $cod_familia)
{

    if (!isset($_COOKIE["familias"])) {
        setcookie("familias[0]", $cod_familia, time() + DURATION_COOKIE_FAMILIAS);
    } else {
        $familias_array = $_COOKIE["familias"];
        $count_familias = count($familias_array);
        $index_or_found = array_search($cod_familia, $familias_array);
        if ($index_or_found === false) {
            //non existe a familia
            $nombre_cookie = "familias[$count_familias]";
            setcookie($nombre_cookie, $cod_familia, time() + DURATION_COOKIE_FAMILIAS);

            //c) Marcamos la cookie como borrada desde el servidor

            setcookie($nombre_cookie . "_deleted", 1, time() + DURATION_COOKIE_FAMILIAS);
        }

    }

}

function mostrar_familias() {
    if(isset($_COOKIE["familias"])){
        $familias_array = $_COOKIE["familias"];
        echo "<p>Quizá también te interesen productos de estas categorías...</p>";
        echo "<ul>";
        foreach ($familias_array as $index => $cod_familia) {
            if (!isset($_COOKIE["familias[$index]_deleted"])) {
                echo "<li>$cod_familia</li>";
            }
        }
        echo "</ul>";
    }
}

// util.php

function vaciarCesta()
{
    if (isset($_SESSION['cesta'])) {
        unset($_SESSION['cesta']);
    }
}

function cerrarSesion()
{
    //Eliminamos todas las variables de sesion
    session_unset();
    //Destruimos la sesion y la cookie asociada
    session_destroy();
}

