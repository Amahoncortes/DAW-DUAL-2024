<?php
// Duración de la cookie para las familias (30 días en segundos)
const DURATION_COOKIE_FAMILIAS = 60 * 60 * 24 * 30;

// Función para gestionar la cookie de las familias
function gestionar_cookie_familia(string $cod_familia)
{
    // Si no existe la cookie "familias", la crea con la primera familia
    if (!isset($_COOKIE["familias"])) {
        setcookie("familias[0]", $cod_familia, time() + DURATION_COOKIE_FAMILIAS);
    } else {
        $familias_array = $_COOKIE["familias"];
        $count_familias = count($familias_array);
        // Busca la familia en el array de familias
        $index_or_found = array_search($cod_familia, $familias_array);

        // Si la familia no existe en la cookie, la añade al final del array
        if ($index_or_found === false) {
            setcookie("familias[$count_familias]", $cod_familia, time() + DURATION_COOKIE_FAMILIAS);
        }
    }
}

// Función para mostrar las familias almacenadas en la cookie
function mostrar_familias()
{
    if (isset($_COOKIE["familias"])) {
        $familias_array = $_COOKIE["familias"];
        echo "<p> Quizá también te interesen productos de estas categorías...</p>";
        echo "<ul>";
        // Muestra cada familia en una lista
        foreach ($familias_array as $index => $cod_familia) {
            echo "<li>$cod_familia</li>";
        }
        echo "</ul>";
    }
}
?>