<!DOCTYPE html>
<html lang="en">

<head>
    /*muestre en un documento HTML 5 en una lista desordenada HTML, para un nº n dado resuelva el algoritmo 5.10 del
    mismo documento*/
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Algoritmo 5.10</title>
</head>

<body>
    <?php
    $n = 10;
    
    echo "<ul>Lista de divisores del numero: ", $n;

    for ($i = ($n / 2); $i >= 2; $i--) {
        $resto = $n % $i;
        if ($resto == 0){
            echo "<li>$i</li>";
        }
    }
    echo "<li>1</li></ul>";
    ?>
</body>

</html>