<!DOCTYPE html>
<html lang="en">

<head>
    /*Algoritmo 5.8 Dado un entero, n, calcular la suma de los n primeros numeros impares*/
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Algoritmo 5.8</title>
</head>

<body>
    <?php
    $n = 10;
    $suma = 0;

    for ($i = 1; $i <= 2 * $n - 1; $i += 2) {
        echo "<p> Numero sumado: $suma + $i</p>";
        $suma = $suma +1;
    }
    echo "<p>La suma vale  +$suma </p>";
    ?>
</body>
</html>