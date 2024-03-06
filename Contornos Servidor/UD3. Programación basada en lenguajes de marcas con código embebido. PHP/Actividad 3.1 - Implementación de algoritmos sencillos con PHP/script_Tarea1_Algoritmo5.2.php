<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejercicio 1</title>
</head>

<body>
    <?php
    /*1- Crea un script php que muestre en un documento HTML 5,
     para una altura de cm dada,
      el número de pulgadas y de pies que le corresponda
    (Algoritmo 5.2 del documento adjunto)*/
    const RATIO_PULGADAS_ALTURA = 2.54;
    const RATIO_PIES_PULGADAS = 12;
    $altura = 172;
    $pulgadas = $altura / RATIO_PULGADAS_ALTURA;
    $pies = $pulgadas / RATIO_PIES_PULGADAS;
    echo "<p> La altura de $altura en centimetros es de $pulgadas pulgadas y la altura en pies es $pies  </p>"
    ?>
</body>

</html>