<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejercicio 3</title>
</head>

<body>
    <?php
    $numero = -3;
    $arrayNumeros = [];

    if ($numero > 0) {
        for ($i = 0; $i <= $numero; $i++) {
            # code...
            $arrayNumeros[] = $i;
        }
    } else if ($numero <= 0) {
        for ($i = 0; $i >= $numero; $i--) {
            $arrayNumeros[] = $i;
        }
    }

    //Mostrar código organizado
    echo "<pre>";
    print_r($arrayNumeros);
    echo "</pre>";
    ?>
</body>

</html>