<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejercicio 1</title>
</head>

<body>
    <?php
    /*2- Crea un script php que muestre en un documento HTML 5,
    para un valor x dado,
    la salida de f(x) del algoritmo 5.3 del documento de ejemplo.*/

    $x = 2;
    $f = 0;

    if ($x > 0) {
        $f = $x ** 2;
    }

    echo "El valor de la funcion es ", $f;
    ?>
</body>

</html>