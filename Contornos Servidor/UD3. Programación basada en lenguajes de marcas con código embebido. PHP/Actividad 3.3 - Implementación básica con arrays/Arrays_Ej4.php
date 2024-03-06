<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejercicio 4</title>
</head>

<body>
    <?php
    /*4. Dado un número entero positivo del 1 al 10, crea un script que cree un array asociativo con la tabla de multiplicar del número dado. Por ejemplo, si se introduce el 2, el array estará formado por "2x0" => 0, "2x1" => 1, "2x2" =>2, etc. Las claves son cadenas de texto y los valores el resultado. Muestra el array resultado.*/

    $n = 5;
    const TOTAL_NUMEROS = 10;

    //Creación del array 
    $tabla_de_multiplicar = [];

    for ($i = 1; $i <= TOTAL_NUMEROS; $i++) {
        $tabla[" {$n}x{$i}"] = $n * $i;

    }

    echo "<pre>";
    print_r($tabla);
    echo "</pre>";
    ?>
</body>

</html>