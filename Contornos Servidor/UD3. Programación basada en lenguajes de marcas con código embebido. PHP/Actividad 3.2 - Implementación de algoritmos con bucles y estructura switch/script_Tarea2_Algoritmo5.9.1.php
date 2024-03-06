<!DOCTYPE html>
<html lang="en">

<head>
    /*Dado un entero, n, calcular*/
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Algoritmo 5.9</title>
</head>

<body>
    <?php
    const VALOR_MIN = 2;
    $n = 5;
    $suma = 1;
    $ter = 1;
    $k = 0;
    $contador = 0;
    const PRECISION_COMPARACION = 10;


    while (bccomp($suma, VALOR_MIN, PRECISION_COMPARACION)) {
        $ter = $ter / 2;
        echo "<p>Sumando $suma + $ter </p>";
        $suma += $ter;
        $contador++;
    }
    echo "La suma vale $suma y se alcanza con $contador iteraciones";
    ?>
</body>
</html>