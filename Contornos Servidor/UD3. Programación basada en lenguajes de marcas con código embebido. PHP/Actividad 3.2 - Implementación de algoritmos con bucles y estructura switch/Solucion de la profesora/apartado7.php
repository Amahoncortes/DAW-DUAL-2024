<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <?php

    $calificacion = 6.9;
    //Haciendo conversión a entero con (int) o intval()
    switch (intval($calificacion)) {
        case 10:
            echo "<p>Matrícula de honor</p>";
            break;
        case 9:
            echo "<p>Sobresaliente</p>";
            break;
        case 8:
        case 7:
            echo "<p> Notable </p>";
            break;
        case 6:
        case 5:
            echo "<p> Aprobado </p>";
            break;
        default:
            echo "<p> Suspenso </p>";
            break;
        
    }

    ?>
</body>

</html>