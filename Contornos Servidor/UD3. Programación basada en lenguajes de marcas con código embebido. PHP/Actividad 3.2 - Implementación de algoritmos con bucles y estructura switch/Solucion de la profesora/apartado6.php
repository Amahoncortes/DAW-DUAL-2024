<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <?php
    const NUM_GOAL = 5;
    $contador = 0;
    do {
        $tirada = rand(1, 6);

        echo "<p> La tirada ha obtenido un $tirada </p>";
        $contador++;
    } while ($tirada != NUM_GOAL);

    echo "<p> Hemos necesitado $contador tiradas</p>";


    ?>
</body>

</html>