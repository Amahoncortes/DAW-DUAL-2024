<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <?php
    $n = 11;
    echo "<ul>Lista de divisores del número $n";
    //Si queréis aseguraros de que se convierte a un int
    //(int) ($n/2)
    //intval($n/2)
    //Sería equivalente a no poner nada porque float convertido implícitamente a int
    //se redondea hacia cero
    //https://www.php.net/manual/en/language.types.integer.php#language.types.integer.casting
    for ($i = ($n / 2); $i >= 2; $i--) {
        if(($n % $i) == 0){
            echo "<li>$i</li>";
        }
    }
    echo "<li>1</li></ul>";

    ?>
</body>

</html>