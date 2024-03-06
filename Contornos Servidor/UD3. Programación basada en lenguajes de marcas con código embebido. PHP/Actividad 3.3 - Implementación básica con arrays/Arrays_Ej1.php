<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ejercicio 1</title>
</head>

<body>
    <?php
    const PAGO_HORA_EXTRA = 12.5;
    $suma = 0;

    $horas_extra_semana = [3.5, 4, 0, 0, 0, 2, 7];

    for ($i = 0; $i < count($horas_extra_semana); $i++) {
        $suma += $horas_extra_semana[$i] * PAGO_HORA_EXTRA;
    }

    echo "<p> El pago de horas extra semanales es de $suma €</p>";
    ?>
</body>

</html>