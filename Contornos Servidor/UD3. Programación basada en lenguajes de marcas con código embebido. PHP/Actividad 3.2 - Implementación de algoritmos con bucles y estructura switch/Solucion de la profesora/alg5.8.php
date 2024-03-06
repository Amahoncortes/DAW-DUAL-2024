<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>A2.2 Alg 5.8</title>
</head>

<body>
    <?php
    echo "Ingresa un número: ";
    fscanf(STDIN, "%d", $n);
    //Para ejecutar el script en el terminal de VS Code 
    //  php .\alg5.8.php

    // $n = 10;
    $suma = 0;


    for ($i = 1; $i <= 2 * $n - 1; $i += 2) {
        echo "<p>Sumando $suma + $i </p>";
        // diferentes sintaxis  para el mismo cometido
        //$suma = $suma+$i;
        $suma += $i;
    }
    echo "<p> La suma vale $suma </p>";


    ?>



</body>

</html>