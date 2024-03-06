<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>A2.2 Alg 5.8</title>
</head>

<body>
    <?php
    // echo "Ingresa un número: ";
    // fscanf(STDIN, "%d", $n);
    //Para ejecutar el script en el terminal
    //  php .\alg5.9.php

    $n = 5;

    $suma = 1;
    $ter = 1;

    for ($k = 1; $k <= $n; $k++) {        
        $ter = $ter / 2;
        echo "<p>Sumando $suma + $ter </p>";
        $suma+=$ter;
    }
    echo "<p> La suma vale $suma </p>";


    ?>



</body>

</html>