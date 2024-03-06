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
    $n = 5;
    $suma = 1;
    $ter = 1;

    for ($k = 1; $k <= $n ; $k++) {
        $ter = $ter / 2;
        echo "<p>Sumando $suma + $ter </p>";
    $suma += $ter;
    }
    echo "La suma vale $suma";
    ?>
</body>
</html>