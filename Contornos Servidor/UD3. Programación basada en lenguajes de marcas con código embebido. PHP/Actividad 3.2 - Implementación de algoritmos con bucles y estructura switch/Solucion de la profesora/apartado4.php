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

    const VALOR_MIN= 2;
    const PRECISION_COMPARACION = 5;
    $n = 5;

    $suma = 1;
    $ter = 1;

    //posiblidad 1
    // $k = 1;
    // while ($k++ <= $n) {

    //posibilidad 2
    //$k = 0;
    $contador =0;
   


   //https://www.php.net/manual/es/function.bccomp.php
    while (bccomp($suma, VALOR_MIN, PRECISION_COMPARACION)<0)  {
        //for ($k = 1; $k <= $n; $k++) {        
        $ter = $ter / 2;
        echo "<p>Sumando $suma + $ter </p>";
        $suma += $ter;
        echo "<p> El resultado de la suma es: $suma</p>";
        $contador++;
    }
    echo "<p> La suma vale $suma y se alcanza con $contador iteraciones </p>";


    ?>



</body>

</html>