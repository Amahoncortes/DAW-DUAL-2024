<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejercicio 2</title>
</head>

<body>
    <?php
    $valores_IBEX = [
        "Telefonica" => 5,
        "Santander" => 6,
        "Inditex" => 3,
        "Repsol" => 9,
        "Iberdrola" => 12
    ];

    //Calcular la suma de las subidas
    $suma_subidas = array_sum($valores_IBEX);

    //Calcular la media de las subidas
    $media_subidas = $suma_subidas / count($valores_IBEX);

    foreach ($valores_IBEX as $clave => $valor) {
        echo "Clave: " . $clave . ", Valor: " . $valor . "<br>";
    }

    echo "Media de las subidas: " . $media_subidas . "%";
    ?>
</body>

</html>