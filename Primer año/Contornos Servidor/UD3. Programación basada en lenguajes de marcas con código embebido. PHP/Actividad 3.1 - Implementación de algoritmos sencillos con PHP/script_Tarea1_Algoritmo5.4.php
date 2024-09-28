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
     para unos valores a, b, c dados,
      calcule siguiendo el algoritmo 5.4 del documento de 
      ejemplo.*/

    $a = 5;
    $b = 4;
    $c = 2;

    $d = $b ** 2 - 4 * $a * $c;
    $aa = 2 * $a;

    if ($d >= 0) {

        $dd = sqrt($d);
        $x1 = (-$b + $dd) / $aa;
        $x2 = (-$b - $dd) / $aa;
        echo (" <p> La ecuacion tiene raíces reales: " . round($x1, 2) . " y " . round($x2, 2) . "</p>");
    } else {
        $dd = sqrt(-$d);
        $re = -$b / $aa;
        $im = $dd / $aa;
        echo ("<p>La ecuacion tiene raices complejas conjugadas: ");
        echo ("<p>Parte real:  " . $re);
        echo ("<p>Parte imaginaria: " . $im);
    }
    ?>
</body>

</html>